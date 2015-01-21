package itea.lsn15.Wrk_NET;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Browse {
    public static void main(String[] args) {
        try (Socket socket = new Socket("javaschool.com.ua", 80)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("GET / HTTP/1.1");
            pw.println("Host: javaschool.com.ua");
            pw.println("");
            pw.flush();

            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1000];
            int r;

            do {
                if ((r = s.read(buf)) > 0)
                    System.out.println(new String(buf, 0, r));
            } while (r > 0);
        } catch (UnknownHostException e) {
            System.out.println("Error: misspelling in hostname");
        } catch (IOException e) {
            System.out.println("Read-write error");
        }
    }
}
