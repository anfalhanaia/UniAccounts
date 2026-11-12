package patterns;

import model.StudentAccount;

// Composite Pattern: represents one student in the university tree
public class StudentNode implements UniversityComponent {

    private StudentAccount student;

    public StudentNode(StudentAccount student) {
        this.student = student;
    }

    @Override
    public String getName() {
        return student.getFullName();
    }

    @Override
    public int getStudentCount() {
        return 1;
    }

    @Override
    public void display() {
        System.out.println("Student: " + student.getFullName()
                + " | ID: " + student.getId());
    }
}
