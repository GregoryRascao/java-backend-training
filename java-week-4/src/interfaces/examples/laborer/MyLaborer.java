package interfaces.examples.laborer;

public class MyLaborer {

    private Door door;      //abstract class
    private Paint paint;    //interface
    //Abstract classes and interfaces can live together

    MyLaborer(Door door, Paint paint) {
        this.door = door;
        this.paint = paint;
    }

    void buildDoor() {
        door.build();
    }

    void paint() {
        paint.apply();
    }

}
