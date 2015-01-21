package itea.lsn14.Wrk_AccountDemo;

/**
 * Created by ITEA on 13.01.2015.
 */
public class AccountDemo {
    public static void main(String[] args) throws Exception {
        Account acc = new Account(1000);
        for (int i = 0; i < 100; i++) {
            Action act = new Action(acc, 10);
            act.start();
        }
        Thread.sleep(5000);
        System.out.println(acc.get());
    }
}
