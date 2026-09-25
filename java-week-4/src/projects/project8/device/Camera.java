package projects.project8.device;

public class Camera extends Device implements Switchable, Adjustable {

    private double zoom;

    Camera() {
        this.energyConsumption = 100;
    }

    public void turnOn() {
        System.out.println("Camera turns on");
        this.isTurnedOn = true;
    }

    public void turnOff() {
        System.out.println("Camera turns off");
        this.isTurnedOn = false;
    }

    public void adjust(double value) {
        this.zoom = value;
        System.out.println("Camera adjusted");
    }

    public double getZoom() {
        return this.zoom;
    }

    //This is second choice for validating a device
//    @Override
//    void validateItself() {
//        if (this == null) {
//            throw new RuntimeException("Camera is null"); //never going to happen
//        }
//    }
}
