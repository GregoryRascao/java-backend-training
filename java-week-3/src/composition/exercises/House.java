package composition.exercises;

/**
 1. Create class Room with fields: length, width.
 2. Add method getArea() in Room.
 3. Create class House that HAS-A Room.
 4. Add method printRoomArea() in House to delegate to Room.
*/
/**
 * Room
 */
class Room {
    double length;
    double width;

    Room(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return length * width;
    }
}
public class House {
    private Room room;
    House(Room room){
        this.room = room;
    }

    public void printRoomArea(){
        System.out.println("Room area :" + room.getArea());
    }

    public void main(String[] args){
        Room room = new Room(5,4);
        House house = new House(room);

        house.printRoomArea();
    }
}