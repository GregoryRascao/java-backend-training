package projects.project3;

public class StudentManagementApplication {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Marie Martin", "Java");
        Course javaCourse = new Course("Java fundamentals", teacher);

        Student alice = new Student("ST-001", "Alice");
        Student bob = new Student("ST-002", "Bob");

        javaCourse.enrollStudent(alice);
        javaCourse.enrollStudent(bob);

        System.out.println("Course: " + javaCourse.getName());
        System.out.println("Teacher: " + javaCourse.getTeacher());
        javaCourse.printStudents();
    }
}
