package itea.lsn13.DZ_task22_27;

import java.util.ArrayList;

/**
 * Создать 100 потоков, каждый их которых выведет на экран свой номер и дождется, пока его прервут.
 */
public class task24 {
    public static class Counter extends Thread {
        public void run() {
            System.out.println(getName() + " created");
            while ( ! isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted!");
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Counter> threads = new ArrayList<Counter>();
        for (int i = 0; i < 100; i++) {
            Counter c = new Counter();
            c.start();
            threads.add(c);
        }
        Thread.sleep(5000);
        for (Counter c : threads)
            c.interrupt();
    }
}
