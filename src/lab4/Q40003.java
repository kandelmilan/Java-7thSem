/*
Write a java program to create login form with TooltipText and validation and display
the username and password when login button is clicked otherwise display an error message
 */
package lab4;

import javax.swing.*;
import java.awt.event.*;

public class Q40003 implements ActionListener {

    JFrame f;
    JLabel l1, l2, result;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;

    // Constructor
    Q40003() {
        f = new JFrame("Login Form");

        // Labels
        l1 = new JLabel("Username:");
        l1.setBounds(50, 50, 100, 30);

        l2 = new JLabel("Password:");
        l2.setBounds(50, 100, 100, 30);

        // Text Fields
        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 30);
        usernameField.setToolTipText("Enter your username here");

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        passwordField.setToolTipText("Enter your password here");

        // Button
        loginBtn = new JButton("Login");
        loginBtn.setBounds(120, 150, 100, 30);
        loginBtn.setToolTipText("Click to login");

        // Result Label
        result = new JLabel("");
        result.setBounds(50, 200, 300, 30);

        // Action Listener
        loginBtn.addActionListener(this);

        // Add components
        f.add(l1);
        f.add(l2);
        f.add(usernameField);
        f.add(passwordField);
        f.add(loginBtn);
        f.add(result);

        // Frame settings
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Validation
        if (username.isEmpty() || password.isEmpty()) {
            result.setText("Error: Fields cannot be empty!");
        } else if (username.equals("admin") && password.equals("1234")) {
            result.setText("Login Successful! Username: " + username + " Password: " + password);
        } else {
            result.setText("Invalid Username or Password!");
        }
    }

    // Main Method
    public static void main(String[] args) {
        new Q40003();
    }
}