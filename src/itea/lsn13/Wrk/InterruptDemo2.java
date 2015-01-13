package itea.lsn13.Wrk;

import java.util.ArrayList;

public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<InterruptDemo.Counter> threads = new ArrayList<InterruptDemo.Counter>();
        for (int i = 0; i < 10; i++) {
            InterruptDemo.Counter c = new InterruptDemo.Counter();
            c.start();
            threads.add(c);
        }
        Thread.sleep(5000);
        for (InterruptDemo.Counter c : threads)
            c.interrupt();
    }
}
