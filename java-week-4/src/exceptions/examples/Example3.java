package exceptions.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Example3 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("data.txt");
        }
        catch(FileNotFoundException fileNotFoundException) {
            System.out.println("data.txt weren't there! ");
        }
        finally {
            System.out.println("This part ALWAYS RUNS");
            System.out.println("Whether it fails or not");
        }

    }
}