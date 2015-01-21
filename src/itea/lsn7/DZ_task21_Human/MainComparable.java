package itea.lsn7.DZ_task21_Human;

import java.util.Arrays;

public class MainComparable {

    public static void main(String[] args) {
        Human[] list = {new Human(40), new Human(20), new Human(3), new Human(7)};
        Arrays.sort(list);
        for (Human h : list)
            System.out.println(h.getAge());
    }
}

    /*class DZ_task21_Human {
        private int age;
        public DZ_task21_Human(int age) {
            this.age = age;
        }
        public int getAge() {
            return age;
        }
    }*/

class Human implements Comparable {
    private int age;
    public Human(int age) { this.age = age; }
    public int getAge() { return age; }
    @Override
    public int compareTo(Object another) { //чтоб сортировка была по убыванию - поменять местами знаки "<" и ">"
        Human h = (Human) another;
        if (age < h.age)
            return -1;
        else if (age == h.age)
            return 0;
        else if (age > h.age)
            return 1;
        else
            return 0; // make compiler happy
    }
}