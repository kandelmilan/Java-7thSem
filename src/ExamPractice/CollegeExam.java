

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//3 BUTTON WITH CAPTIONS BLUE RED AND GREEN AND WRITE A PROGRAM TO HANDLE THE EVENT SUCH THAT
//WHEN THE USER CLICKS THE BUTTON, THE COLOR OF THAT BUTTON WILL BE SAME AS ITS CAPTION
class FirstGUI implements ActionListener {

    JFrame f;
    JButton b1, b2, b3;

    public FirstGUI() {
        f = new JFrame("Exam");
        b1 = new JButton("RED");
        b2 = new JButton("BLUE");
        b3 = new JButton("GREEN");

        f.setSize(300, 300);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(3);

        f.add(b1);
        f.add(b2);
        f.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            b1.setBackground(Color.RED);
        } else if (e.getSource() == b2) {
            b2.setBackground(Color.BLUE);
        } else if (e.getSource() == b3) {
            b3.setBackground(Color.GREEN);
        }
    }
}

public class CollegeExam {

    public static void main(String[] args) {
        new FirstGUI();
    }
}

