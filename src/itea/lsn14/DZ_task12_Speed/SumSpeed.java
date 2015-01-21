package itea.lsn14.DZ_task12_Speed;

import java.text.SimpleDateFormat;
import java.util.Random;

/** Написать код для многопоточного подсчета суммы элементов массива целых чисел.
 * Сравнить скорость подсчета с простым алгоритмом.
 */
public class SumSpeed {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("SS");
        int[] ar1 = new int[1000];
        Random r = new Random();
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = r.nextInt(1000);
        }
        System.out.println("Массив на 1000 целочисленных значений создан.");

        long timeStandartStart = System.currentTimeMillis();
        int sumAr1 = 0;
        for (int i = 0; i < ar1.length; i++) {
            sumAr1 += ar1[i];
        }
        long timeStandartFinish = System.currentTimeMillis() - timeStandartStart;
        System.out.println("Сумма элементов = " + sumAr1 + ", время суммирования - "
                + sdf.format(timeStandartFinish) + " мсек.");

        CurrSum sumAr2 = new CurrSum(0);
        long timeThreadStart = System.currentTimeMillis();
        for (int i = 0; i < ar1.length; i++) {
            SumByThreads sbt = new SumByThreads(sumAr2, ar1[i]);
            sbt.start();
        }
        while (sumAr2.get() != sumAr1)
            Thread.sleep(1);
        long timeThreadFinish = System.currentTimeMillis() - timeThreadStart;
        System.out.println("Сумма элементов = " + sumAr2.get() + ", время суммирования - "
                + sdf.format(timeThreadFinish) + " мсек.");

        if (timeThreadFinish > timeStandartFinish)
            System.out.println("Суммирование потоками идёт медленнее на "
                    + sdf.format(timeThreadFinish - timeStandartFinish) + " мсек.");
        else
            System.out.println("Суммирование потоками идёт быстрее на "
                    + sdf.format(timeStandartFinish - timeThreadFinish) + " мсек.");
    }
}
