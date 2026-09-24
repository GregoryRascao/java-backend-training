// 3. **Employee Management System** 🏢

//    * Abstract class: `Employee` (fields: name, salary).
//    * Subclasses: `Developer`, `Manager`.
//    * Store employees in a `List<Employee>`.
//    * Features: print payroll, give raises, list managers separately.

package projects.project3;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Payroll payroll = new Payroll(employees);

        Employee gregory = new Developer("Grégory", 2800);
        Employee charlotte = new Developer("Charlotte", 2800);
        Employee chitra = new Developer("Chitra", 2800);
        Employee bora = new Manager("Bora", 5400);

        employees.add(gregory);
        employees.add(charlotte);
        employees.add(chitra);
        employees.add(bora);

        System.out.println("Payroll before raises:");
        payroll.printPayroll();

        payroll.giveRaise(gregory, 10);
        payroll.giveRaise(bora, 5);

        System.out.println("\nPayroll after raises:");
        payroll.printPayroll();

        System.out.println("\nManagers:");
        payroll.printManagers();
    }
}
