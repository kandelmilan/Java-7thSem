/*4. Write a Java program to create login form with userid, password, ok button and cancel button. 
Handle key  events such that pressing 'L' performs login and pressing 'c'  clears text boxes and puts focus on userid textbox. 
Assume user table having fields Uid  and password in the database named account.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Q4 extends JFrame implements KeyListener {

    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin, btnCancel;

    Connection con;

    public Q4() {

        setTitle("Login Form");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Labels & Fields
        add(new JLabel("User ID:"));
        txtUser = new JTextField();
        add(txtUser);

        add(new JLabel("Password:"));
        txtPass = new JPasswordField();
        add(txtPass);

        btnLogin = new JButton("OK");
        btnCancel = new JButton("Cancel");

        add(btnLogin);
        add(btnCancel);

        // Key Listener
        txtUser.addKeyListener(this);
        txtPass.addKeyListener(this);

        // Button Actions
        btnLogin.addActionListener(e -> login());
        btnCancel.addActionListener(e -> clearFields());

        connectDB();

        setVisible(true);
    }

    // DB Connection
    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8080/account",
                    "root",
                    ""
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // LOGIN FUNCTION
    void login() {
        try {
            String sql = "SELECT * FROM user WHERE Uid=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtUser.getText());
            ps.setString(2, new String(txtPass.getPassword()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // CLEAR FUNCTION
    void clearFields() {
        txtUser.setText("");
        txtPass.setText("");
        txtUser.requestFocus();
    }

    // KEY EVENTS
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == 'L' || e.getKeyChar() == 'l') {
            login();
        }

        if (e.getKeyChar() == 'C' || e.getKeyChar() == 'c') {
            clearFields();
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new Q4();
    }
}