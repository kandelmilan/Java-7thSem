
package javalab;
import java.util.Scanner;
//Write a program to find some of first n natural number which are odd only ...
public class Q1 {
    public static void main(String[] args){
        System.out.println("Enter Number n :");
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0)
                sum+=i;
        }
        System.out.println("Sum of odd number :"+sum);
    }
    
}
