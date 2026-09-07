package methods.examples.school.static_school;

public class Student {

    public int age;
    public String name;
    public static String schoolName;

    static void something() {
        schoolName = "asdsa";
//        name = "asdas"; //not valid
    }
}
