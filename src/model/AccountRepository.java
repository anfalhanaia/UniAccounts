
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

// Singleton Pattern: only one account repository exists
public class AccountRepository {

    private static AccountRepository instance;

    private Map<String, StudentAccount> accounts;

    // Private constructor prevents creating objects from outside
    private AccountRepository() {
        accounts = new LinkedHashMap<>();
    }

    // Returns the unique repository instance
    public static AccountRepository getInstance() {

        if (instance == null) {
            instance = new AccountRepository();
        }

        return instance;
    }

    // Add a student account
    public void addAccount(StudentAccount account) {

        if (accounts.containsKey(account.getId())) {
            throw new IllegalArgumentException("This ID already exists");
        }

        accounts.put(account.getId(), account);
    }

    // Search for an account using its ID
    public StudentAccount findById(String id) {
        return accounts.get(id);
    }

    // Get all student accounts
    public Collection<StudentAccount> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    // Get the number of accounts
    public int getAccountCount() {
        return accounts.size();
    }

    // Remove an account
    public void removeAccount(String id) {
        accounts.remove(id);
    }
}
