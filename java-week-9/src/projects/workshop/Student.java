public class Student {
    int id;
    String name;
    ContactDetails contactDetails;

    public Student(int id, String name, ContactDetails contactDetails) {
        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        if (contactDetails == null) {
            throw new IllegalArgumentException("Contact details cannot be null");
        }

        this.id = id;
        this.name = name.trim();
        this.contactDetails = contactDetails;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }
}
