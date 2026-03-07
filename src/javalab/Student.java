package javalab;

public class Student {
    int roll;
    String name;
    public Student(){}
    public Student(int r,String n){
        roll=r;
        name=n;
    }
    public void display(){
        System.out.print("Roll ="+roll+"\nName ="+name);
    }
}

//Write a Java program to create user defined package and 
//use this package in another class or package.