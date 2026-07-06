//import java.net.*;
//
//public class C1 {
//    public static void main(String[] args) throws Exception {
//
//        DatagramSocket ds = new DatagramSocket();
//
//        String msg = "Hello Server";
//        byte[] data = msg.getBytes();
//
//        DatagramPacket dp = new DatagramPacket(
//            data,
//            data.length,
//            InetAddress.getByName("localhost"),
//            55
//        );
//
//        ds.send(dp);
//
//        byte[] rdata = new byte[1000];
//        DatagramPacket rdp = new DatagramPacket(rdata, rdata.length);
//
//        ds.receive(rdp);
//
//        String reply = new String(rdp.getData(), 0, rdp.getLength());
//        System.out.println("Server Reply: " + reply);
//
//        ds.close();
//    }
//}

import java.net.*;

public class C1{
    public static void main(String[] args)throws Exception{
        DatagramSocket ds=new DatagramSocket();
        
        String msg="Hello I want a help";
        byte[] data=msg.getBytes();
        InetAddress ia=InetAddress.getLocalHost();
        DatagramPacket dp=new DatagramPacket(data,data.length,ia,55);
        
        ds.send(dp);
        
        byte[] rdata=new byte[1000];
        DatagramPacket dp1=new DatagramPacket(rdata,rdata.length);
        ds.receive(dp1);
        String rmsg=new String(dp1.getData(),0,dp1.getLength());
        System.out.print("Server reply"+rmsg);
        ds.close();
    }
}