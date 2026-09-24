package modern.examples;


/**
 * This is an example of fluent API design, focus on the methods ending with return this;
 * You can chain those methods one after another making it easy to manage.
 * When to use: if you have a class that have so many fields in it, it is hard to keep track of them in a constructor.
 * This idea will be used in streams which we'll see later on this course.
 */
public class Student {

    private String name;
    private int number;
    private int age;
    private String address;
    private String bloodType;
    private String maritalStatus;
    private String gender;
    private int shoeSize;

    public Student(String name, int number, int age, String address, String bloodType,
                   String maritalStatus, String gender, int shoeSize) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.address = address;
        this.bloodType = bloodType;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.shoeSize = shoeSize;
    }

    // More than one constructor for a class is allowed.
    Student(String name, int number) {
        this.setName(name);
        this.setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // This is a fluent API, you can chain those methods.
    public Student setGenderB(String gender) {
        this.gender = gender;
        return this;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Student setShoeSizeB(int shoeSize) {
        this.shoeSize = shoeSize;
        return this;
    }

    public static void main(String[] args) {
        Student jon = new Student("Jon", 42);   //We have created 2 constructors and here we're using the small one.
        jon.setGenderB("male").setShoeSizeB(42).setAddress("Brussels");
        jon.setAddress("Paris");
        jon.setAge(40);
        jon.setAge(41); //
        jon.setAge(42);
        jon.setBloodType("O+");
        jon.setMaritalStatus("Single");
        jon.setShoeSize(42);

        Student gomati = new Student("Gomathi", 15, 20, "Montgomery", "0+", "Married", "female", 34);
        Student kien = new Student("Kien", 10).setGenderB("Man").setShoeSizeB(44);
    }

}
