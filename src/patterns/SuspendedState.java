package patterns;

// State Pattern: account is suspended
public class SuspendedState implements AccountState {

    @Override
    public void activate(AccountLifecycle account) {
        account.setState(new ActiveState());
        System.out.println("Account reactivated.");
    }

    @Override
    public void suspend(AccountLifecycle account) {
        System.out.println("Account is already suspended.");
    }

    @Override
    public void close(AccountLifecycle account) {
        account.setState(new ClosedState());
        System.out.println("Account closed.");
    }

    @Override
    public boolean login() {
        System.out.println("Login denied: account is suspended.");
        return false;
    }

    @Override
    public String getStatus() {
        return "SUSPENDED";
    }
}
