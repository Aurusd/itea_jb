package itea.lsn8.DZ83_CopyFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;

/**
 * Копирование всех файлов из одного каталога в другой
 */

public class Main {
    static String pathTarg = "C:\\Temp\\11\\";
    static String pathDest = "C:\\Temp\\22\\";

    public static void main(String[] args) throws Exception {
        File file = new File(pathTarg);
        FilenameFilter filter = new MyFilter();
        String[] ar = file.list(filter);
        for (int i = 0; i < file.length(); i++) {
            try {
                RandomAccessFile rafTarg = new RandomAccessFile(pathTarg + ar[i], "r");
                RandomAccessFile rafDest = new RandomAccessFile(pathDest + ar[i], "rw");
                try {
                    while (rafTarg.length() > rafTarg.getFilePointer()) {
                        String str = rafTarg.readLine();
                        if (rafTarg.length() > rafTarg.getFilePointer())
                            str += "\r\n";
                        rafDest.write(str.getBytes());
                    }
                }
                finally {
                    rafTarg.close();
                    rafDest.close();
                }
            } catch (Exception ex) {}
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
