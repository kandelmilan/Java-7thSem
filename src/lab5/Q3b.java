import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class Q3b {

    public static void main(String[] args) {

        try {
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();

            crs.setUrl("jdbc:mysql://localhost:8080/company");
            crs.setUsername("root");
            crs.setPassword("");

            crs.setCommand("SELECT * FROM Employee");
            crs.execute();

            System.out.println("Employee Data:");

            while (crs.next()) {
                System.out.println(
                    crs.getInt("Eid") + " " +
                    crs.getString("Name") + " " +
                    crs.getString("Address") + " " +
                    crs.getDouble("Salary")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}