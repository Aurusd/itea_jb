package itea.lsn11.DZ_task1_2_Human;

import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class Main {

    // Добавить в класс "человек" константы: пол, темперамент.
    // Реализовать возможность сериализации для класса "человек".

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human[] list = {new Human("Вася", 40, 0, 0), new Human("Петя", 20, 0 , 1),
                new Human("Олег", 3, 0, 2), new Human("Юра", 7, 0, 3), new Human("Оля", 6, 1, 2)};
        Arrays.sort(list);
        for (Human h : list)
            System.out.println(h);

        // запись
        System.out.println("Проводим сериализацию списка, изменив перед этим имена.");
        try {
            FileOutputStream fos = new FileOutputStream("D:\\Temp\\humans.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            try {
                for (Human h : list) {
                    h.setName("_new");
                    oos.writeObject(h);
                }
            } finally {
                oos.close();
            }
        }
        catch (IOException ex) {}

        // чтение
        System.out.println("Читаем из файла:");
        FileInputStream fis = new FileInputStream("D:\\Temp\\humans.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        try {
            for (int i = 0; i < list.length; i++)
                System.out.println((Human) oin.readObject());
        } finally {
            oin.close();
        }
    }
}

class Human implements Comparable, Serializable {
    private String name;
    private int age, sex, temperament;

    public Human(String name, int age, int sex, int temperament) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.temperament = temperament;
    }

    public void setName(String name) {
        this.name += name;
    }

    enum Sex {MALE, FEMALE}

    enum Temperament {CHOLERIC, SANGUINE, PHLEGMATIC, MELANCHOLIC}

    @Override
    public String toString() { return name + ", возраст " + age + ", пол " + Sex.values()[sex] + ", темперамент "
            + Temperament.values()[temperament]; }

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
