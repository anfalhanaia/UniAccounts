package patterns;

import model.StudentAccount;
import model.AuditLogger;

public class AuditObserver implements AccountObserver {

    @Override
    public void onEvent(String eventType, StudentAccount account) {
        AuditLogger.getInstance().log(
            eventType + " - Student: " + account.getFullName()
            + " - ID: " + account.getId()
        );
    }
}
