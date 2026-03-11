import javax.swing.*;
import java.awt.event.*;

public class lab3001 implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2;
    
    public lab3001(){
        f=new JFrame("Calculator");
        
        l1=new JLabel("NUM 1:");
        l2=new JLabel("NUM 2:");
        
        
        t1=new JTextField(15);
        t2=new JTextField(15);
    
        
        b1=new JButton("Add");
        b2=new JButton("Subtract");
        l3=new JLabel("RESULT:");
            t3=new JTextField(15);
         
        f.setSize(300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
        f.setLayout(null);
        
        l1.setBounds(20,50,100,20);
        t1.setBounds(150,50,100,20);
        
        l2.setBounds(20,100,100,20);
        t2.setBounds(150,100,100,20);
       
        
    b1.setBounds(50,200,80,30);
b2.setBounds(150,200,100,30);

l3.setBounds(70,250,100,20);
t3.setBounds(150,250,100,20);
        
        f.add(l1); 
        f.add(t1); 
        f.add(l2); 
        f.add(t2);
       
        f.add(b1); 
        f.add(b2);
         f.add(l3);
        f.add(t3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        int a=Integer.parseInt(t1.getText());
        int b=Integer.parseInt(t2.getText());
        
        if(e.getSource()==b1){
            int sum=a+b;
            t3.setText(String.valueOf(sum));
        }
        
        if(e.getSource()==b2){
            int sub=a-b;
            t3.setText(String.valueOf(sub));
        }
    }
    
    public static void main(String[] args){
        new lab3001();
    }
}