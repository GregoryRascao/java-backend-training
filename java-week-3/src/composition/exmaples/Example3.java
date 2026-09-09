package composition.exmaples;

public class Example3
{
    public static void main(String[] args)
    {
        Computer computer = new Computer();
        computer.startComputer();
    }
}

// Processor.java
class Processor
{
    public void process()
    {
        System.out.println("Processor is running...");
    }
}

// Computer.java
class Computer
{
    private final Processor processor; // HAS-A relationship

    public Computer()
    {
        this.processor = new Processor(); // Composition
    }

    public void startComputer()
    {
        processor.process(); // delegate to Processor
        System.out.println("Computer is ready to use.");
    }
}

