package itea.lsn15.Wrk_NET;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Input: host names
 * Output: ip addresses for the given host names
 */
public class DnsDemo {
    public static void main(String[] args) {
        args = new String[]{"javaschool.com.ua"};
        for (String hostName : args) {
            try {
                InetAddress ip = InetAddress.getByName(hostName);
                String answer = String.format("%s => %s%n", hostName, ip.getHostAddress());
                System.out.println(answer);
            } catch (UnknownHostException e) {
                System.out.println("Cannot determine IP address for " + hostName);
            }
        }
    }
}
