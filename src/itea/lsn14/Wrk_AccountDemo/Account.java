package itea.lsn14.Wrk_AccountDemo;

/**
 * Created by ITEA on 13.01.2015.
 */
public class Account {
    int money;
    public Account(int money) {
        this.money = money;
    }
    public int get() {
        return money;
    }
    public void set(int x) {
        money = x;
    }
}
