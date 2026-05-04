/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//import java.util.Scanner;
//public class Test1{
//    public static void main(String[] args){
//    
//        int[][] jar=new int[3][4];
//        jar[0]=new int[]{1,2,3};
//        jar[1]=new int[]{4,5};
//        jar[2]=new int[]{6,7,8,9};
//        for(int i=0;i<3;i++){
//            for(int j=0;j<jar[i].length;j++){
//                 System.out.print(jar[i][j]+" ");
//            }
//             System.out.println("");
//        }
//    }
//}
//
//class Distance{
//    int feet,inch;
//    public Distance(int f,int i){
//        feet=f;
//        inch=i;
//    }
//    void addDistance(){
//        if(inch>=12){
//            feet=feet+(inch/12);
//            inch=inch%12;
//        }
//    }
//    void displayDistance(){
//        System.out.println("Distance :"+feet+" feet "+inch+" inch");
//    }
//  
//}
//public class Test1{
//    public static void main(String[] args){
//    Distance d=new Distance(3,12);
//    d.addDistance();
//    d.displayDistance();
//    
//    }
//}

import java.util.Scanner;
class userException extends Exception{
    public userException(String m){
        super(m);
    }
}
public class Test1{
    public static void main(String[] args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the username");
            String name=sc.nextLine();
            if(name.length()<10){
                System.out.println("The username is valid");
               
            }
            else{
                throw(new userException("Invalid username"));
            }
        }
        catch(userException ex){
            System.out.println(ex.getMessage());
        }
    }
}
