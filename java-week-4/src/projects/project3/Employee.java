// 3. **Employee Management System** 🏢

//    * Abstract class: `Employee` (fields: name, salary).
//    * Subclasses: `Developer`, `Manager`.
//    * Store employees in a `List<Employee>`.
//    * Features: print payroll, give raises, list managers separately.

package projects.project3;

public abstract class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void giveRaise(double percentage) {
        salary += (int) Math.round(salary * percentage / 100);
    }

    public String toString() {
        return getName() + " have a salary of " + getSalary() + " because he have nothing to hide";
    }

}
