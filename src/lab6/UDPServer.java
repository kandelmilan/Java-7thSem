// 3. Write a java program using UDP that enables two way communication between client and server
import java.io.*;
import java.net.*;
//This is Server
public class UDPServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(5555);
        System.out.println("Server is Ready .............");
        //Recieve Message
        byte[] rdata = new byte[1000];
        DatagramPacket dp = new DatagramPacket(rdata, rdata.length);
        ds.receive(dp);
        String rmsg = new String(dp.getData(),0,dp.getLength());
        System.out.println("Recieve Message :"+rmsg);
        
        //Send Message
        String smsg = "Hello I am a Server ...........";
        byte[] sdata = smsg.getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(sdata, sdata.length, ia, dp.getPort());
        ds.send(dp1);
        System.out.println("Message Sent from server........");
    }
}