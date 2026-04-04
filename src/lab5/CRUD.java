// this is not correct code need to improve this 
import java.sql.*;
import java.util.Scanner;

public class CRUD {

    static final String URL = "jdbc:mysql://localhost:3306/Company";
    static final String USER = "root";
    static final String PASSWORD = ""; 

    static Connection con;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;

            do {
                System.out.println("\n--- Employee CRUD Menu ---");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee(sc);
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateEmployee(sc);
                        break;
                    case 4:
                        deleteEmployee(sc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void insertEmployee(Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, address);
        ps.setDouble(4, salary);

        ps.executeUpdate();
        System.out.println("Employee inserted successfully!");
    }

    // READ
    public static void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM Employee";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- Employee Records ---");
        while (rs.next()) {
            System.out.println(
                rs.getInt("Eid") + " | " +
                rs.getString("Name") + " | " +
                rs.getString("Address") + " | " +
                rs.getDouble("Salary")
            );
        }
    }

    // UPDATE
    public static void updateEmployee(Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Address: ");
        String address = sc.nextLine();

        System.out.print("Enter new Salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE Employee SET Name=?, Address=?, Salary=? WHERE Eid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, address);
        ps.setDouble(3, salary);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Employee updated successfully!");
        else
            System.out.println("Employee not found!");
    }

    // DELETE
    public static void deleteEmployee(Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM Employee WHERE Eid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Employee deleted successfully!");
        else
            System.out.println("Employee not found!");
    }
}