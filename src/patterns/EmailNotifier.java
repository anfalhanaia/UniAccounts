package patterns;

import model.StudentAccount;

public class EmailNotifier implements AccountObserver {

    @Override
    public void onEvent(String eventType, StudentAccount account) {
        System.out.println("Email sent to: " + account.getEmail());
        System.out.println("Message: Your account event is " + eventType);
    }
}
