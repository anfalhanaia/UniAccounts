package patterns;

// State Pattern: account is active
public class ActiveState implements AccountState {

    @Override
    public void activate(AccountLifecycle account) {
        System.out.println("Account is already active.");
    }

    @Override
    public void suspend(AccountLifecycle account) {
        account.setState(new SuspendedState());
        System.out.println("Account suspended.");
    }

    @Override
    public void close(AccountLifecycle account) {
        account.setState(new ClosedState());
        System.out.println("Account closed.");
    }

    @Override
    public boolean login() {
        System.out.println("Login successful.");
        return true;
    }

    @Override
    public String getStatus() {
        return "ACTIVE";
    }
}
