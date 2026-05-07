// 2. Write a java program using TCP that enables chatting between client and Server.
package lab6;
import java.net.*;
import java.io.*;
//This is Server
public class Q2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Server..............");
        ServerSocket ss = new ServerSocket(95);
        System.out.println("Waiting for Client...........");
        Socket cs = ss.accept();
        System.out.println("Connected With Client.............");
        BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("To Client:");
            String ic = in.readLine();
            out.println(ic);

            String oc = br.readLine();
            System.out.println("From Client:" + oc);
            if (ic.equalsIgnoreCase("bye") || ic == null)
                break;

        }
        br.close();
        out.close();
        ss.close();
    }
}