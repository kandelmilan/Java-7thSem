

/* 

Write a Java Program to demonstrate Multithreading apllication by following ways
a) By implementing Runnable Interface
b) By extending Thread Class

*/


class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread using Runnable Interface: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// b) Extending Thread Class
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread using Thread Class: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Q2008 {
    public static void main(String[] args) {

        // Runnable Interface
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);

        // Thread Class
        MyThread t2 = new MyThread();

        // Start Threads
        t1.start();
        t2.start();
    }
}