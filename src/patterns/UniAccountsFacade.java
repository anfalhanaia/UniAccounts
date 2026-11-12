package patterns;

import model.StudentAccount;
import model.AccountRepository;
import model.LegacyStudentSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Facade Pattern: provides a simple interface to the system
public class UniAccountsFacade {

    private AccountRepository repository;
    private AccountEventManager eventManager;
    private Map<String, AccountLifecycle> lifecycles;

    public UniAccountsFacade() {
        repository = AccountRepository.getInstance();

        eventManager = new AccountEventManager();
        eventManager.addObserver(new AuditObserver());
        eventManager.addObserver(new EmailNotifier());
        eventManager.addObserver(new AdminDashboard());

        lifecycles = new HashMap<>();
    }

    public void createAccount(StudentAccount account) {
        repository.addAccount(account);

        AccountLifecycle lifecycle = new AccountLifecycle();
        lifecycles.put(account.getId(), lifecycle);

        eventManager.notifyObservers("CREATED", account);
    }

    public void activateAccount(String id) {
        StudentAccount account = repository.findById(id);

        if (account != null) {
            lifecycles.get(id).activate();
            eventManager.notifyObservers("ACTIVATED", account);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void suspendAccount(String id) {
        StudentAccount account = repository.findById(id);

        if (account != null) {
            lifecycles.get(id).suspend();
            eventManager.notifyObservers("SUSPENDED", account);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void closeAccount(String id) {
        StudentAccount account = repository.findById(id);

        if (account != null) {
            lifecycles.get(id).close();
            eventManager.notifyObservers("CLOSED", account);
        } else {
            System.out.println("Account not found.");
        }
    }

    public boolean login(String id) {
        if (lifecycles.containsKey(id)) {
            return lifecycles.get(id).login();
        }

        System.out.println("Account not found.");
        return false;
    }

    public String getStatus(String id) {
        if (lifecycles.containsKey(id)) {
            return lifecycles.get(id).getStatus();
        }

        return "NOT FOUND";
    }

    public Collection<StudentAccount> getAllAccounts() {
        return repository.getAllAccounts();
    }

    public String exportAccounts(ExportStrategy strategy) {
        Map<String, String> statuses = new HashMap<>();

        for (StudentAccount account : repository.getAllAccounts()) {
            statuses.put(account.getId(), getStatus(account.getId()));
        }

        return strategy.export(repository.getAllAccounts(), statuses);
    }

    public int importLegacyStudents() {
        int before = repository.getAccountCount();

        LegacyStudentAdapter adapter =
                new LegacyStudentAdapter(new LegacyStudentSystem());

        int imported = adapter.importStudents();

        Collection<StudentAccount> accounts = repository.getAllAccounts();

        for (StudentAccount account : accounts) {
            if (!lifecycles.containsKey(account.getId())) {
                lifecycles.put(account.getId(), new AccountLifecycle());
                eventManager.notifyObservers("IMPORTED", account);
            }
        }

        System.out.println("Imported students: " + imported);
        System.out.println("Previous account count: " + before);

        return imported;
    }
}
