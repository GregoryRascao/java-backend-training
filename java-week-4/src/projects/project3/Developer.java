// 3. **Employee Management System** 🏢

//    * Abstract class: `Employee` (fields: name, salary).
//    * Subclasses: `Developer`, `Manager`.
//    * Store employees in a `List<Employee>`.
//    * Features: print payroll, give raises, list managers separately.

package projects.project3;

public class Developer extends Employee{
    public Developer(String name, int salary){
        super(name, salary);
    }
}
