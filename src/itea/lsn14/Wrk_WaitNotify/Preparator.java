package itea.lsn14.Wrk_WaitNotify;

import java.io.RandomAccessFile;

public class Preparator extends Thread {
    Data mutex;
    String file;
    public Preparator(Data mutex, String file) {
        this.mutex = mutex;
        this.file = file;
    }
    public void run() {
        byte[] data; // Массив для данных
        System.out.println("Data is being prepared....");
//---------------- чтение данных из файла ----------------\\
        try {
            RandomAccessFile fs = new RandomAccessFile(file, "r");
            try {
                data = new byte[(int)fs.length()];
                fs.read(data);
            } finally {
                fs.close();
            }
        } catch (Exception ex) {
            data = null;
        }
//--------------------------------------------------------//
        synchronized (mutex) {
// Сбрасываем считаные данные в хранилище.
            mutex.set(data);
// Нотифицируем ожидающих данные.
            mutex.notifyAll();
        }
    }
}
