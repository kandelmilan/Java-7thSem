/*
Lab-6 : Socket Programming and Servlet Programming
1. Write  a Java Program to demonstrate the following Network Class in JDK
a. URL Class
*/

import java.net.*;

public class Q6a {
    public static void main(String[] args) throws Exception {
        String url = "http://www.example.com:80/index.html";
        URL ur = new URL(url);
        System.out.println("Protocol:" + ur.getProtocol());
        System.out.println("Server Name:" + ur.getHost());
        System.out.println("Port Number:" + ur.getPort());
        System.out.println("File Name:" + ur.getFile());
    }
}