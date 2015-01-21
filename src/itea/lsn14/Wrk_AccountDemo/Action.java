package itea.lsn14.Wrk_AccountDemo;

/**
 * Created by ITEA on 13.01.2015.
 */
public class Action extends Thread {
    Account acc; //С какого аккаунта
    int withdraw; //..сколько снять.
    public Action(Account acc, int withdraw) {
        this.acc = acc;
        this.withdraw = withdraw;
    }
    @Override
    public void run() {
// Синхронизация на аккаунте
        synchronized (acc) {
// Сколько остаток на счету?
            int has = acc.get();
// Остаток позволяет снять нужную сумму?
            if (has >= withdraw) {
// Устанавливаем новый баланс
                acc.set(acc.get() - withdraw);
            }
        }
    }
}
