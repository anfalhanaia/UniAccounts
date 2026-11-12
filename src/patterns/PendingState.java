package patterns;

// State Pattern: account is waiting for activation
public class PendingState implements AccountState {

    @Override
    public void activate(AccountLifecycle account) {
        account.setState(new ActiveState());
        System.out.println("Account activated.");
    }

    @Override
    public void suspend(AccountLifecycle account) {
        System.out.println("Cannot suspend a pending account.");
    }

    @Override
    public void close(AccountLifecycle account) {
        account.setState(new ClosedState());
        System.out.println("Account closed.");
    }

    @Override
    public boolean login() {
        System.out.println("Login denied: account is pending.");
        return false;
    }

    @Override
    public String getStatus() {
        return "PENDING";
    }
}
