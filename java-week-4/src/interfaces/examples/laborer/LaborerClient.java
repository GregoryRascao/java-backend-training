package interfaces.examples.laborer;

import java.util.UUID;

public class LaborerClient {
    public static void main(String[] args) {

        RedPaint redPaint = new RedPaint();
        SteelDoor steelDoor = new SteelDoor();

        MyLaborer myLaborer = new MyLaborer(steelDoor, redPaint);
        // When your code depends on abstractions, you can replace real implementations with fake ones during testing.
        // could we do it with abstract classes?
        myLaborer.buildDoor();
        myLaborer.paint();

        steelDoor.unlock();
    }

}
