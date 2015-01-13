package itea.lsn13.DZ_task22_27;

/**
 * Модифицировать класс Counter так, чтобы он циклически выводил числа из определенного диапазона.
 */
public class task22 {
    public static class Counter extends Thread {
        public void run() {
            int x = 1;
            while ( ! isInterrupted()) {
                System.out.println(getId() + ": " + x++);
                try {
                    Thread.sleep(1000); // закомментировать
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted!");
                    return;
                }
            }
            System.out.println("isInterrupted() : false");
        }
    }
    public static void main(String[] args) {
        Counter c = new Counter();
        c.start(); // запускаем поток
        try { Thread.sleep(5000); } // ждем 5 сек
        catch (Exception e) {e.printStackTrace();}
        c.interrupt(); // прерываем поток
    }
}
