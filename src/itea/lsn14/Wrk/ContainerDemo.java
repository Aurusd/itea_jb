package itea.lsn14.Wrk;

/**
 * Created by ITEA on 13.01.2015.
 */

public class ContainerDemo {
    private static class Container {
        public volatile int x = 0;
    }
    private static class TestThread extends Thread {
        private Container c;
        public TestThread(Container c) {
            this.c = c;
        }
        public void run() {
            c.x++; // ОШИБКА!!!
        }
    }
    public static void main(String[] args) {
        Container c = new Container();
        TestThread t;
        for (int i = 0; i < 10; i++) {
            t = new TestThread(c);
            t.start();
        }
    }
}