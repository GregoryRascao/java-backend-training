

/**
 * 1. Create a Company class that holds a list of Employees.
 * 2. Each Employee has a name and position.
 * 3. Serialize the Company object into "company.ser".
 * 4. Deserialize and display all employee details.
 */

package serialization.exercises;

import java.io.Serializable;
import java.util.List;

public class Exercise4
{
    public class Employee{
        private String name;
        private String position;
        public Employee(String name, String position){
            this.name = name;
            this.position = position;
        }
        @Override 
        public String toString(){
            return "Employee name :" + name + "position is :" + position;
        }
    }
    public class Company implements Serializable{
        List<String> employee;
        public Company{
            this.employee = new ArrayList<>();
        }
        public void addEmployee(Employee employee){
            employee.add(employee);
        }
        public List<Employee> getEmployees(){
            return employee;
        }
    }
    public static void main(String[] args)
    {
       Company company = new Company();
       company.addEmployee(new Employee("Charlotte", "dev"));
       company.addEmployee(new Employee("Gayatri", "dev"));
       company.addEmployee(new Employee("Greg", "dev"));

       String fileName = "company.ser";

               // Serialization
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(company);
            System.out.println("Company saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            Company loadedCompany = (Company) in.readObject();

            for (Employee employee : loadedCompany.getEmployees()) {
                System.out.println(employee);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}