package inheritance.examples;

public class CachingAndPooling {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true (cached)

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false (outside cache range)



        String s1 = "hello";
        String s2 = "hello";
        System.out.println("s1 == s2: " + s1 == s2); // true
        // they are the same pooled references

        Butterfly bf1 = new Butterfly();
        Butterfly bf2 = new Butterfly();
        System.out.println("bf1 == bf2" + (bf1 == bf2));
        //it is false because they are different objects on HEAP,
        // and different references on Stack


        String s3 = new String("hello");
        System.out.println(s1 == s3); // false (different objects)
        System.out.println(s1.equals(s3)); // true (same value)

        String s4 = s3.intern();
        System.out.println(s1 == s4); // true (both point to pool)
    }
}

class Butterfly {

}
