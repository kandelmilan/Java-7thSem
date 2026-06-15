
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FirstGUI {

    JFrame f;
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2, b3, b4, b5;

    FirstGUI() {
        f = new JFrame("First App");
        b1 = new JButton("One");
        b2 = new JButton("Two");
        b3 = new JButton("Three");
        b4 = new JButton("Four");
        b5 = new JButton("Fifth");
        f.setSize(300, 300);
//        f.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(b1, BorderLayout.WEST);
        f.add(b2, BorderLayout.EAST);
        f.add(b3, BorderLayout.SOUTH);
        f.add(b4, BorderLayout.NORTH);
        f.add(b5, BorderLayout.CENTER);
        f.setVisible(true);
    }

}

public class practice {

    public static void main(String[] args) {
        new FirstGUI();
    }
}

//f=new JFrame("First App");
//        l1=new JLabel("Name");
//        l2=new JLabel("Password");
//        t1=new JTextField(15);
//        t2=new JTextField(15);
//        b=new JButton("Submit");
//        
//        f.setSize(300,300);
//        f.setLayout(new FlowLayout());
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//        
//        l1.setBounds(20,50,1000,40);
//        t1.setBounds(120,50,100,40);
//        l2.setBounds(20,100,100,40);
//        t2.setBounds(120,100,100,40);
//        b.setBounds(150,150,100,40);
//        
//        f.add(l1);f.add(t1);f.add(l2);f.add(t2);f.add(b);
//        
//        b.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                String n=t1.getText();
//                String p=t2.getText();
//                    JOptionPane.showMessageDialog(f,
//                        "Name: " + n + "\nPassword: " + p);
//            }
//            });
