package patterns;

public class InternetDecorator extends StudentServiceDecorator {

    public InternetDecorator(StudentServices services) {
        super(services);
    }

    @Override
    public String getDescription() {
        return services.getDescription() + " + Internet";
    }
}
