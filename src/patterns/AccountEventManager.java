package patterns;

import model.StudentAccount;
import java.util.ArrayList;
import java.util.List;

// Observer Pattern: notifies all observers
public class AccountEventManager {

    private List<AccountObserver> observers = new ArrayList<>();

    public void addObserver(AccountObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String eventType, StudentAccount account) {
        for (AccountObserver observer : observers) {
            observer.onEvent(eventType, account);
        }
    }
}
