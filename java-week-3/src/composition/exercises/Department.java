package composition.exercises;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO:
 * 1. Create class Employee with fields: name, role.
 * 2. Create class Department that HAS-A List<Employee>.
 * 3. Create class Company that HAS-A List<Department>.
 * 4. Add methods to:
 * - Add employee to a department
 * - List employees by department
 * 5. Test with multiple departments and employees.
 */

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void listEmployee() {
        System.out.println("Department :" + name);
        for (Employee employee : employees) {
            System.out.println("employee :" + employee.getName());
        }
    }
}

class Company {
    String name;
    List<Department> departments;

    Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "Developer");
        Employee e2 = new Employee("Bob", "Manager");
        Employee e3 = new Employee("Charlie", "Designer");

        Department it = new Department("IT");
        Department hr = new Department("HR");

        it.addEmployee(e1);
        it.addEmployee(e3);
        hr.addEmployee(e2);
    }

}
