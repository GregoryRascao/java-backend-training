package projects.project4.device;

public class Termostat extends Device implements Switchable, Adjustable {

    Termostat() {
        this.energyConsumption = 30;
    }
    @Override
    public void turnOn() {
        System.out.println("Termostat turns on");
    }

    @Override
    public void turnOff() {
        System.out.println("Termostat turns off");
    }

    @Override
    public void adjust(double value) {
        System.out.println("Termostat is adjusted to the value" + value);
    }
}
