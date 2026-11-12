
package patterns;

import java.util.ArrayList;
import java.util.List;

// Composite Pattern: represents University, Faculty, Department or Group
public class UniversityUnit implements UniversityComponent {

    private String name;

    private List<UniversityComponent> children;

    public UniversityUnit(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    // Add a faculty, department, group or student
    public void add(UniversityComponent component) {
        children.add(component);
    }

    // Remove a component
    public void remove(UniversityComponent component) {
        children.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    // Count all students inside this unit
    @Override
    public int getStudentCount() {

        int total = 0;

        for (UniversityComponent component : children) {
            total += component.getStudentCount();
        }

        return total;
    }

    // Display the complete structure
    @Override
    public void display() {

        System.out.println(name + " - Students: " + getStudentCount());

        for (UniversityComponent component : children) {
            component.display();
        }
    }
}

