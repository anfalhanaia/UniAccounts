
package patterns;

import model.StudentAccount;

// Prototype Pattern
public class StudentAccountPrototype {

    private StudentAccount template;

    public StudentAccountPrototype(StudentAccount template) {
        this.template = template;
    }

    // Create a new account from the template
    public StudentAccount createStudent(
            String id,
            String fullName,
            String email) {

        return template.clone(id, fullName, email);
    }
}


