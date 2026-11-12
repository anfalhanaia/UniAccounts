package patterns;

public class CafeteriaDecorator extends StudentServiceDecorator {

    public CafeteriaDecorator(StudentServices services) {
        super(services);
    }

    @Override
    public String getDescription() {
        return services.getDescription() + " + Cafeteria";
    }
}
