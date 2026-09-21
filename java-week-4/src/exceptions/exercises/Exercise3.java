package exceptions.exercises;

import java.io.*;

/**
 *  Exercise 3:
 *  Create a method readFile(String filename).
 *  Try to open the file.
 *  If the file doesn’t exist, catch FileNotFoundException.
 */
public class Exercise3
{
    public static void main(String[] args)
    {
        readFile("test.txt"); // file may or may not exist
    }

    public static void readFile(String filename)
    {
        try {
            FileReader fr = new FileReader(filename);    // uncomment to see the exception
            System.out.println("File opened successfully!" + fr);
            
        } catch (Exception e) {
            System.out.println("file does not exist");
        }
    }
}
