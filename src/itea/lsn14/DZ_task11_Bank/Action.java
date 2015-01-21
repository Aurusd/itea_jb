package itea.lsn14.DZ_task11_Bank;

public class Action extends Thread {
    Account acc; //С какого аккаунта
    int withdraw; //..сколько снять.
    int minCount = 100; //..минимальный баланс.
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
            System.out.print(getName() + ": ");
            if (has >= withdraw + minCount) {
// Устанавливаем новый баланс
                acc.set(acc.get() - withdraw);
                System.out.println("снято " + withdraw + ", остаток " + acc.get());
            }
            else
                System.out.println("снять " + withdraw + " невозможно, т.к. после операции остаток будет меньше " + minCount);
        }
    }
}
