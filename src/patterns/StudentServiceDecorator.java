package patterns;

// Decorator Pattern: base decorator
public abstract class StudentServiceDecorator
        implements StudentServices {

    protected StudentServices services;

    public StudentServiceDecorator(StudentServices services) {
        this.services = services;
    }
}
