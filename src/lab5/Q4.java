//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Q4 extends JFrame {
//
//    JTextField txtUser;
//    JPasswordField txtPass;
//    JButton btnLogin, btnClear;
//
//    Connection con;
//
//    public Q4() {
//
//        setTitle("Login Form");
//        setSize(400, 250);
//        setLayout(new GridLayout(3, 2, 10, 10));
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        // ===== UI =====
//        add(new JLabel("User ID:"));
//        txtUser = new JTextField();
//        add(txtUser);
//
//        add(new JLabel("Password:"));
//        txtPass = new JPasswordField();
//        add(txtPass);
//
//        btnLogin = new JButton("Login");
//        btnClear = new JButton("Cancel");
//
//        add(btnLogin);
//        add(btnClear);
//
//        // ===== DB Connection =====
//        connectDB();
//
//        // ===== Button Actions =====
//        btnLogin.addActionListener(e -> login());
//        btnClear.addActionListener(e -> clearFields());
//
//        // ===== Key Events =====
//        addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyChar() == 'l') {
//                    login();   // press 'l' to login
//                }
//                if (e.getKeyChar() == 'c') {
//                    clearFields(); // press 'c' to clear
//                    txtUser.requestFocus();
//                }
//            }
//        });
//
//        setFocusable(true);
//        setVisible(true);
//    }
//
//    // ===== DB Connection =====
//    void connectDB() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/account", "root", "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // ===== Login =====
//    void login() {
//        try {
//            String sql = "SELECT * FROM users WHERE Uid=? AND Password=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            ps.setString(1, txtUser.getText());
//            ps.setString(2, new String(txtPass.getPassword()));
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "Login Successful!");
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // ===== Clear =====
//    void clearFields() {
//        txtUser.setText("");
//        txtPass.setText("");
//    }
//
//    public static void main(String[] args) {
//        new Q4();
//    }
//}