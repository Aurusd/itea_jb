package itea.lsn14.Wrk_WaitNotify;

import java.io.RandomAccessFile;

public class Processor extends Thread {
    Data mutex;
    String file;
    public Processor(Data mutex, String file) {
        this.mutex = mutex;
        this.file = file;
    }
    public void run() {
        System.out.println("Waiting for data...");
// Получение данных для изменения.
        synchronized (mutex) {
            try {
// Ждем сигнала о получении новых данных
                mutex.wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Got data. Processing it...");
// Изменение данных
        byte[] data = mutex.get();
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
// Сброс измененных данных в файл.
        try {
            RandomAccessFile f = new RandomAccessFile(file, "rw");
            try {
                f.write(mutex.get());
            } finally {
                f.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Data has been processed to " + file);
    }
}
