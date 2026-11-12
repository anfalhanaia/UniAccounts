package patterns;

import model.StudentAccount;
import java.util.Collection;
import java.util.Map;

public interface ExportStrategy {
    String export(Collection<StudentAccount> accounts,
                  Map<String, String> statuses);
}
