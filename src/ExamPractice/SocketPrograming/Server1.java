
import java.net.*;
import java.io.*;

public class Server1 {

    public static void main(String[] args) throws Exception {
        System.out.println("Server Started");
        ServerSocket ss = new ServerSocket(55);
        System.out.println("Waiting  For Client");
        Socket cs = ss.accept();
        System.out.println("Client  Connected");

        BufferedReader bw = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        PrintWriter out = new PrintWriter(cs.getOutputStream(),true);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String clientMsg = bw.readLine();
            System.out.println("Client :" + clientMsg);
            if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println("Server :");
            String serverMsg = in.readLine();
            out.println(serverMsg);

            if (serverMsg.equalsIgnoreCase("bye")) {
                break;
            }

        }
        bw.close();
        out.close();
        cs.close();
        ss.close();
    }
}
