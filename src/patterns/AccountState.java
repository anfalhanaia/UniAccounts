package patterns;

// State Pattern: common interface for account states
public interface AccountState {

    void activate(AccountLifecycle account);

    void suspend(AccountLifecycle account);

    void close(AccountLifecycle account);

    boolean login();

    String getStatus();
}
