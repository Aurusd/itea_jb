package itea.lsn8.DZ82_WorkWithFile;

import java.io.RandomAccessFile;

/** Написать программу, которая считает текстовый файл, заменит в нем все слова “Hello” на “1234”
 *  и запишет изменения в тот-же файл.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            RandomAccessFile r = new RandomAccessFile("C:\\Temp\\1.txt", "rw");
            try {
                r.seek(0);
                int count = 0;
                while (r.length() > r.getFilePointer()) {
                    count++;
                    r.readLine();
                }
                String[] linesInFile = new String[count];
                r.seek(0);
                for (int i = 0; i < count; i++) {
                    String str = r.readLine();
                    if (str.contains("Hello"))
                        linesInFile[i] = str.replace("Hello", "1234");
                    else
                        linesInFile[i] = str;
                }
                r.setLength(0);
                for (int i = 0; i < count; i++) {
                    String str = linesInFile[i];
                    if (i != count - 1)
                        str += "\r\n";
                    r.write(str.getBytes());
                }
            } finally {
                r.close();
            }
        } catch (Exception ex) {}
    }
}