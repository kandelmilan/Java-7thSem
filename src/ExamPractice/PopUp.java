import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopUp extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton bAdd, bSub, bMul, bDiv;

    public PopUp() {

        setTitle("Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main BorderLayout
        setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel northPanel = new JPanel();
        JLabel heading = new JLabel("Simple Calculator Program");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(heading);

        // CENTER PANEL (Form)
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        centerPanel.add(new JLabel("First Number"));
        t1 = new JTextField();

        centerPanel.add(t1);

        centerPanel.add(new JLabel("Second Number"));
        t2 = new JTextField();

        centerPanel.add(t2);

        centerPanel.add(new JLabel("Result"));
        t3 = new JTextField();
        t3.setEditable(false);

        centerPanel.add(t3);

        // EAST PANEL (Buttons)
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1, 5, 5));

        bAdd = new JButton("Add");
        bSub = new JButton("Subtract");
        bMul = new JButton("Multiply");
        bDiv = new JButton("Divide");

        bAdd.addActionListener(this);
        bSub.addActionListener(this);
        bMul.addActionListener(this);
        bDiv.addActionListener(this);

        eastPanel.add(bAdd);
        eastPanel.add(bSub);
        eastPanel.add(bMul);
        eastPanel.add(bDiv);

        // Add panels to BorderLayout regions
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double num1 = Double.parseDouble(t1.getText());
        double num2 = Double.parseDouble(t2.getText());
        double result = 0;

        if (e.getSource() == bAdd) {
            result = num1 + num2;
        }
        else if (e.getSource() == bSub) {
            result = num1 - num2;
        }
        else if (e.getSource() == bMul) {
            result = num1 * num2;
        }
        else if (e.getSource() == bDiv) {
            result = num1 / num2;
        }

        t3.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new PopUp();
    }
}