/*
Lab-6 : Socket Programming and Servlet Programming
1. Write  a Java Program to demonstrate the following Network Class in JDK
a. URL Class
*/

import java.net.*;

public class Q6a {

    public static void main(String[] args) {

        try {

            // URL Class
            URL url = new URL("https://www.google.com/index.html");

            System.out.println("------ URL Class ------");
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Host     : " + url.getHost());
            System.out.println("Port     : " + url.getPort());
            System.out.println("File     : " + url.getFile());
            System.out.println("Path     : " + url.getPath());

            // URLConnection Class
            URLConnection con = url.openConnection();

            System.out.println("\n------ URLConnection Class ------");
            System.out.println("Content Type   : " + con.getContentType());
            System.out.println("Content Length : " + con.getContentLength());
            System.out.println("Date           : " + con.getDate());

            // InetAddress Class
            InetAddress ip = InetAddress.getByName("www.google.com");

            System.out.println("\n------ InetAddress Class ------");
            System.out.println("Host Name  : " + ip.getHostName());
            System.out.println("IP Address : " + ip.getHostAddress());

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}