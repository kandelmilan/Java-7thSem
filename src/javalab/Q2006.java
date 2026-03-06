// Java Program to Save Student Records and Display Students from Kirtipur

import java.io.*;
import java.util.*;

class Q2006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Writing student records to file
            FileWriter fw = new FileWriter("student.txt");

            System.out.println("Enter details of 3 students:");

            for (int i = 1; i <= 3; i++) {
                System.out.println("\nStudent " + i);

                System.out.print("Roll: ");
                int roll = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                // Save record in file
                fw.write(roll + "," + name + "," + address + "," + phone + "\n");
            }

            fw.close();
            System.out.println("\nStudent records saved successfully.");

            // Reading records from file
            FileReader fr = new FileReader("student.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\nStudents whose address is Kirtipur:\n");

            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");

                if (data[2].equalsIgnoreCase("Kritipur")) {
                    System.out.println("Roll: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Address: " + data[2]);
                    System.out.println("Phone: " + data[3]);
                    System.out.println();
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e);
        }

        sc.close();
    }
}