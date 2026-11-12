package patterns;

import model.StudentAccount;
import java.util.HashMap;
import java.util.Map;

public class AdminDashboard implements AccountObserver {

    private Map<String, Integer> eventCounts = new HashMap<>();

    @Override
    public void onEvent(String eventType, StudentAccount account) {
        int count = eventCounts.getOrDefault(eventType, 0);
        eventCounts.put(eventType, count + 1);

        System.out.println("Dashboard: " + eventType
                + " count = " + eventCounts.get(eventType));
    }

    public void displayEvents() {
        System.out.println("Admin Dashboard Events:");
        for (String event : eventCounts.keySet()) {
            System.out.println(event + " : " + eventCounts.get(event));
        }
    }
}
