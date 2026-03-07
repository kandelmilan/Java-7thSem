/*
Write a Java program that will read balance and withdraw amount from keyboard
and display the remaining balance on screen if the balance is greater than withdraw
amount otherwise throw an exception with appropriate message.
 */
package javalab;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Q2004 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Balance: ");
            double balance = sc.nextDouble();

            System.out.print("Enter Withdraw Amount: ");
            double withdraw = sc.nextDouble();

            if (withdraw > balance) {
                throw new InsufficientBalanceException("Error: Insufficient Balance!");
            }

            double remaining = balance - withdraw;
            System.out.println("Remaining Balance = " + remaining);

        } 
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}