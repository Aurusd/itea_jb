package itea.lsn10.Wrk;

/**
 *
 */
public class Finalization {
    public static void main(String[] args) throws InterruptedException {
        long time = 0xA60, k = 0;
        while (time-- > 0) {
            (new Plug()).k = k++;
        }
        System.out.println("Going to sleep...");
        Thread.sleep(5000);
    }
}


class Plug {
    long k;
    @Override
    protected void finalize() throws Throwable {
        System.out.println(k + " terminated");
        super.finalize();
    }
}