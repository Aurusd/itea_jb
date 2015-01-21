package itea.lsn14.DZ_task14_BankAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private AtomicInteger money;
    public Account(AtomicInteger money) {
        this.money = money;
    }
    public AtomicInteger get() {
        return money;
    }
    /*public void set(AtomicInteger x) {
        money = x;
    }*/
}
