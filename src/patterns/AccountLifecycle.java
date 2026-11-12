package patterns;

// State Pattern: manages the current state of an account
public class AccountLifecycle {

    private AccountState state;

    public AccountLifecycle() {
        state = new PendingState();
    }

    public void activate() {
        state.activate(this);
    }

    public void suspend() {
        state.suspend(this);
    }

    public void close() {
        state.close(this);
    }

    public boolean login() {
        return state.login();
    }

    public String getStatus() {
        return state.getStatus();
    }

    public void setState(AccountState state) {
        this.state = state;
    }
}
