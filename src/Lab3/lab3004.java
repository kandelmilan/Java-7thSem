/*
 Write a Java program using swing component to create student registration form with field(text field for
name , address , email , password , radio button for Gender,checkbox for Hobbies,Country as dropdown list,opinion as text area ,
one button for submit) you program display the student infromation when user click on submit button.
 */
package Lab3;

import javax.swing.*;
import java.awt.event.*;

public class lab3004 implements ActionListener {

    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3;
    JPasswordField p1;
    JRadioButton male,female;
    JCheckBox hobby1,hobby2,hobby3;
    JComboBox<String> countryList;
    JTextArea opinion;
    JButton submit;
    ButtonGroup genderGroup;

    public lab3004(){

        f = new JFrame("Student Registration Form");
        f.setSize(500,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        l1 = new JLabel("Name:");
        l2 = new JLabel("Address:");
        l3 = new JLabel("Email:");
        l4 = new JLabel("Password:");
        l5 = new JLabel("Gender:");
        l6 = new JLabel("Hobbies:");
        l7 = new JLabel("Country:");
        JLabel l8 = new JLabel("Opinion:");

        // Text Fields
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        p1 = new JPasswordField();

        // Gender Radio Buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Hobbies Checkboxes
        hobby1 = new JCheckBox("Reading");
        hobby2 = new JCheckBox("Sports");
        hobby3 = new JCheckBox("Music");

        // Country Dropdown
        String[] countries = {"Nepal","India","USA","UK","Other"};
        countryList = new JComboBox<>(countries);

        // Opinion TextArea
        opinion = new JTextArea();

        // Submit Button
        submit = new JButton("Submit");
        submit.addActionListener(this);

        // Set bounds
        l1.setBounds(30,30,100,20); t1.setBounds(150,30,200,20);
        l2.setBounds(30,70,100,20); t2.setBounds(150,70,200,20);
        l3.setBounds(30,110,100,20); t3.setBounds(150,110,200,20);
        l4.setBounds(30,150,100,20); p1.setBounds(150,150,200,20);
        l5.setBounds(30,190,100,20); male.setBounds(150,190,70,20); female.setBounds(230,190,80,20);
        l6.setBounds(30,230,100,20); hobby1.setBounds(150,230,100,20); hobby2.setBounds(150,260,100,20); hobby3.setBounds(150,290,100,20);
        l7.setBounds(30,330,100,20); countryList.setBounds(150,330,200,20);
        l8.setBounds(30,370,100,20); opinion.setBounds(150,370,200,80);
        submit.setBounds(180,470,100,30);

        // Add components
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(l4); f.add(p1);
        f.add(l5); f.add(male); f.add(female);
        f.add(l6); f.add(hobby1); f.add(hobby2); f.add(hobby3);
        f.add(l7); f.add(countryList);
        f.add(l8); f.add(opinion);
        f.add(submit);
    }

    public void actionPerformed(ActionEvent e){

        String name = t1.getText();
        String address = t2.getText();
        String email = t3.getText();
        String password = new String(p1.getPassword());

        String gender = "";
        if(male.isSelected()) gender = "Male";
        else if(female.isSelected()) gender = "Female";

        String hobbies = "";
        if(hobby1.isSelected()) hobbies += "Reading ";
        if(hobby2.isSelected()) hobbies += "Sports ";
        if(hobby3.isSelected()) hobbies += "Music ";

        String country = (String) countryList.getSelectedItem();
        String opinionText = opinion.getText();

        String info = "Name: "+name+"\nAddress: "+address+"\nEmail: "+email+
                      "\nPassword: "+password+"\nGender: "+gender+"\nHobbies: "+hobbies+
                      "\nCountry: "+country+"\nOpinion: "+opinionText;

        JOptionPane.showMessageDialog(f, info, "Student Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        new lab3004();
    }
}
