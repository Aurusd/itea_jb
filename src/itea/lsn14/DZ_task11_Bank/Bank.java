package itea.lsn14.DZ_task11_Bank;

/**
 * Изменить решение задачи про банк так, чтобы баланс никогда не становился меньше 100 у.е.
 */
public class Bank {
    public static void main(String[] args) throws Exception {
        int accStart = 1000;
        Account acc = new Account(accStart);
        System.out.println("Начальный баланс: " + accStart);
        for (int i = 0; i < 100; i++) {
            Action act = new Action(acc, 10);
            act.start();
        }
        Thread.sleep(5000);
        System.out.println("Баланс: " + acc.get());
    }
}
