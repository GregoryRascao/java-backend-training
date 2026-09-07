package classes.examples.polymorphism;


public class FigureDemo {
    public static void main(String[] args) {
        //Figure f = new Figure();
        Figure s = new Square(); //Polimorphic object creation
        Triangle t1 = new Triangle();
        t1.equals(s);
    }

    public int write(Figure f) { //the parameter type is Figure, so any subclass of Figure are welcome here
        f.draw();
        return 0;
    }
}
