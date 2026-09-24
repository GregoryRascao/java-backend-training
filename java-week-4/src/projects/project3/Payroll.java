// 3. **Employee Management System** 🏢

//    * Abstract class: `Employee` (fields: name, salary).
//    * Subclasses: `Developer`, `Manager`.
//    * Store employees in a `List<Employee>`.
//    * Features: print payroll, give raises, list managers separately.

package projects.project3;

import java.util.List;

public class Payroll {
    List<Employee> employees;

    public Payroll(List<Employee> employees) {
        this.employees = employees;
    }

    public void printPayroll() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void giveRaise(Employee employee, double percentage) {
        if (employees.contains(employee)) {
            employee.giveRaise(percentage);
        }
    }

    public void printManagers() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                System.out.println(employee);
            }
        }
    }
}
