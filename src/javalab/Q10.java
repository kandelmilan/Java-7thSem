/*
Write a java program to demostrate ArithmeticException,ArrayIndexOutOfBoundsException, and NumberFormatException class.
*/
package javalab;
public class Q10 {
    public static void main(String[] args) {
        
        // 1. ArithmeticException
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // Division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }

        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // Accessing invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        // 3. NumberFormatException
        try {
            String str = "abc123";
            int number = Integer.parseInt(str); // Invalid number format
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling.");
    }
}