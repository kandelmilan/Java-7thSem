import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Q3 extends JFrame {

    JTextField txtId, txtName, txtAddress, txtSalary;
    JButton btnAdd, btnUpdate, btnDelete, btnClear;
    JTable table;
    DefaultTableModel model;

    Connection con;

    public Q3() {

        setTitle("Employee CRUD Application");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ====== Top Panel (Form) ======
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Employee ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Address:"));
        txtAddress = new JTextField();
        panel.add(txtAddress);

        panel.add(new JLabel("Salary:"));
        txtSalary = new JTextField();
        panel.add(txtSalary);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnClear);

        add(panel, BorderLayout.NORTH);

        // ====== Table ======
        model = new DefaultTableModel(new String[]{"ID", "Name", "Address", "Salary"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ====== DB Connection ======
        connectDB();
        loadData();

        // ====== Button Actions ======
        btnAdd.addActionListener(e -> addEmployee());
        btnUpdate.addActionListener(e -> updateEmployee());
        btnDelete.addActionListener(e -> deleteEmployee());
        btnClear.addActionListener(e -> clearFields());

        // Click row to fill form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                txtId.setText(model.getValueAt(i, 0).toString());
                txtName.setText(model.getValueAt(i, 1).toString());
                txtAddress.setText(model.getValueAt(i, 2).toString());
                txtSalary.setText(model.getValueAt(i, 3).toString());
            }
        });

        setVisible(true);
    }

    // ====== Connect DB ======
    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Company", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ====== Load Data ======
    void loadData() {
        model.setRowCount(0);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("Eid"),
                    rs.getString("Name"),
                    rs.getString("Address"),
                    rs.getDouble("Salary")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ====== Add ======
    void addEmployee() {
        try {
            String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.setString(2, txtName.getText());
            ps.setString(3, txtAddress.getText());
            ps.setDouble(4, Double.parseDouble(txtSalary.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee Added!");

            loadData();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // ====== Update ======
    void updateEmployee() {
        try {
            String sql = "UPDATE Employee SET Name=?, Address=?, Salary=? WHERE Eid=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtName.getText());
            ps.setString(2, txtAddress.getText());
            ps.setDouble(3, Double.parseDouble(txtSalary.getText()));
            ps.setInt(4, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee Updated!");

            loadData();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // ====== Delete ======
    void deleteEmployee() {
        try {
            String sql = "DELETE FROM Employee WHERE Eid=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee Deleted!");

            loadData();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // ====== Clear Fields ======
    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
    }

    public static void main(String[] args) {
        new Q3();
    }
}