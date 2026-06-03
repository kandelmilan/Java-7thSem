/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollegeAssignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class practice {
    JFrame f;
    JLabel l1,l2;
    JCheckBox c1,c2,c3;
    public practice(){
        f=new JFrame("Item Event");
        l1=new JLabel("Programming");
        l2=new JLabel();
        c1=new JCheckBox("Java");
        c2=new JCheckBox("php");
        c3=new JCheckBox("C#");
        
        f.setSize(30,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
        f.setLayout(new FlowLayout());
        f.add(l1); f.add(c1); f.add(c2); f.add(c3);f.add(l2);
        
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
    }
    public void itemStateChanged(ItemEvent e){
        string res="Seleceted Programming:";
        
    }
}
