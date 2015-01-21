package itea.lsn14.DZ_task14_BankAtomic;

public class Action extends Thread {
    Account acc; // с какого аккаунта
    int withdraw; // сколько снять.
    int minCount = 100; // минимальный баланс
    public Action(Account acc, int withdraw) {
        this.acc = acc;
        this.withdraw = withdraw;
    }
    @Override
    public void run() {
        synchronized (acc) {
            if (acc.get().intValue() >= withdraw + minCount) {
                acc.get().addAndGet(-withdraw);
                System.out.println("снято " + withdraw + ", остаток " + acc.get());
            }
            else
                System.out.println("снять " + withdraw + " невозможно, т.к. после операции остаток будет меньше " + minCount);
        }
    }
}
