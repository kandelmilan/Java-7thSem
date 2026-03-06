/*
Write a class Distance containing private variables feet of type int and inches of type int,suitable constructor,and two methods 
addDistance for adding and display distance objects.Write a separate class MyDistance containing main method to create and use 
distance obejcts
 */
package javalab;
// Distance class
class Distance {

    // Private variables
    private int feet;
    private int inches;

    // Constructor
    public Distance(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    // Method to add two Distance objects
    public Distance addDistance(Distance d) {
        int totalFeet = this.feet + d.feet;
        int totalInches = this.inches + d.inches;

        // Convert inches to feet if >= 12
        if (totalInches >= 12) {
            totalFeet += totalInches / 12;
            totalInches = totalInches % 12;
        }

        return new Distance(totalFeet, totalInches);
    }

    // Method to display distance
    public void display() {
        System.out.println(feet + " feet " + inches + " inches");
    }
}

// Separate class with main method
public class Q16 {

    public static void main(String[] args) {

        Distance d1 = new Distance(5, 8);
        Distance d2 = new Distance(3, 9);

        System.out.print("Distance 1: ");
        d1.display();

        System.out.print("Distance 2: ");
        d2.display();

        Distance result = d1.addDistance(d2);

        System.out.print("Total Distance: ");
        result.display();
    }
}
