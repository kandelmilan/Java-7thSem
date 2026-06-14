package ExamPractice;

import java.math.*;

//Write a class Circle containing private variable radius of type float,suitable constructor , and two methoss findArea
//and findCricumference to find area and circumference of circles respectively. Write a separate class MyCircle containing 
//main methos to create and use circle objects .
class Circle {

    private float radius;

    public Circle(int r) {
        radius = r;
    }

    public void findArea() {

        float area =(float)( Math.PI * radius * radius);
        System.out.println("Area =" + area);
    }

    public void findCricumference() {
        float cic = (float)(2* Math.PI * radius);
        System.out.println("Cricumference =" + cic);
    }
}

public class practice {

    public static void main(String[] args) {
        Circle c = new Circle(2);
        c.findArea();
        c.findCricumference();

    }
}
