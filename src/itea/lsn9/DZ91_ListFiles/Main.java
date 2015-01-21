package itea.lsn9.DZ91_ListFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Написать программу, которая создаст текстовый файл и запишет в
 *  него список файлов (путь, имя, дата создания) из заданного каталога.
 */
public class Main {

    static String path = "C:\\Temp\\";

    public static void main(String[] args) throws Exception {
        // создаем список файлов из заданного каталога
        File file = new File(path);
        FilenameFilter filter = new NameFilter();
        String[] ar = file.list(filter);
        // создаем текстовый файл и записываем в него наш список (путь, имя, дата создания)
        try {
            RandomAccessFile raf = new RandomAccessFile(path + "list_f.txt", "rw");
            try {
                for (int i = 0; i < ar.length; i++) {
                    File f = new File(path + ar[i]);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String str = path + ", " + f.getName() + ", " + sdf.format(new Date(f.lastModified()));
                    if (i != ar.length - 1)
                        str += "\r\n";
                    raf.write(str.getBytes());
                }
            }
            finally {
                raf.close();
            }
        } catch (Exception ex) {}
    }

    static class NameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir.getAbsoluteFile() + "\\" + name);
            return file.isFile();
        }
    }
}