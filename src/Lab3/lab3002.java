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

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);

        b = new JButton("Calculate");

        f.setSize(350,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1.setBounds(30,30,100,20);
        t1.setBounds(150,30,120,20);

        l2.setBounds(30,70,100,20);
        t2.setBounds(150,70,120,20);

        l3.setBounds(30,110,100,20);
        t3.setBounds(150,110,120,20);

        l4.setBounds(30,150,100,20);
        t4.setBounds(150,150,120,20);

        b.setBounds(100,200,120,30);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(t4);
        f.add(b);

        b.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e){
        double p = Double.parseDouble(t1.getText());
        double r = Double.parseDouble(t2.getText());
        double t = Double.parseDouble(t3.getText());

        double si = (p*r*t)/100;

        t4.setText(String.valueOf(si));
    }

    public void mouseReleased(MouseEvent e){
        double p = Double.parseDouble(t1.getText());
        double r = Double.parseDouble(t2.getText());
        double t = Double.parseDouble(t3.getText());

        double ci = p * Math.pow((1 + r/100), t) - p;

        t4.setText(String.valueOf(ci));
    }

    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    public static void main(String[] args){
        new lab3002();
    }
}