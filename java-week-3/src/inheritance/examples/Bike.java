package inheritance.examples;

// Subclasses, super method and equals
public class Bike extends Vehicle {
    int extraWheelsCount;
    String creationDate;

    public Bike(String brand, int extraWheelsCount, String creationDate) {
        super(brand);
        this.extraWheelsCount = extraWheelsCount;
        this.creationDate = creationDate;
    }

    protected void setBikeBrand(String b) {
        super.brand = b;
    }

    @Override
    public void drive()
    {
        System.out.println(brand + " bike is zooming...");
    }
//    second step after inheritance
//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj) return true;      // same object
//
//        if (obj == null) return false;     // null check
//
//        if (getClass() != obj.getClass()) return false;  // same type check
//
//        Bike other = (Bike) obj;           // casting is safe after the previous if
//
//        return extraWheelsCount == other.extraWheelsCount
//                && creationDate.equals(other.creationDate)
//                && brand.equals(other.brand);
//    }
}
