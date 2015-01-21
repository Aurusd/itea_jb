package itea.lsn8.DZ86_CopyFilesSequence;

import java.io.*;

/** Написать программу, которая скопирует несколько файлов в один.
 *  Подумать как для этого использовать java.io.SequenceInputStream.       НЕ СДЕЛАНО
 */
public class Main {

    static String pathTarg = "C:\\Temp\\11\\";

    public static void main(String[] args) throws Exception {
        File file = new File(pathTarg);
        FilenameFilter filter = new MyFilter();
        String[] ar = file.list(filter);

        /*InputStream n1 = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        }
        InputStream n2 = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        }

        SequenceInputStream sis = new SequenceInputStream(n1, n2);*/
        FileOutputStream out = new FileOutputStream(pathTarg + "result_f.txt");
        try {
            for (int i = 0; i < ar.length; i++) {
                FileInputStream in = new FileInputStream(pathTarg + ar[i]);
                try {
                    byte[] buf = new byte[1024]; // 1 KB
                    int r;
                    do {
                        r = in.read(buf, 0, buf.length);
                        if (r > 0)
                            out.write(buf, 0, r);
                    } while (r > 0);
                } finally {
                    in.close();
                }
            }
        } finally {
            out.close();
        }
    }

    static class MyFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir.getAbsoluteFile() + "\\" + name);
            return file.isFile();
        }
    }
}