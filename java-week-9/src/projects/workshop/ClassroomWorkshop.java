public class ClassroomWorkshop extends Workshop {
    String room;

    public ClassroomWorkshop(int id, String title, int capacity, String room){
        super(id, title, capacity);
        if(room == null || room.isBlank()){
            throw new IllegalArgumentException("Room cannot be null or empty");
        }
        this.room = room.trim();
    }

    public String getRoom(){
        return room;
    }

    @Override
    public String joiningInstructions(){
        return "Go to room " + room + ".";
    }
}
