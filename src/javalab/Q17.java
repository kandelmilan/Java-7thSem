/*
Write a java program to implement the concept of method Overloading
 */
package javalab;

// Adder class demonstrating Method Overloading
class Adder {

    // Method 1: Add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: Add two double values
    double add(double a, double b) {
        return a + b;
    }
}

// Main class
public class Q17 {

    public static void main(String[] args) {

        Adder obj = new Adder();

        System.out.println("Sum of two integers: " + obj.add(10, 20));
        System.out.println("Sum of three integers: " + obj.add(5, 10, 15));
        System.out.println("Sum of two doubles: " + obj.add(2.5, 3.5));
    }
}