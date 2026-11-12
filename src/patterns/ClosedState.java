package patterns;

// State Pattern: account is permanently closed
public class ClosedState implements AccountState {

    @Override
    public void activate(AccountLifecycle account) {
        System.out.println("Cannot activate a closed account.");
    }

    @Override
    public void suspend(AccountLifecycle account) {
        System.out.println("Cannot suspend a closed account.");
    }

    @Override
    public void close(AccountLifecycle account) {
        System.out.println("Account is already closed.");
    }

    @Override
    public boolean login() {
        System.out.println("Login denied: account is closed.");
        return false;
    }

    @Override
    public String getStatus() {
        return "CLOSED";
    }
}
