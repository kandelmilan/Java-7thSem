package Lab1And2;



/*Write a java program to save 3 student record(such as Roll,name,address,and phone number)
into file student.txt and display the student record whose address is Kritipur*/


import java.io.*;
import java.util.*;

class Q2007 {
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


// with 2 employee  details and find who earns more than 300 
//try {
//            Scanner sc = new Scanner(System.in);
//
//            FileWriter fout = new FileWriter("sample1.txt");
//            BufferedWriter bw = new BufferedWriter(fout);
//            System.out.println("Enter Detials of 2 Employee: ");
//            for (int i = 0; i < 2; i++) {
//                System.out.println("Employee " + i);
//                System.out.println("Eid :");
//                int eid = sc.nextInt();
//                sc.nextLine();
//
//                System.out.println("Name :");
//                String name = sc.nextLine();
//
//                System.out.println("Departments :");
//                String dept = sc.nextLine();
//                
//                
//                System.out.println("Salary :");
//                double salary = sc.nextDouble();
//
//                bw.write(eid + "\n" + name + "\n" + dept + "\n" + salary);
//                bw.newLine();
//            }
//            bw.close();
//            fout.close();
//            System.out.println("File Written Successfully");
//        } catch (IOException e) {
//            System.out.print(e.getMessage());
//        }
//
//        try {
//            FileReader fin = new FileReader("sample1.txt");
//            BufferedReader br = new BufferedReader(fin);
//
//            System.out.println("\nEmployee Details:");
//
//            String eid, name, dept;
//
//            while ((eid = br.readLine()) != null) {
//                name = br.readLine();
//                dept = br.readLine();
//                double salary = Double.parseDouble(br.readLine());
//                
//                if(salary >300 ){
//                System.out.println("\nEid: " + eid);
//                System.out.println("Name: " + name);
//                System.out.println("Department: " + dept);
//                }
//            }
//
//            br.close();
//            fin.close();
//
//        } catch (IOException e) {
//            System.out.print(e.getMessage());
//        }