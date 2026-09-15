package composition.exercises;

/**
 * TODO:
 * 1. Create class Processor with method processData().
 * 2. Create class Computer that HAS-A Processor.
 * 3. In main(), create a Computer and call processData() through it.
 */

class Processor {
    public void processData() {
        System.out.println("All computer got a processor...");
    }
}

public class Computer {
    private Processor processor;

    public Computer(){
        this.processor = new Processor();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.processData();
    }

    public void processData(){
        processor.processData();
    }
}
