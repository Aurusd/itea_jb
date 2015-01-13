package itea.lsn13.Wrk;

public class AnonymousRunnableClass {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int x = 0;
                while (x < 1000)
                    System.out.println(x++);
            }
        });
        t.start();
    }
}
