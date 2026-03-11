/*
write a java program using swing component to find area and perimeter of rectangle use textfield for input and outputs.
Your program should display the result when the user click a button 
 */
package Lab3;

import javax.swing.*;
import java.awt.event.*;

public class lab3003 implements ActionListener {

    JFrame f;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b;

    public lab3003(){

        f = new JFrame("Rectangle Calculator");

        l1 = new JLabel("Length:");
        l2 = new JLabel("Breadth:");
        l3 = new JLabel("Area:");
        l4 = new JLabel("Perimeter:");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);

        b = new JButton("Calculate");

        f.setSize(350,320);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1.setBounds(30,40,100,20);
        t1.setBounds(150,40,120,20);

        l2.setBounds(30,80,100,20);
        t2.setBounds(150,80,120,20);

        b.setBounds(110,130,120,30);

        /* Results below button */
        l3.setBounds(30,190,100,20);
        t3.setBounds(150,190,120,20);

        l4.setBounds(30,230,100,20);
        t4.setBounds(150,230,120,20);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(t4);

        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        double length = Double.parseDouble(t1.getText());
        double breadth = Double.parseDouble(t2.getText());

        double area = length * breadth;
        double perimeter = 2 * (length + breadth);

        t3.setText(String.valueOf(area));
        t4.setText(String.valueOf(perimeter));
    }

    public static void main(String[] args){
        new lab3003();
    }
}