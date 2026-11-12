package patterns;

import model.StudentAccount;

public interface AccountObserver {
    void onEvent(String eventType, StudentAccount account);
}
