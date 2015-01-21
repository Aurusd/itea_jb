package itea.lsn15.Wrk_NET;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Browse2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://javaschool.com.ua");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000];
            StringBuilder sb = new StringBuilder();
            int r;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
            System.out.println(sb.toString());
        } finally {
            http.disconnect();
        }
    }
}
