package itea.lsn12.Wrk_ArrayIex;

import java.util.Arrays;

/**
 * Created by Iex on 12/25/2014.
 */
public class Task_12_1 {

    static class SmartArray<E> {
        private Object[] elements;
        private int lastIndex = -1;

        public SmartArray() {
            elements = new Object[16];
        }

        public SmartArray(E[] elements) {
            this.elements = elements;
            lastIndex = elements.length - 1;
        }

        @SuppressWarnings("unchecked")
        public E get(int index) {
            return (E)elements[index];
        }

        public void add(E e) {
            elements[++lastIndex] = e;
        }

        @Override
        public String toString() {
            return Arrays.toString(elements);
        }
    }

    public static void main(String[] args) {
        Byte[] bt = new Byte[] {1, 2, 3, 4, 5};
        SmartArray<Byte> array = new SmartArray<Byte>(bt);
        System.out.println(array);
        System.out.println(array.get(4));
        String[] str = new String[] {"1sdfsf", "2dsfsv", "3kljh", "4kjbh", "5jhvk"};
        SmartArray<String> arrayS = new SmartArray<String>(str);
        System.out.println(arrayS);
        System.out.println(arrayS.get(4));

        new SmartArray<String>(new String[] {"1", ""}).get(0);
    }
}
