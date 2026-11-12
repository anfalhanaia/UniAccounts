package patterns;

public class LibraryDecorator extends StudentServiceDecorator {

    public LibraryDecorator(StudentServices services) {
        super(services);
    }

    @Override
    public String getDescription() {
        return services.getDescription() + " + Library";
    }
}
