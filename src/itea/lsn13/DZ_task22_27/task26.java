package itea.lsn13.DZ_task22_27;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Копирование файла блоками (1 поток на блок).
 */
public class task26 {
    public static void main(String[] args) throws Exception {
        copyFile("c:\\Temp\\1.txt", "c:\\Temp\\2.txt");
    }

    public static class Counter extends Thread {
        public void run(FileOutputStream out, byte[] buf, int r) {
            try {
                out.write(buf, 0, r);
            }
            catch (Exception ex) {}
        }
    }

    public static void copyFile(String src, String dest) throws Exception {
        FileInputStream in = new FileInputStream(src);
        try {
            FileOutputStream out = new FileOutputStream(dest);
            try {
                byte[] buf = new byte[1024]; // 1 KB
                int r;
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0) {
                        Counter c = new Counter();
                        c.start();
                    }
                        //out.write(buf, 0, r);
                } while (r > 0);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
