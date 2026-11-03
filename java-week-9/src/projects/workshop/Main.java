import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Academy academy = new Academy();

        try {
            loadStudents(academy);
            System.out.println("Students loaded.");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Could not load students: " + e.getMessage());
            return;
        }
        Workshop classroom = new ClassroomWorkshop(
                10, "Java Basics", 2, "B12");

        Workshop online = new OnlineWorkshop(
                20, "JUnit Practice", 3, "https://example.com/junit");

        academy.addWorkshop(classroom);
        academy.addWorkshop(online);

        System.out.println("Workshops created.");
        academy.register(1, 10); // Chitrakalpa joins Java Basics
        academy.register(2, 10); // Paul joins Java Basics

        try {
            academy.register(3, 10); // Java Basics is full
        } catch (IllegalStateException e) {
            System.out.println("Expected registration rejection: " + e.getMessage());
        }

        academy.unregister(2, 10); // Removing Paul frees a place
        academy.register(3, 10); // Gayatri takes the freed place

        academy.register(1, 20); // Chitrakalpa joins JUnit Practice
        academy.register(4, 20); // Oleh joins JUnit Practice

        System.out.println("Demonstration registrations complete.");
        List<String> report = academy.buildReport();

        List<ReportOutput> outputs = List.of(
                new ConsoleReportOutput(),
                new FileReportOutput(Path.of("output", "report.txt")));

        try {
            for (ReportOutput output : outputs) {
                output.write(report);
            }
        } catch (IOException e) {
            System.err.println("Could not write report: " + e.getMessage());
        }

        System.out.println("Java participants: " + academy.participantNames(10));
        System.out.println("Java available places: " + classroom.availablePlaces());

        System.out.println("JUnit participants: " + academy.participantNames(20));
        System.out.println("JUnit available places: " + online.availablePlaces());

        System.out.println("JUnit participants by city: "
                + academy.participantCountsByCity(20));
        System.out.println("All student cities: " + academy.allCities());

        System.out.println("Search KAL: "
                + academy.searchStudents("KAL").stream()
                        .map(Student::getName)
                        .toList());
    }

    private static void loadStudents(Academy academy) throws IOException {
        Path inputPath = Path.of(
                "java-week-9",
                "src",
                "projects",
                "workshop",
                "data",
                "students.txt");

        for (String line : SimpleFiles.readLines(inputPath)) {
            if (line.isBlank()) {
                continue;
            }

            String[] fields = line.split(";", -1);
            if (fields.length != 4) {
                throw new IllegalArgumentException(
                        "Expected four columns: " + line);
            }

            int id = Integer.parseInt(fields[0].trim());
            String name = fields[1].trim();
            String email = fields[2].trim();
            String city = fields[3].trim();

            ContactDetails contactDetails = new ContactDetails(email, city);
            Student student = new Student(
                    id,
                    name,
                    contactDetails);

            academy.addStudent(student);
        }
    }
}