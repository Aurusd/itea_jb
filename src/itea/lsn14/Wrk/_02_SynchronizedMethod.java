package itea.lsn14.Wrk;

/**
 * Created by ITEA on 13.01.2015.
 */
public class _02_SynchronizedMethod {
    private static class Container {
        public int x = 0, y = 0;
        public synchronized void inc() {  // !!!!!
            x++; y++;
        }
    }
    private static class TestThread  extends Thread {
        Container c;
        public TestThread(Container c) {
            this.c = c;
        }
        public void run() {
            try {
                Thread.sleep(System.currentTimeMillis() %  100);
            } catch (InterruptedException e) {}
            c.inc();
        }
    }
    public static void main(String[] args) throws Exception {
        Container c = new Container();
        TestThread t;
        for (int i = 0; i < 10; i++) {
            t = new TestThread(c);
            t.start();
        }
        Thread.sleep(5000);
        System.out.println(c.x + ", " + c.y);
    }
}
