package itea.lsn12.DZ_task1_2_3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Написать метод для конвертации массива строк или чисел в список
 */
public class task1 {

    static class Convert<E> {

        public Convert(E[] array) {

            ArrayList list = new ArrayList();
            for (int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
            Iterator<E> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] arInt = new Integer[] {121, 231, 341, 451, 561};
        new Convert<Integer>(arInt);

        String[] arStr = new String[] {"1kjghkjgh", "2mhjgbkh", "3mhkjh", "4kjhg", "5mjhg"};
        new Convert<String>(arStr);
    }
}
