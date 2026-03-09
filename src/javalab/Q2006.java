// Java Program to Write and Read File using FileWriter and FileReader

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Q2006 {
    public static void main(String[] args) {

        // Writing to file
        try {
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hi,I am Milan Kandel learning java\n");
            writer.close();
            System.out.println("Data written to file successfully.");
        } 
        catch (IOException e) {
            System.out.println("Error while writing to file.");
        }

        // Reading from file
        try {
            FileReader reader = new FileReader("sample.txt");
            int character;

            System.out.println("\nReading data from file:");

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

            reader.close();
        } 
        catch (IOException e) {
            System.out.println("Error while reading the file.");
        }
    }
}