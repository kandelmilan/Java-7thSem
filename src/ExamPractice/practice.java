import java.sql.*;

//Assume a table MOVIE(id, title, genre). Now, using JDBC, perform the following queries:
//a. Add any three records to the MOVIE table.
//b. Using a prepared statement, update the genre to “Comedy” having the title “Jatra”.


public class practice {

    public static void main(String[] args) throws Exception {

        // Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection (FIXED PORT 3306)
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/HCOE",
                "root",
                ""
        );

       String query="INSERT INTO MOVIE(id, title, genre) VALUES (?,?,?)";
       
       PreparedStatement ps=con.prepareStatement(query);
       
       ps.setInt(1,1001);
       ps.setString(2,"Jatra");
       ps.setString(3,"romance");
       ps.executeUpdate();
       
        ps.setInt(1,1003);
       ps.setString(2,"Sonic 3 - Shadow the Hedgehog");
       ps.setString(3,"Action and Animation");
       ps.executeUpdate();
       
        ps.setInt(1,1002);
       ps.setString(2,"Mufasa");
       ps.setString(3,"Adventure");
       
       int row=ps.executeUpdate();
       System.out.print(row+"rows Added");
       
       
       String q2="UPDATE  MOVIE SET genre=? WHERE title=?";
       PreparedStatement ps2=con.prepareStatement(q2);
       ps.executeUpdate();
       con.close();
       
       
    }
}