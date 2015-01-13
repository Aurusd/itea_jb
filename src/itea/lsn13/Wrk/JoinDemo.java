package itea.lsn13.Wrk;

public class JoinDemo {
    public static class Counter extends Thread {
        public void run() {
            printThreadStart();
            int x = 1;
            while (x < 10000)
                System.out.println(x++);
            printThreadFinish();
        }
    }
    /**
     * @throws InterruptedException - can be thrown by join()
     */
    public static void main(String[] args) throws InterruptedException {
        printThreadStart();
        Counter c = new Counter();
        c.start(); // запускаем поток
        c.join(); // ждем завершения потока
        printThreadFinish();
    }
    static void printThreadFinish() {
        System.out.println(Thread.currentThread().getName() + " finished");
    }
    static void printThreadStart() {
        System.out.println(Thread.currentThread().getName() + " started");
    }
}
