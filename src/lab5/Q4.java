/*4. Write a Java program to create login form with userid, password, ok button and cancel button. 
Handle key  events such that pressing 'L' performs login and pressing 'c'  clears text boxes and puts focus on userid textbox. 
Assume user table having fields Uid  and password in the database named account.
*/
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Q4 implements ActionListener, KeyListener {

    JFrame f;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Connection con;

    public Q4() {
        f = new JFrame("Login Form");

        l1 = new JLabel("User ID:");
        l2 = new JLabel("Password:");

        t1 = new JTextField();
        t2 = new JPasswordField();

        b1 = new JButton("OK");
        b2 = new JButton("Cancel");

        f.setLayout(null);

        l1.setBounds(50, 50, 80, 25);
        t1.setBounds(140, 50, 150, 25);

        l2.setBounds(50, 100, 80, 25);
        t2.setBounds(140, 100, 150, 25);

        b1.setBounds(80, 150, 80, 30);
        b2.setBounds(180, 150, 80, 30);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b1); f.add(b2);

        // Events
        b1.addActionListener(this);
        b2.addActionListener(this);

        t1.addKeyListener(this);
        t2.addKeyListener(this);
        f.addKeyListener(this);

        f.setSize(350, 250);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);

        connectDB();
    }

    void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/account", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Button handling
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            login();
        } else if (e.getSource() == b2) {
            clear();
        }
    }

    // Login method
    void login() {
        try {
            String uid = t1.getText();
            String pass = new String(t2.getPassword());

            String sql = "SELECT * FROM user WHERE Uid=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, uid);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(f, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(f, "Invalid User!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Clear method
    void clear() {
        t1.setText("");
        t2.setText("");
        t1.requestFocus();
    }

    // Key events
    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();

        if (ch == 'L' || ch == 'l') {
            login();
        }

        if (ch == 'C' || ch == 'c') {
            clear();
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new Q4();
    }
}