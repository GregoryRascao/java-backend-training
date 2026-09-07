package classes.examples.polymorphism;

public class Triangle extends Figure {
    private int height;
    public int base;

    public void draw() {
        System.out.println("This triangle has a base of " + base + " and a height of " + height);
    }

    //@Override is optional
    public void doubleTheSize() {
        System.out.println("As the subclass, I am doing it my way");
    }

    @Override
    public String toString() {
        return "This triangle has a base of " + base + " and a height of " + height;
    }

    // This method overrides a method that is defined in Object. The top class of Java class hierarchy
    @Override
    public boolean equals(Object obj) {
        //class work, make this better (null check, equality and typecasting)
        if(!(obj instanceof Triangle) ) {
            return false;
        }
        return this.height == ((Triangle)obj).height;
    }
}
