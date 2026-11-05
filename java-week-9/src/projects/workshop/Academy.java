import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Academy {
    Map<Integer, Student> students = new HashMap<>();
    Map<Integer, Workshop> workshops = new LinkedHashMap<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student ID already exists");
        }

        students.put(student.getId(), student);
    }

    public void addWorkshop(Workshop workshop) {
        if (workshop == null) {
            throw new IllegalArgumentException("Workshop cannot be null");
        }

        if (workshops.containsKey(workshop.getId())) {
            throw new IllegalArgumentException("Worshop ID already exists");
        }

        workshops.put(workshop.getId(), workshop);
    }

    public Optional<Student> findStudent(int id) {
        return Optional.ofNullable(students.get(id));
    }

    public Optional<Workshop> findWorkshop(int id) {
        return Optional.ofNullable(workshops.get(id));
    }

    public void register(int studentId, int workshopId) {
        Student student = findStudent(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student ID Unknown: " + studentId));

        Workshop workshop = findWorkshop(workshopId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown workshop ID: " + workshopId));

        workshop.register(student);
    }

    public boolean unregister(int studentId, int workshopId) {
        Student student = findStudent(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student ID Unknown: " + studentId));

        Workshop workshop = findWorkshop(workshopId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown workshop ID: " + workshopId));

        return workshop.unregister(student.getId());
    }

    public List<Student> searchStudents(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Search text cannot be null");
        }

        String query = text.trim().toLowerCase(Locale.ROOT);

        return students.values().stream()
                .filter(student -> query.isEmpty()
                        || student.getName().toLowerCase(Locale.ROOT).contains(query))
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparingInt(Student::getId))
                .toList();
    }

    public List<String> participantNames(int workshopId) {
        Workshop workshop = findWorkshop(workshopId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown workshop ID: " + workshopId));

        return workshop.getParticipants().stream()
                .sorted(Comparator.comparing(Student::getName)
                        .thenComparingInt(Student::getId))
                .map(Student::getName)
                .toList();
    }

    public TreeMap<String, Long> participantCountsByCity(int workshopId) {
        Workshop workshop = findWorkshop(workshopId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown workshop ID: " + workshopId));

        return workshop.getParticipants().stream()
                .collect(Collectors.groupingBy(
                        student -> student.getContactDetails().getCity(),
                        TreeMap::new,
                        Collectors.counting()));
    }

    public TreeSet<String> allCities() {
        return students.values().stream().map(student -> student.getContactDetails().getCity())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<String> buildReport() {
        List<String> report = new ArrayList<>();

        for (Workshop workshop : workshops.values()) {
            if (!report.isEmpty()) {
                report.add("");
            }

            List<Student> participants = workshop.getParticipants();

            report.add(workshop.getTitle() + " | "
                    + participants.size() + "/" + workshop.getCapacity()
                    + " participants");
            report.add(workshop.joiningInstructions());

            for (String name : participantNames(workshop.getId())) {
                report.add("- " + name);
            }
        }

        return report;
    }
}
