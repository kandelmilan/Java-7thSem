/* 
Design a GUI form using swing with a text field , a text label for displaying the inout message "Input any String" and threen
buttons with caption CheckPlaindrome,Reverse,adn FindVowels. Write a complete program for above scenario and for checking palindrome in first button,
reverse it after clicking second button and extract vowel from it after clicking third button.

*/
package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q40001 implements ActionListener {

    JFrame f;
    JLabel label, resultLabel;
    JTextField textField;
    JButton btnPalindrome, btnReverse, btnVowels;

    // Constructor
    Q40001() {
        f = new JFrame("String Operations");

        // Label
        label = new JLabel("Input any String:");
        label.setBounds(50, 50, 150, 30);

        // Text Field
        textField = new JTextField();
        textField.setBounds(200, 50, 150, 30);

        // Buttons
        btnPalindrome = new JButton("Check Palindrome");
        btnPalindrome.setBounds(50, 100, 150, 30);

        btnReverse = new JButton("Reverse");
        btnReverse.setBounds(210, 100, 100, 30);

        btnVowels = new JButton("Find Vowels");
        btnVowels.setBounds(320, 100, 120, 30);

        // Result Label
        resultLabel = new JLabel("Result will be shown here");
        resultLabel.setBounds(50, 160, 400, 30);

        // Add Action Listeners
        btnPalindrome.addActionListener(this);
        btnReverse.addActionListener(this);
        btnVowels.addActionListener(this);

        // Add components to frame
        f.add(label);
        f.add(textField);
        f.add(btnPalindrome);
        f.add(btnReverse);
        f.add(btnVowels);
        f.add(resultLabel);

        // Frame settings
        f.setSize(500, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Action handling
    public void actionPerformed(ActionEvent e) {
        String input = textField.getText();

        if (input.isEmpty()) {
            resultLabel.setText("Please enter a string!");
            return;
        }

        // Check Palindrome
        if (e.getSource() == btnPalindrome) {
            String reversed = new StringBuilder(input).reverse().toString();
            if (input.equalsIgnoreCase(reversed)) {
                resultLabel.setText("It is a Palindrome");
            } else {
                resultLabel.setText("It is NOT a Palindrome");
            }
        }

        // Reverse String
        if (e.getSource() == btnReverse) {
            String reversed = new StringBuilder(input).reverse().toString();
            resultLabel.setText("Reversed: " + reversed);
        }

        // Find Vowels
        if (e.getSource() == btnVowels) {
            String vowels = "";
            for (char ch : input.toCharArray()) {
                if ("aeiouAEIOU".indexOf(ch) != -1) {
                    vowels += ch + " ";
                }
            }

            if (vowels.isEmpty()) {
                resultLabel.setText("No vowels found");
            } else {
                resultLabel.setText("Vowels: " + vowels);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new Q40001();
    }
}