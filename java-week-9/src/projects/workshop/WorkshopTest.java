import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {
    @TempDir
    Path tempDir;

    @Test
    void rejectsInvalidCapacityAndBlankStudentName() {
        assertThrows(IllegalArgumentException.class,
                () -> new ClassroomWorkshop(10, "Java Basics", 0, "B12"));

        assertThrows(IllegalArgumentException.class,
                () -> student(1, " ", "Brussels"));
    }

    @Test
    void rejectsDuplicateStudentAndWorkshopIds() {
        Academy academy = new Academy();
        academy.addStudent(student(1, "Chitrakalpa", "Brussels"));

        assertThrows(IllegalArgumentException.class,
                () -> academy.addStudent(student(1, "Paul", "Ghent")));

        academy.addWorkshop(classroom(10, "Java Basics", 2));

        assertThrows(IllegalArgumentException.class,
                () -> academy.addWorkshop(classroom(10, "Another Workshop", 2)));
    }

    @Test
    void registrationAcceptsParticipantsUpToCapacity() {
        Workshop workshop = classroom(10, "Java Basics", 2);
        Student first = student(1, "Chitrakalpa", "Brussels");
        Student second = student(2, "Paul", "Ghent");

        workshop.register(first);
        workshop.register(second);

        assertEquals(List.of(first, second), workshop.getParticipants());
        assertEquals(0, workshop.availablePlaces());
    }

    @Test
    void duplicateRegistrationThrowsWithoutChangingWorkshop() {
        Workshop workshop = classroom(10, "Java Basics", 2);
        Student first = student(1, "Chitrakalpa", "Brussels");
        Student sameId = student(1, "Another Name", "Ghent");

        workshop.register(first);

        assertThrows(IllegalStateException.class,
                () -> workshop.register(sameId));

        assertEquals(List.of(first), workshop.getParticipants());
        assertEquals(1, workshop.availablePlaces());
    }

    @Test
    void fullWorkshopRejectsNextStudentWithoutChangingParticipants() {
        Workshop workshop = classroom(10, "Java Basics", 2);
        Student first = student(1, "Chitrakalpa", "Brussels");
        Student second = student(2, "Paul", "Ghent");
        Student third = student(3, "Gayatri", "Brussels");

        workshop.register(first);
        workshop.register(second);

        assertThrows(IllegalStateException.class,
                () -> workshop.register(third));

        assertEquals(List.of(first, second), workshop.getParticipants());
        assertEquals(0, workshop.availablePlaces());
    }

    @Test
    void nullStudentIsRejected() {
        Workshop workshop = classroom(10, "Java Basics", 2);

        assertThrows(IllegalArgumentException.class,
                () -> workshop.register(null));

        assertTrue(workshop.getParticipants().isEmpty());
    }

    @Test
    void unregisterRemovesMiddleParticipantAndReturnsFalseWhenAbsent() {
        Workshop workshop = classroom(10, "Java Basics", 4);
        Student first = student(1, "Chitrakalpa", "Brussels");
        Student middle = student(2, "Paul", "Ghent");
        Student last = student(3, "Gayatri", "Brussels");

        workshop.register(first);
        workshop.register(middle);
        workshop.register(last);

        assertTrue(workshop.unregister(middle.getId()));
        assertFalse(workshop.unregister(middle.getId()));

        assertEquals(List.of(first, last), workshop.getParticipants());
    }

    @Test
    void unregisteringFreesPlaceAndStudentCanRegisterAgain() {
        Workshop workshop = classroom(10, "Java Basics", 1);
        Student student = student(1, "Chitrakalpa", "Brussels");

        workshop.register(student);
        assertTrue(workshop.unregister(student.getId()));
        assertEquals(1, workshop.availablePlaces());

        workshop.register(student);

        assertEquals(List.of(student), workshop.getParticipants());
        assertEquals(0, workshop.availablePlaces());
    }

    @Test
    void workshopsProvideTheirOwnJoiningInstructionsThroughBaseType() {
        Workshop classroom = classroom(10, "Java Basics", 2);
        Workshop online = new OnlineWorkshop(
                20, "JUnit Practice", 3, "https://example.com/junit");

        assertEquals("Go to room B12.", classroom.joiningInstructions());
        assertEquals(
                "Join at https://example.com/junit.",
                online.joiningInstructions());
    }

    @Test
    void academyLookupsReturnEmptyWhenIdsAreMissing() {
        Academy academy = new Academy();

        assertTrue(academy.findStudent(99).isEmpty());
        assertTrue(academy.findWorkshop(99).isEmpty());
    }

    @Test
    void academyRejectsRegistrationWhenEitherIdIsUnknown() {
        Academy academy = new Academy();
        academy.addStudent(student(1, "Chitrakalpa", "Brussels"));
        academy.addWorkshop(classroom(10, "Java Basics", 2));

        assertThrows(IllegalArgumentException.class,
                () -> academy.register(99, 10));
        assertThrows(IllegalArgumentException.class,
                () -> academy.register(1, 99));
        assertThrows(IllegalArgumentException.class,
                () -> academy.unregister(99, 10));
        assertThrows(IllegalArgumentException.class,
                () -> academy.unregister(1, 99));
    }

    @Test
    void academyUnregisterReturnsFalseForKnownButUnregisteredStudent() {
        Academy academy = new Academy();
        academy.addStudent(student(1, "Chitrakalpa", "Brussels"));
        academy.addWorkshop(classroom(10, "Java Basics", 2));

        assertFalse(academy.unregister(1, 10));
    }

    @Test
    void searchIsCaseInsensitiveSortedAndKeepsEqualNames() {
        Academy academy = new Academy();
        academy.addStudent(student(3, "Alex", "Brussels"));
        academy.addStudent(student(1, "Alex", "Ghent"));
        academy.addStudent(student(2, "Chitrakalpa", "Antwerp"));

        assertEquals(
                List.of("Alex", "Alex"),
                academy.searchStudents("aLeX").stream()
                        .map(Student::getName)
                        .toList());

        assertEquals(
                List.of(1, 3),
                academy.searchStudents("alex").stream()
                        .map(Student::getId)
                        .toList());

        assertTrue(academy.searchStudents("no match").isEmpty());

        assertEquals(
                List.of("Alex", "Alex", "Chitrakalpa"),
                academy.searchStudents("  ").stream()
                        .map(Student::getName)
                        .toList());

        assertThrows(IllegalArgumentException.class,
                () -> academy.searchStudents(null));
    }

    @Test
    void participantNamesAreSortedByNameThenId() {
        Academy academy = new Academy();
        Student secondAlex = student(2, "Alex", "Brussels");
        Student firstAlex = student(1, "Alex", "Ghent");
        Student chitrakalpa = student(3, "Chitrakalpa", "Antwerp");

        academy.addStudent(secondAlex);
        academy.addStudent(firstAlex);
        academy.addStudent(chitrakalpa);
        academy.addWorkshop(classroom(10, "Java Basics", 3));

        academy.register(2, 10);
        academy.register(3, 10);
        academy.register(1, 10);

        assertEquals(
                List.of("Alex", "Alex", "Chitrakalpa"),
                academy.participantNames(10));

        assertThrows(IllegalArgumentException.class,
                () -> academy.participantNames(99));
    }

    @Test
    void cityCollectionsAreUniqueAndAlphabeticallyOrdered() {
        Academy academy = new Academy();
        Student chitrakalpa = student(1, "Chitrakalpa", "Brussels");
        Student paul = student(2, "Paul", "Ghent");
        Student gayatri = student(3, "Gayatri", "Brussels");
        Student oleh = student(4, "Oleh", "Antwerp");

        academy.addStudent(chitrakalpa);
        academy.addStudent(paul);
        academy.addStudent(gayatri);
        academy.addStudent(oleh);
        academy.addWorkshop(classroom(10, "Java Basics", 2));

        academy.register(1, 10);
        academy.register(4, 10);

        TreeSet<String> cities = academy.allCities();
        assertIterableEquals(
                List.of("Antwerp", "Brussels", "Ghent"),
                cities);

        TreeMap<String, Long> counts = academy.participantCountsByCity(10);
        assertIterableEquals(
                List.of("Antwerp", "Brussels"),
                counts.keySet());
        assertEquals(1L, counts.get("Antwerp"));
        assertEquals(1L, counts.get("Brussels"));

        assertThrows(IllegalArgumentException.class,
                () -> academy.participantCountsByCity(99));
    }

    @Test
    void emptyAcademyAndEmptyWorkshopReturnEmptyResults() {
        Academy academy = new Academy();

        assertTrue(academy.searchStudents("").isEmpty());
        assertTrue(academy.allCities().isEmpty());
        assertTrue(academy.buildReport().isEmpty());

        academy.addWorkshop(classroom(10, "Java Basics", 2));

        assertTrue(academy.participantNames(10).isEmpty());
        assertTrue(academy.participantCountsByCity(10).isEmpty());
        assertEquals(
                List.of("Java Basics | 0/2 participants", "Go to room B12."),
                academy.buildReport());
    }

    @Test
    void buildReportSortsNamesButDoesNotChangeRegistrationOrder() {
        Academy academy = new Academy();
        Student gayatri = student(3, "Gayatri", "Brussels");
        Student chitrakalpa = student(1, "Chitrakalpa", "Brussels");

        academy.addStudent(gayatri);
        academy.addStudent(chitrakalpa);

        Workshop workshop = classroom(10, "Java Basics", 2);
        academy.addWorkshop(workshop);

        academy.register(3, 10);
        academy.register(1, 10);

        List<String> report = academy.buildReport();

        assertEquals(
                List.of(
                        "Java Basics | 2/2 participants",
                        "Go to room B12.",
                        "- Chitrakalpa",
                        "- Gayatri"),
                report);

        assertEquals(
                List.of(gayatri, chitrakalpa),
                workshop.getParticipants());
    }

    @Test
    void fileReportOutputWritesReportLines(@TempDir Path tempDir)
            throws IOException {
        Academy academy = new Academy();
        Student student = student(1, "Chitrakalpa", "Brussels");
        academy.addStudent(student);
        academy.addWorkshop(classroom(10, "Java Basics", 2));
        academy.register(1, 10);

        List<String> report = academy.buildReport();
        Path reportPath = tempDir.resolve("report.txt");

        new FileReportOutput(reportPath).write(report);

        assertEquals(report, SimpleFiles.readLines(reportPath));
    }

    private static Student student(int id, String name, String city) {
        return new Student(
                id,
                name,
                new ContactDetails(name.toLowerCase() + "@example.com", city));
    }

    private static Workshop classroom(int id, String title, int capacity) {
        return new ClassroomWorkshop(id, title, capacity, "B12");
    }
}