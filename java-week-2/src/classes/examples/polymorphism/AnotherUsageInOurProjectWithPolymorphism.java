package classes.examples.polymorphism;

public class AnotherUsageInOurProjectWithPolymorphism {

    static void paint(Figure figure)
    {
        if (figure != null) {
            figure.draw();
        }


    }

    public static void main(String[] args) {
        Figure[] figureArray = new Figure[5];
        figureArray[0] = new Triangle();
        figureArray[1] = new Triangle();
        figureArray[2] = new Cylinder();
        figureArray[3] = new Oval();
        figureArray[4] = new Oval();

        for(Figure obj: figureArray) {
            paint(obj);
        }

    }

    //Note that using instance is not the worst thing,
    // it is OK to use on some cases like DTO mapping, Serialization and deserialization
}
