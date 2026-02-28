// Write a Java Program to initialize and display with sum of jagged array
package javalab;

public class Q4 {

    public static void main(String[] args) {

        int[][] jarArr = new int[3][];

        // Initializing jagged array
        jarArr[0] = new int[]{1, 2, 3};
        jarArr[1] = new int[]{4, 5};
        jarArr[2] = new int[]{6, 7, 8, 9};

        int sum = 0;

        System.out.println("Jagged Array:");

        // Displaying elements and calculating sum
        for (int i = 0; i < jarArr.length; i++) {
            for (int j = 0; j < jarArr[i].length; j++) {
                System.out.print(jarArr[i][j] + " ");
                sum += jarArr[i][j];   // Adding each element to sum
            }
            System.out.println();
        }

        System.out.println("Sum of all elements = " + sum);
    }
}