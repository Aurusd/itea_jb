package itea.lsn14.Wrk_WaitNotify;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

/**
 * Created by ITEA on 13.01.2015.
 */
public class WaitNotifyDemo {
    public static final String OUT_TXT = "c:\\out.txt";
    public static final String IN_TXT = "c:\\in.txt";
    public static void main(String[] args) throws Exception {
        createTestInFile(IN_TXT);
        Data mtx = new Data();
        Processor pc = new Processor(mtx, OUT_TXT);
        pc.start();
        Preparator pr = new Preparator(mtx, IN_TXT);
        pr.start();
    }
    private static void createTestInFile(String fileName) throws Exception {
        try (Writer writer = new FileWriter(fileName)) {
            char[] buf = new char[2_418];
            Arrays.fill(buf, '1');
            writer.write(buf);
        }
    }
}
