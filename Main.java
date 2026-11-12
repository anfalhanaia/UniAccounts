import model.StudentAccount;
import model.AccountRepository;

import patterns.*;

public class Main {

    public static void main(String[] args) {

        UniAccountsFacade system = new UniAccountsFacade();

        // Builder Pattern: create a student
        StudentAccount student1 = new StudentAccount.Builder(
                "20260001",
                "Ahmed Benali",
                "ahmed@univ.dz")
                .level("L2")
                .major("Informatics")
                .scholarship(true)
                .build();

        // Builder Pattern: create another student
        StudentAccount student2 = new StudentAccount.Builder(
                "20260002",
                "anfal hanaia",
                "anfal@univ.dz")
                .level("M1")
                .major("Computer Science")
                .build();

        // Facade + Observer: create accounts
        system.createAccount(student1);
        system.createAccount(student2);

        System.out.println("\n--- STATE PATTERN ---");

        system.activateAccount("20260001");

        System.out.println("Ahmed status: "
                + system.getStatus("20260001"));

        system.login("20260001");

        system.suspendAccount("20260001");

        System.out.println("Ahmed status: "
                + system.getStatus("20260001"));

        system.login("20260001");

        System.out.println("\n--- COMPOSITE PATTERN ---");

        UniversityUnit university =
                new UniversityUnit("University");

        UniversityUnit faculty =
                new UniversityUnit("Faculty of Technology");

        UniversityUnit department =
                new UniversityUnit("Computer Science Department");

        UniversityUnit group =
                new UniversityUnit("Group 1");

        group.add(new StudentNode(student1));
        group.add(new StudentNode(student2));

        department.add(group);
        faculty.add(department);
        university.add(faculty);

        university.display();

        System.out.println("\nTotal students: "
                + university.getStudentCount());

        System.out.println("\n--- DECORATOR PATTERN ---");

        StudentServices services =
                new BasicStudentServices(student1);

        services = new LibraryDecorator(services);
        services = new CafeteriaDecorator(services);
        services = new InternetDecorator(services);

        System.out.println(services.getDescription());

        System.out.println("\n--- STRATEGY PATTERN: CSV ---");

        CsvExport csv = new CsvExport();

        System.out.println(system.exportAccounts(csv));

        System.out.println("\n--- STRATEGY PATTERN: JSON ---");

        JsonExport json = new JsonExport();

        System.out.println(system.exportAccounts(json));

        System.out.println("\n--- ADAPTER PATTERN ---");

        system.importLegacyStudents();

        System.out.println("\n--- FINAL ACCOUNT COUNT ---");

        System.out.println(
                AccountRepository.getInstance().getAccountCount()
        );

        System.out.println("\n--- PROJECT FINISHED ---");
    }
}
