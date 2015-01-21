package itea.lsn14.Wrk;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ITEA on 13.01.2015.
 */
public class ContainerDemoTrue {
    private static class TestThread extends Thread {
        private AtomicInteger c;
        public TestThread(AtomicInteger c) {
            this.c = c;
        }
        public void run() {
            int x = c.getAndIncrement();
        }
    }
    public static void main(String[] args) {
        AtomicInteger c = new AtomicInteger();
        TestThread t;
        for (int i = 0; i < 10; i++) {
            t = new TestThread(c);
            t.start();
        }
    }
}
