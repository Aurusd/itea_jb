package itea.lsn13.DZ_task22_27;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/** Создать поток, который будет каждые 10 секунд выводить текущее время на экран.
 *  Сделать возможность прерывания потока с помощью команды с консоли.
 */
public class task23 {
    public static class Counter extends Thread {
        public void run() {
            while ( ! isInterrupted()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(sdf.format(System.currentTimeMillis()));
                try {
                    Thread.sleep(10000);
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
        System.out.println("Для завершения работы нажмите Enter.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        /*try { Thread.sleep(5000); } // ждем 5 сек
        catch (Exception e) {e.printStackTrace();}*/
        c.interrupt(); // прерываем поток
    }
}
