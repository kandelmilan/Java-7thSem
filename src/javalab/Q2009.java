/*
Wtite a Java program to set and get thread priorities in multithreaded application.
*/
package javalab;
class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
    }
}

public class Q2009 {

    public static void main(String[] args) {

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");

        // Setting priorities
        t1.setPriority(Thread.MIN_PRIORITY);   // 1
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MAX_PRIORITY);   // 10

        // Getting priorities
        System.out.println("Priority of " + t1.getName() + " : " + t1.getPriority());
        System.out.println("Priority of " + t2.getName() + " : " + t2.getPriority());
        System.out.println("Priority of " + t3.getName() + " : " + t3.getPriority());

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}