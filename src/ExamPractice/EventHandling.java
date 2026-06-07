package ExamPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChoiceEx implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3;
    JRadioButton r1, r2;
    JComboBox cb;
    JSlider s;
    JTextArea ta;
    JButton b;
    JScrollPane sp;

    public ChoiceEx() {
        f = new JFrame("Choice Elements");
        l1 = new JLabel("Gender :");
        l2 = new JLabel("Country");
        l3 = new JLabel("Age");
        b = new JButton("Diplay");
        r1 = new JRadioButton("male");
        r2 = new JRadioButton("female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        String[] cname = {"Nepal", "India", "China"};
        cb = new JComboBox(cname);
        s = new JSlider( 0, 100, 20);

       
        
        ta = new JTextArea(10, 20);
        sp = new JScrollPane(ta);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        f.setSize(500, 400);
        f.setLayout(new FlowLayout());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l1);
        f.add(r1);
        f.add(r2);
        f.add(l2);
        f.add(cb);
        f.add(l3);
        f.add(s);
        f.add(b);
        f.add(sp);

        f.setVisible(true);
        b.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String gender = " ", cname = "";
        int age = 0;
        if (r1.isSelected()) {
            gender = "male";
        }
        if (r2.isSelected()) {
            gender = "female";
        }
        cname = cb.getItemAt(cb.getSelectedIndex()).toString();
        age = s.getValue();
        ta.setText("Choice Data :\nGender = " + gender + "\nCountry = " + cname + "\nAge = " + age);
    }

}

public class EventHandling {

    public static void main(String[] args) {
        new ChoiceEx();
    }
}
