package patterns;

import model.StudentAccount;

public class BasicStudentServices implements StudentServices {

    private StudentAccount student;

    public BasicStudentServices(StudentAccount student) {
        this.student = student;
    }

    @Override
    public String getDescription() {
        return "Basic account services for " + student.getFullName();
    }
}
