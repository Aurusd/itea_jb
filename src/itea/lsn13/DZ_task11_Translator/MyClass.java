package itea.lsn13.DZ_task11_Translator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/** Написать программу переводчик, которая будет переводить текст, написанный на одном языке,
 *  на другой язык согласно заранее составленному словарю.
 */
public class MyClass {

    public static void main(String[] args) {
        HashMap<String, String> dict = new HashMap<String, String>();
        dict.clear();
        dict.put("word", "слово");
        dict.put("peace", "мир");
        dict.put("bird", "птичка");
        dict.put("beer", "пиво");
        dict.put("cup", "чашка");
        Scanner sc = new Scanner(System.in);
        String newWord;
        do {
            System.out.print("Введите слово на англ. языке (окончание работы - пусто+Enter): ");
            newWord = sc.nextLine();
            if (! newWord.equals("") && !translateIt(dict, newWord.toLowerCase()))
                System.out.println("Такого слова в словаре нет!");
        }
        while (! newWord.equals(""));
    }

    private static boolean translateIt(HashMap<String, String> dict, String wordTransl) {
        boolean res = false;
        Set<String> keys = dict.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            it.next();
            if (dict.containsKey(wordTransl)) {
                System.out.println(dict.get(wordTransl));
                res = true;
                break;
            }
        }
        return res;
    }
}
