/*
Write a Gui application to calculate simple interest.Use three text fields for input and fourth text fields for output.
Your program should display simple interest if the user press the mouse and compound interest if user releases the mouse.
*/

package Lab3;

import javax.swing.*;
import java.awt.event.*;

public class lab3002 implements MouseListener {

    JFrame f;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b;

    public lab3002(){

        f = new JFrame("Interest Calculator");

        l1 = new JLabel("Principal:");
        l2 = new JLabel("Rate:");
        l3 = new JLabel("Time:");
        l4 = new JLabel("Result:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        b = new JButton("Calculate");

        f.setSize(350,300);
        f.setLayout(null);

        l1.setBounds(30,30,100,20);
        t1.setBounds(150,30,120,20);

        l2.setBounds(30,70,100,20);
        t2.setBounds(150,70,120,20);

       l3.setBounds(30,110,100,20);
t3.setBounds(150,110,120,20);

b.setBounds(100,180,120,30);

l4.setBounds(30,230,150,20);
t4.setBounds(150,230,120,20);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(t4);
        f.add(b);

        b.addMouseListener(this);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   public void mousePressed(MouseEvent e){
    double p = Double.parseDouble(t1.getText());
    double r = Double.parseDouble(t2.getText());
    double t = Double.parseDouble(t3.getText());

    double si = (p*r*t)/100;

    l4.setText("Simple Interest:");
    t4.setText(String.valueOf(si));
}

public void mouseReleased(MouseEvent e){
    double p = Double.parseDouble(t1.getText());
    double r = Double.parseDouble(t2.getText());
    double t = Double.parseDouble(t3.getText());

    double ci = p * Math.pow((1 + r/100), t) - p;

    l4.setText("Compound Interest:");
    t4.setText(String.valueOf(ci));
}

    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    public static void main(String[] args){
        new lab3002();
    }
}