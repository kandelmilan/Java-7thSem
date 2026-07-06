
package UDP;
import java.net.*;

public class Client2 {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(556);

        byte[] rdata = new byte[1000];

        DatagramPacket dp = new DatagramPacket(rdata, rdata.length);

        ds.receive(dp);

        String rmsg = new String(dp.getData(), 0, dp.getLength());

        System.out.println("Received from Server: " + rmsg);

        ds.close();
    }
}