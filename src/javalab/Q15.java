/*
Write a class Circle containing private variable radius of type float,suitable constructor , and two methoss findArea
and findCricumference to find area and circumference of circles respectively. Write a separate class MyCircle containing 
main methos to create and use circle objects .
 */
package javalab;
// Circle.java
class Circle {
    
    // Private variable
    private float radius;

    // Constructor
    public Circle(float radius) {
        this.radius = radius;
    }

    // Method to find Area
    public float findArea() {
        return (float)(Math.PI * radius * radius);
    }

    // Method to find Circumference
    public float findCircumference() {
        return (float)(2 * Math.PI * radius);
    }
}

// Separate class containing main method
public class Q15 {

    public static void main(String[] args) {

        // Creating Circle object
        Circle c1 = new Circle(7);

        // Displaying results
        System.out.println("Radius: 7.0");
        System.out.println("Area of Circle: " + c1.findArea());
        System.out.println("Circumference of Circle: " + c1.findCircumference());
    }
}