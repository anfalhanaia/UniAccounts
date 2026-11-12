
package model;

import java.util.ArrayList;
import java.util.List;

// Singleton Pattern: only one audit logger exists
public class AuditLogger {

    private static AuditLogger instance;

    private List<String> logs;

    // Private constructor
    private AuditLogger() {
        logs = new ArrayList<>();
    }

    // Returns the unique logger instance
    public static AuditLogger getInstance() {

        if (instance == null) {
            instance = new AuditLogger();
        }

        return instance;
    }

    // Record a new event
    public void log(String message) {

        logs.add(message);

        System.out.println("[AUDIT] " + message);
    }

    // Return all recorded events
    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    // Display all recorded events
    public void displayLogs() {

        for (String log : logs) {
            System.out.println(log);
        }
    }
}
