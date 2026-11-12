package patterns;

import model.StudentAccount;
import java.util.Collection;
import java.util.Map;

public class CsvExport implements ExportStrategy {

    @Override
    public String export(Collection<StudentAccount> accounts,
                         Map<String, String> statuses) {

        StringBuilder result = new StringBuilder();
        result.append("id,name,level,status\n");

        for (StudentAccount account : accounts) {
            String status = statuses.getOrDefault(
                    account.getId(), "PENDING");

            result.append(account.getId()).append(",");
            result.append(account.getFullName()).append(",");
            result.append(account.getLevel()).append(",");
            result.append(status).append("\n");
        }

        return result.toString();
    }
}
