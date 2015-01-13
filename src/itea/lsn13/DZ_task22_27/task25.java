package itea.lsn13.DZ_task22_27;

import java.util.ArrayList;

/** Создать поток, который создаст 50 потоков, каждый из которых выведет на экран свой номер и дождется,
 *  пока его прервут. Прерывание дочерних потоков должно выполнятся из потока их порождающего.
 */
public class task25 {
    public static class SubCounter extends Thread {
        public void run() {
            printThreadCondition(" started");
            while ( ! isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //System.out.println(getName() + " interrupted!");
                    return;
                }
            }
            printThreadCondition(" interrupted");
        }
    }
    public static class Counter extends Thread {
        public void run() {
            printThreadCondition(" MAIN started");
            ArrayList<SubCounter> threads = new ArrayList<SubCounter>();
            for (int i = 0; i < 50; i++) {
                SubCounter sc = new SubCounter();
                sc.start();
                threads.add(sc);
            }
            for (SubCounter sc : threads)
                sc.interrupt();
            printThreadCondition(" MAIN finished");
        }
    }
    static void printThreadCondition(String st) {
        System.out.println(Thread.currentThread().getId() + st);
    }
    public static void main(String[] args) throws InterruptedException {
        printThreadCondition(" started");
        Counter c = new Counter();
        c.start();
        c.join();
        printThreadCondition(" finished");
    }
}
