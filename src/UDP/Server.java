package UDP;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(555);

        byte[] rdata = new byte[1000];

        DatagramPacket dp = new DatagramPacket(rdata, rdata.length);

        ds.receive(dp);

        String rmsg = new String(dp.getData(), 0, dp.getLength());

        // convert and decrement character
        char ch = rmsg.charAt(0);

        ch = (char)(ch - 1);

        String smsg = String.valueOf(ch);

        byte[] sdata = smsg.getBytes();

        InetAddress ia = InetAddress.getByName("localhost");

        DatagramPacket dp1 = new DatagramPacket(
            sdata,
            sdata.length,
            ia,
            556   // Client2 port
        );

        ds.send(dp1);

        System.out.println("Character processed and sent to Client2");

        ds.close();
    }
}