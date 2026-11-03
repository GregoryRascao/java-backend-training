import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Workshop {
    int id;
    String title;
    int capacity;
    List<Student> participants = new ArrayList<>();

    public Workshop(int id, String title, int capacity){
        if (id <= 0) {
            throw new IllegalArgumentException("Workshop ID must be positive");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Workshop can't be null or blank");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        
        this.id = id;
        this.title = title;
        this.capacity = capacity;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getCapacity(){
        return capacity;
    }

    public List<Student> getParticipants(){
        return List.copyOf(participants);
    }
    public int availablePlaces(){
        return capacity - participants.size();
    }
    public void register(Student student){
        if(student == null){
            throw new IllegalArgumentException("Student cannot be null");
        }

        for (Student participant : participants) {
            if (participant.getId() == student.getId()) {
                throw new IllegalStateException("Student is already register");
            }
        }
        if(availablePlaces() == 0){
            throw new IllegalStateException("Workshop is full");
        }
        participants.add(student);
    }
    public boolean unregister(int studentId){
        Iterator<Student> iterator = participants.iterator();

        while (iterator.hasNext()) {
            Student participant = iterator.next();
            if (participant.getId() == studentId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public abstract String joiningInstructions();
}
