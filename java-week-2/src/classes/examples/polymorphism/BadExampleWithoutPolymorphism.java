package classes.examples.polymorphism;

public class BadExampleWithoutPolymorphism {

    static void paint(Object figure) {
        if (figure == null) {
            System.out.println("Figure is null, it's better to stop the program rather than to crash");
        }
        if(figure instanceof Triangle) {
            System.out.println("Drawing a triangle");
        }
        else if(figure instanceof Cylinder) {
            System.out.println("Drawing a cylinder");
        }
        //......

        /** Why is this bad?
         * instanceof is a code smell by itself
         * because we are behaving according to the type of the object
         * but instead every object should know how to act.
         * When implementing it, we have to cover all the cases, we may make errors, and forget to implement some of them.
         * Polymorphism covers those risks.
         *
         * Why it doesn't follow the open closed principle?
         * hint if you don't know: if you cannot see why it is bad,
         *              try to add more shapes like Cone or Cylinder
         * Student work: refactor this code so it follows OCP and polymorphism
         * Student work: add a new Figure subclass (Hexagon, Cone, Cube etc.)
         */
    }

    public static void main(String[] args) {

        Figure[] figureArray = new Figure[5];
        figureArray[0] = new Triangle();
        figureArray[1] = new Triangle();
        figureArray[2] = new Cylinder();
        figureArray[3] = new Oval();
        figureArray[4] = new Oval();
        figureArray[5] = new Rectangle();

        for(Figure obj: figureArray) {
            paint(obj);
        }

    }

    //Note that using instance is not the worst thing,
    // it is OK to use on some cases like DTO mapping, Serialization and deserialization
}
