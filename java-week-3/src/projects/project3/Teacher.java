package projects.project3;

public class Teacher {
    private final String name;
    private final String subject;

    public Teacher(String name, String subject) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Teacher name cannot be empty.");
        }
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Subject cannot be empty.");
        }

        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return name + " (" + subject + ")";
    }
}
