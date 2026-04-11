//Write a Java Program illustrate the concept of ResultSet Scrollable and Updatable and CatchedRowSet
import java.sql.*;

public class Q3a {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:8080/company",
                "root",
                ""
            );

            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );

            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            System.out.println("First Record:");
            rs.first();
            System.out.println(rs.getInt("Eid") + " " + rs.getString("Name"));

            System.out.println("Last Record:");
            rs.last();
            System.out.println(rs.getInt("Eid") + " " + rs.getString("Name"));

            System.out.println("Previous Record:");
            rs.previous();
            System.out.println(rs.getInt("Eid") + " " + rs.getString("Name"));

            // Update example
            rs.first();
            rs.updateString("Name", "UpdatedName");
            rs.updateRow();

            System.out.println("Record Updated Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}