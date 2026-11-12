package patterns;

import model.LegacyStudentSystem;
import model.StudentAccount;
import model.AccountRepository;

import java.util.List;

// Adapter Pattern: converts legacy records to StudentAccount
public class LegacyStudentAdapter {

    private LegacyStudentSystem legacySystem;

    public LegacyStudentAdapter(LegacyStudentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public int importStudents() {
        List<String> records = legacySystem.fetchRecords();
        AccountRepository repository = AccountRepository.getInstance();

        int imported = 0;

        for (String record : records) {
            try {
                String[] parts = record.split(";");

                if (parts.length != 5) {
                    System.out.println("Invalid record: " + record);
                    continue;
                }

                String id = parts[0].trim();
                String lastName = parts[1].trim();
                String firstName = parts[2].trim();
                String email = parts[3].trim();
                String level = parts[4].trim();

                String fullName = firstName + " " + lastName;

                StudentAccount account = new StudentAccount.Builder(
                        id, fullName, email)
                        .level(level)
                        .build();

                repository.addAccount(account);
                imported++;

            } catch (IllegalArgumentException e) {
                System.out.println("Record skipped: " + record);
                System.out.println("Reason: " + e.getMessage());
            }
        }

        return imported;
    }
}
