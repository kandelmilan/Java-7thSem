import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Q2 extends JFrame {

    JTextField txtId, txtName, txtAddress, txtSalary;
    JButton btnAdd, btnUpdate, btnDelete, btnClear;
    JTable table;
    DefaultTableModel model;

    Connection con;

    public Q2() {

        setTitle("Employee CRUD Application");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // ====== FORM PANEL ======
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Employee ID:"), gbc);

        gbc.gridx = 1;
        txtId = new JTextField(15);
        panel.add(txtId, gbc);

        // Row 2
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        txtName = new JTextField(15);
        panel.add(txtName, gbc);

        // Row 3
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        txtAddress = new JTextField(15);
        panel.add(txtAddress, gbc);

        // Row 4
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Salary:"), gbc);

        gbc.gridx = 1;
        txtSalary = new JTextField(15);
        panel.add(txtSalary, gbc);

        // Buttons Row
        gbc.gridx = 0; gbc.gridy = 4;
        btnAdd = new JButton("Add");
        panel.add(btnAdd, gbc);

        gbc.gridx = 1;
        btnUpdate = new JButton("Update");
        panel.add(btnUpdate, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        btnDelete = new JButton("Delete");
        panel.add(btnDelete, gbc);

        gbc.gridx = 1;
        btnClear = new JButton("Clear");
        panel.add(btnClear, gbc);

        add(panel, BorderLayout.NORTH);

        // ====== TABLE ======
        model = new DefaultTableModel(new String[]{"ID", "Name", "Address", "Salary"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ====== DB ======
        connectDB();
        loadData();

        // ====== ACTIONS ======
        btnAdd.addActionListener(e -> addEmployee());
        btnUpdate.addActionListener(e -> updateEmployee());
        btnDelete.addActionListener(e -> deleteEmployee());
        btnClear.addActionListener(e -> clearFields());

        // Click row
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

    // ====== CONNECT DB ======
void connectDB() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:8080/company",
                "root",
                ""
        );

        System.out.println("DB Connected Successfully!");

    } catch (Exception e) {
        e.printStackTrace(); // IMPORTANT (better than hiding error)
        JOptionPane.showMessageDialog(this, "DB Error: " + e.getMessage());
    }
}
    // ====== LOAD DATA ======
    void loadData() {
        if (con == null) return;

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

    // ====== ADD ======
    void addEmployee() {
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database not connected!");
            return;
        }

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
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // ====== UPDATE ======
    void updateEmployee() {
        if (con == null) return;

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
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // ====== DELETE ======
    void deleteEmployee() {
        if (con == null) return;

        try {
            String sql = "DELETE FROM Employee WHERE Eid=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee Deleted!");
            loadData();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // ====== CLEAR ======
    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
    }

    public static void main(String[] args) {
        new Q2();
    }
}