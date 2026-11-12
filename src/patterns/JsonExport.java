package patterns;

import model.StudentAccount;
import java.util.Collection;
import java.util.Map;

public class JsonExport implements ExportStrategy {

    @Override
    public String export(Collection<StudentAccount> accounts,
                         Map<String, String> statuses) {

        StringBuilder result = new StringBuilder();
        result.append("[\n");

        int index = 0;

        for (StudentAccount account : accounts) {
            String status = statuses.getOrDefault(
                    account.getId(), "PENDING");

            result.append("  {\n");
            result.append("    \"id\": \"").append(account.getId()).append("\",\n");
            result.append("    \"name\": \"").append(account.getFullName()).append("\",\n");
            result.append("    \"level\": \"").append(account.getLevel()).append("\",\n");
            result.append("    \"status\": \"").append(status).append("\"\n");
            result.append("  }");

            index++;

            if (index < accounts.size()) {
                result.append(",");
            }

            result.append("\n");
        }

        result.append("]");
        return result.toString();
    }
}
