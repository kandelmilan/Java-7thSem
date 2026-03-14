/*
 Write a Java program using swing component to create student registration form with field(text field for
name , address , email , password , radio button for Gender,checkbox for Hobbies,Country as dropdown list,opinion as text area ,
one button for submit) you program display the student infromation when user click on submit button.
 */
/*
Write a Java program using swing component to create student registration form with fields:
Name, Address, Email, Password, Gender (Radio Button), Hobbies (Checkbox),
Country (Dropdown), Opinion (TextArea) and Submit button.
Display student information when user clicks submit.
*/

package Lab3;

import javax.swing.*;
import java.awt.event.*;

public class lab3004 implements ActionListener {

    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;

    JTextField t1,t2,t3;
    JPasswordField p1;

    JRadioButton male,female;
    ButtonGroup bg;

    JCheckBox h1,h2,h3;

    JComboBox country;

    JTextArea ta;

    JButton submit;

    public lab3004(){

        f = new JFrame("Student Registration Form");

        l1 = new JLabel("Name");
        l2 = new JLabel("Address");
        l3 = new JLabel("Email");
        l4 = new JLabel("Password");
        l5 = new JLabel("Gender");
        l6 = new JLabel("Hobbies");
        l7 = new JLabel("Country");
        l8 = new JLabel("Opinion");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        p1 = new JPasswordField();

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        h1 = new JCheckBox("Reading");
        h2 = new JCheckBox("Sports");
        h3 = new JCheckBox("Music");

        String c[] = {"Nepal","India","USA","UK"};
        country = new JComboBox(c);

        ta = new JTextArea();

        submit = new JButton("Submit");

        f.setLayout(null);
        f.setSize(500,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1.setBounds(50,50,100,20);
        t1.setBounds(200,50,200,20);

        l2.setBounds(50,90,100,20);
        t2.setBounds(200,90,200,20);

        l3.setBounds(50,130,100,20);
        t3.setBounds(200,130,200,20);

        l4.setBounds(50,170,100,20);
        p1.setBounds(200,170,200,20);

        l5.setBounds(50,210,100,20);
        male.setBounds(200,210,80,20);
        female.setBounds(300,210,80,20);

        l6.setBounds(50,250,100,20);
        h1.setBounds(200,250,100,20);
        h2.setBounds(200,280,100,20);
        h3.setBounds(200,310,100,20);

        l7.setBounds(50,350,100,20);
        country.setBounds(200,350,200,20);

        l8.setBounds(50,390,100,20);
        ta.setBounds(200,390,200,80);

        submit.setBounds(200,500,100,30);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(p1);

        f.add(l5); f.add(male); f.add(female);

        f.add(l6); f.add(h1); f.add(h2); f.add(h3);

        f.add(l7); f.add(country);

        f.add(l8); f.add(ta);

        f.add(submit);

        submit.addActionListener(this);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String name = t1.getText();
        String address = t2.getText();
        String email = t3.getText();
        String password = new String(p1.getPassword());

        String gender="";
        if(male.isSelected()) gender="Male";
        if(female.isSelected()) gender="Female";

        String hobbies="";
        if(h1.isSelected()) hobbies+="Reading ";
        if(h2.isSelected()) hobbies+="Sports ";
        if(h3.isSelected()) hobbies+="Music ";

        String c = country.getSelectedItem().toString();

        String op = ta.getText();

        String info =
                "Name: "+name+
                "\nAddress: "+address+
                "\nEmail: "+email+
                "\nPassword: "+password+
                "\nGender: "+gender+
                "\nHobbies: "+hobbies+
                "\nCountry: "+c+
                "\nOpinion: "+op;

        JOptionPane.showMessageDialog(f,info);
    }

    public static void main(String args[]){
        new lab3004();
    }
}