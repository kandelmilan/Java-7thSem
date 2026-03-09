import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class assignment1 extends JFrame {

    JTextField rollField, nameField, semField;
    JTable table;
    DefaultTableModel model;

    Connection conn;

    public assignment1() {

        setTitle("Student Management");
        setSize(500,400);
        setLayout(null);

        JLabel l1 = new JLabel("Roll");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Semester");

        l1.setBounds(30,30,100,25);
        l2.setBounds(30,60,100,25);
        l3.setBounds(30,90,100,25);

        rollField = new JTextField();
        nameField = new JTextField();
        semField = new JTextField();

        rollField.setBounds(120,30,150,25);
        nameField.setBounds(120,60,150,25);
        semField.setBounds(120,90,150,25);

        JButton insertBtn = new JButton("Insert");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        insertBtn.setBounds(50,130,90,30);
        updateBtn.setBounds(150,130,90,30);
        deleteBtn.setBounds(250,130,90,30);

        model = new DefaultTableModel();
        model.addColumn("Roll");
        model.addColumn("Name");
        model.addColumn("Semester");

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30,180,420,150);

        add(l1); add(l2); add(l3);
        add(rollField); add(nameField); add(semField);
        add(insertBtn); add(updateBtn); add(deleteBtn);
        add(sp);

        connectDB();
        loadData();

        insertBtn.addActionListener(e -> insertData());
        updateBtn.addActionListener(e -> updateData());
        deleteBtn.addActionListener(e -> deleteData());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void connectDB() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HCOE",
                    "root",
                    "");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    void loadData() {
        try {
            model.setRowCount(0);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while(rs.next()){
                model.addRow(new Object[]{
                        rs.getInt("roll"),
                        rs.getString("name"),
                        rs.getString("semester")
                });
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // INSERT
    void insertData() {
        try {
            String sql="INSERT INTO students VALUES(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1,Integer.parseInt(rollField.getText()));
            pst.setString(2,nameField.getText());
            pst.setString(3,semField.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,"Student Inserted Successfully");

            // Clear text fields
            rollField.setText("");
            nameField.setText("");
            semField.setText("");

            loadData();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // UPDATE
    void updateData() {
        try {
            String sql="UPDATE students SET name=?, semester=? WHERE roll=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1,nameField.getText());
            pst.setString(2,semField.getText());
            pst.setInt(3,Integer.parseInt(rollField.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,"Student Updated Successfully");

            loadData();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // DELETE
    void deleteData() {
        try {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this record?",
                    "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION){

                String sql="DELETE FROM students WHERE roll=?";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setInt(1,Integer.parseInt(rollField.getText()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,"Student Deleted Successfully");

                loadData();
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new assignment1();
    }
}