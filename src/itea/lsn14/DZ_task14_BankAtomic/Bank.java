package itea.lsn14.DZ_task14_BankAtomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Решить задачу про банк с помощью java.util.concurrent.atomic.*
 */
public class Bank {
    public static void main(String[] args) throws Exception {
        int accStart = 1000;
        Account acc = new Account(new AtomicInteger(accStart));
        System.out.println("Начальный баланс: " + accStart);
        for (int i = 0; i < 100; i++) {
            Action act = new Action(acc, 10);
            act.start();
        }
        Thread.sleep(5000);
        System.out.println("Баланс: " + acc.get());
    }
}
