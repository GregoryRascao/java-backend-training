package projects.project8.device;

public class Light extends Device implements Switchable, Reportable {

    Light() {
        this.energyConsumption = 50;
    }
    private int turnOnCount;

    public void turnOn() {
        this.turnOnCount ++;
        this.isTurnedOn = true;
    }

    public void turnOff() {
        this.isTurnedOn = false;
    }

    public void report() {
        System.out.println("It has been turned on " + turnOnCount + " times.");
    }
}
