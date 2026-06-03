package ExamPractice;

import javax.swing.*;
import java.awt.*;

class AddForm {
    JFrame f;
    JButton b1, b2, b3, b4,b5,b6;

    public AddForm() {
        f = new JFrame("AddApp");

        b1 = new JButton("Cube");
        b2 = new JButton("Fact");
        b3 = new JButton("Sum");
        b4 = new JButton("Minus");
                b5= new JButton("Sum");
        b6= new JButton("Minus");

        f.setSize(300, 300);
        // ✅ Correct FlowLayou
        f.setLayout(new GridLayout(0,2));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);

        f.setVisible(true);
    }
}

public class thread {
    public static void main(String[] args) {
        new AddForm();
    }
}