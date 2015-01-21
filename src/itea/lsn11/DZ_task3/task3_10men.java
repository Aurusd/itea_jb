package itea.lsn11.DZ_task3;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/** Написать программу, которая запросит ввести с консоли информацию о 10 людях, запишет ее на диск,
 *  а при следующем старте прочитает записи и выведет сохраненные данные на экран.
 *  Одинаковые записи должны игнорироваться (Set + equals*).      СДЕЛАЛ не на 10, а на 5, ибо долго вводить)))
 */
public class task3_10men {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("D:\\Temp\\10men.out");
        if (file.exists()) { // файл есть, выводим инфо
            System.out.println("Файл есть, выводим из него информацию.");
            FileInputStream fis = new FileInputStream("D:\\Temp\\10men.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            try {
                for (int i = 0; i < 4; i++)
                    System.out.println((Human) oin.readObject());
            } finally {
                oin.close();
            }
        }
        else { // файла нет, создаем его и вводим инфо
            System.out.println("Файла нет, создаём его и сохраняем в нём список людей.");
            LinkedList<Human> list = new LinkedList<Human>();
            try {
                FileOutputStream fos = new FileOutputStream("D:\\Temp\\10men.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                try {
                    int i = 0;
                    do {
                        Human newH = addHuman();
                        if (compareHuman(list, newH)) {
                            list.add(newH);
                            oos.writeObject(newH);
                            i++;
                        }
                    } while (i < 4);
                } finally {
                    oos.close();
                }
            }
            catch (IOException ex) {}
        }
    }

    private static Human addHuman() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите имя: ");
        String name = br.readLine();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(br.readLine());
        System.out.print("Введите пол (муж. - 0, жен. - 1): ");
        int sex = Integer.parseInt(br.readLine());
        System.out.print("Введите темперамент (холерик - 0, сангвиник - 1, флегматик - 2, меланхолик - 3): ");
        int temper = Integer.parseInt(br.readLine());
        return new Human(name, age, sex, temper);
    }

    private static boolean compareHuman(LinkedList<Human> list, Human newH) {
        boolean flag = true;
        Iterator<Human> iterator = list.iterator();
        while (iterator.hasNext()) {
            Human oldH = iterator.next();
            if (oldH.getName().equals(newH.getName()) && oldH.getAge() == newH.getAge()
                    && oldH.getSex() == newH.getSex() && oldH.getTemperament() == newH.getTemperament()) {
                flag = false;
                System.out.println("Информация о таком человеке уже есть.");
            }
        }
        return flag;
    }
}

class Human implements Serializable {
    private String name;
    private int age, sex, temperament;

    public Human(String name, int age, int sex, int temperament) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.temperament = temperament;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public int getTemperament() {
        return temperament;
    }

    enum Sex {MALE, FEMALE}

    enum Temperament {CHOLERIC, SANGUINE, PHLEGMATIC, MELANCHOLIC}

    @Override
    public String toString() { return name + ", возраст " + age + ", пол " + Sex.values()[sex] + ", темперамент "
            + Temperament.values()[temperament]; }
}
