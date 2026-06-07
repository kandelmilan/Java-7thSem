package ExamPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuEx implements ActionListener {

    JFrame f;
    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1, i2;
    JCheckBoxMenuItem cb1;
    JRadioButtonMenuItem r1, r2;
    JPopupMenu pm;
    

    public MenuEx() {
        f = new JFrame("Menu");
        mb = new JMenuBar();
        m1 = new JMenu("Files");
        m2 = new JMenu("Edit");
        i1 = new JMenuItem("New",KeyEvent.ALT_DOWN_MASK);
        i2 = new JMenuItem("open");
        i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.ALT_DOWN_MASK));

        cb1 = new JCheckBoxMenuItem("Open");
        r1 = new JRadioButtonMenuItem("Paste");
        r2 = new JRadioButtonMenuItem("Select");
        
        pm=new JPopupMenu("Edit");
        pm.add(i1);pm.add(i2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        f.setJMenuBar(mb);
        mb.add(m1);
        mb.add(m2);
        m1.add(i1);
        m1.add(i2);
        m2.add(cb1);
        m2.add(r1);
        m2.add(r2);

        f.setSize(300, 300);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i1.addActionListener(this);
        i2.addActionListener(this);
    }
  
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("New")){
            JOptionPane.showMessageDialog(f,"New Menu Item is clicked");
        }
        if(e.getActionCommand().equals("open")){
            JOptionPane.showMessageDialog(f,"Open Menu Item is Clicked");
        }
    }
}

public class Menu {

    public static void main(String[] args) {
        new MenuEx();
    }

}
