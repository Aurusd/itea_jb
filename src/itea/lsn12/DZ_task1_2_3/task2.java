package itea.lsn12.DZ_task1_2_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/** Написать метод, который создаст список, положит в него 10 элементов,
 *  затем удалит первые два и последний, а затем выведет результат на экран
 */
public class task2 {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(1000));
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
