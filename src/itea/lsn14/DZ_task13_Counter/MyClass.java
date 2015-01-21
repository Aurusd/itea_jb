package itea.lsn14.DZ_task13_Counter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/** Написать класс, который позволит последовательно, так чтобы данные не накладывались друг на друга,
 *  записывать данные в один файл из разных потоков.
 */
public class MyClass {
    static final String FROM_FILE = "c:\\temp\\from.docx";
    static final String TO_FILE = "c:\\temp\\to.docx";

    public static void main(String[] args) throws Exception {
        MyCounter cnt = new MyCounter(1);
        FileInputStream in = new FileInputStream(FROM_FILE);
        try {
            FileOutputStream out = new FileOutputStream(TO_FILE);
            try {
                byte[] buf = new byte[1024];
                int r;
                int i = 1;
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0) {
                        Processor sbt = new Processor(cnt, buf, i++, out, r);
                        sbt.start();
                        Thread.sleep(20);                   // паузу надо обязательно,
                        // иначе возможен фактический старт следующего потока раньше, чем предыдущий
                    }
                } while (r > 0 || cnt.get() != i);
                System.out.println("Файл записан с помощью " + (i - 1) + " потоков.");
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
