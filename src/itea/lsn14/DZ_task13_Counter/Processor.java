package itea.lsn14.DZ_task13_Counter;

import java.io.FileOutputStream;

public class Processor extends Thread {
    FileOutputStream file;
    MyCounter counter;
    byte[] buf = new byte[1024];
    int position, r;
    public Processor(MyCounter counter, byte[] buf, int position, FileOutputStream file, int r) {
        this.counter = counter;
        this.buf = buf;
        this.position = position;
        this.file = file;
        this.r = r;
    }
    @Override
    public void run() {
        synchronized (counter) {
            int current = counter.get();
            while (current != position) {
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    return;
                }
                current = counter.get();
            }
            try {
                file.write(buf, 0, r);
            }
            catch (Exception ex) {
                System.out.println("Проблема с файлом для записи");
            }
            counter.set(counter.get() + 1);
            counter.notifyAll();
        }
    }
}
