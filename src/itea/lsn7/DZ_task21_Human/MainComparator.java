package itea.lsn7.DZ_task21_Human;

import java.util.Arrays;
import java.util.Comparator;

public class MainComparator {
    public static void main(String[] args) {
        HumanCr[] list = {
                new HumanCr(40), new HumanCr(20), new HumanCr(3), new HumanCr(7)
        };
        Arrays.sort(list, new HumanComparator());
        for (HumanCr h : list)
            System.out.println(h.getAge());
    }
}

class HumanCr {
    private int age;
    public HumanCr(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

class HumanComparator implements Comparator {
    @Override   //чтоб сортировка была по убыванию - поменять местами знаки "<" и ">"
    public int compare(Object o1, Object o2) {
        HumanCr h1 = (HumanCr)o1;
        HumanCr h2 = (HumanCr)o2;
        if (h1.getAge() < h2.getAge())
            return -1;
        else if (h1.getAge() == h2.getAge())
            return 0;
        else if (h1.getAge() > h2.getAge())
            return 1;
        return 0; // make compiler happy
    }
}