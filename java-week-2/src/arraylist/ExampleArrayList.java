package arraylist;

import java.util.ArrayList;

public class ExampleArrayList {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));


        //HEX: 0123456789abcdef


        Integer i = 10;                     // autoboxing
        Integer j = new Integer(20);       // unboxing


        char c = ';';
        Character charObj = Character.valueOf(c);

// Character utility methods
        System.out.println("Character.isLetter(c): " + Character.isLetter(c)); // true


        //boolean myDefault = null;
        Boolean myWrapperBoolean = null;
//        System.out.println(myDefault);
        System.out.println(myWrapperBoolean);

        ArrayList<String> list = new ArrayList<>(1);
        System.out.println("list.isEmpty(): " + list.isEmpty());
        list.add("A");                // ["A"]
        System.out.println(" after adding something, list.isEmpty(): " + list.isEmpty());
        list.add("B");                // ["A", "B"]
        list.add(1, "C");             // ["A", "C", "B"]
        list.set(1, "Z");   // ["A", "Z", "B"]
        list.remove(0);     // ["Z", "B"]
        ArrayList<String> toBeRemoved = new ArrayList<>();
        toBeRemoved.add("A");
        toBeRemoved.add("B");
        System.out.println(list);
        System.out.println(list.size());
        list.trimToSize();
        list.ensureCapacity(10);

        list.removeAll(toBeRemoved);      // removes all toBeRemoved

        list.clear();   //removes all

        System.out.println("*********************************");
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("A");
        System.out.println(myList.contains("B"));
        System.out.println(myList.indexOf("B"));
        myList.add("B");
        System.out.println("B added");
        myList.add(null);
        System.out.println(myList.contains("B"));
        System.out.println(myList.indexOf("B"));

        Object[] myArray = myList.toArray();
        System.out.println("writing the array");
        for(Object obj : myArray) {
            System.out.println(obj);
        }

        String[] arr = myList.toArray(new String[9]);
        System.out.println("Writing arr");
        for(Object a : arr) {
            System.out.println(a);
        }

    }
}
