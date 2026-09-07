package classes.examples.polymorphism;

public class AnotherTeamAlsoNeedsTheSameSolution {


    public static void main(String[] args) {
        Figure[] figureArray = new Figure[6];
        figureArray[0] = new Triangle();
        figureArray[1] = new Triangle();
        figureArray[2] = new Cylinder();
        figureArray[3] = new Oval();
        figureArray[4] = new Oval();
        figureArray[5] = new Rectangle();

        // They didn't do it! because it was complicated
        // Student TODO: Why may this occur?

        Triangle t = new Triangle();
        System.out.println(t.equals(figureArray[0]) );
        System.out.println( t.toString() );
        System.out.println(t.getClass() );
        System.out.println(t.hashCode() );

    }

    //Note that using instance is not the worst thing, it is OK to use on some cases like DTO mapping, Serialization and deserialization

}
