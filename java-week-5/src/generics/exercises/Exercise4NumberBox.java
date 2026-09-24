package generics.exercises;

import java.util.ArrayList;

public class Exercise4NumberBox<Type extends Number> {
    Type number;
    public Exercise4NumberBox(){

    }

    public static void main(String[] args) {
        Exercise4NumberBox nb = new Exercise4NumberBox();
        ArrayList a = new ArrayList();
        //NumberBox<String> isItPossible = new NumberBox<String>(); no
    }
}
