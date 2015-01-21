package itea.lsn14.DZ_task11_Bank;

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
