package itea.lsn7.DZ_task11_URL;

import java.util.Scanner;

/** Написать метод разбора списка параметров в формате URL: para1=value1&param2=value2&param3=value3.
 *  В случае ошибки в формате бросать исключение.
 */
public class Main {

    public static class KeyException extends Exception {
        public KeyException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "KeyException: " + super.getMessage();
        }
    }

    public static class UrlException extends Exception {
        public UrlException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "URL_Exception: " + super.getMessage();
        }
    }

    static boolean checkURL(String s) { //проверяем URL
        if (s.indexOf("=") < s.indexOf("&") && s.charAt(0) != '=') {
            System.out.println("URL принята.");
            return true;
        }
        else {
            System.out.println("URL некорректная.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url, str;
        //URL: "para1=value1&param2=value2&param3=value3&param4=value4&param5=value5&param6=value6";
        //чтоб не набирать с консоли )))
        do {
            do {
                System.out.print("Введите URL: ");
                url = sc.nextLine();
            }
            while (!checkURL(url));
            int count = 0;
            for (int i = 0; i < url.length(); i++)
                if (url.charAt(i) == '=')
                    count++;
            String[] params = new String[count];
            String[] values = new String[count];
            str = "";
            count = 0;
            try {
                for (int i = 0; i < url.length(); i++) { //разбираем URL
                    if (url.charAt(i) == '=') {
                        if (!str.equals("")) {
                            params[count] = str;
                            str = "";
                        }
                        else
                            throw new UrlException("ошибка при вводе параметров в строку URL");
                    }
                    else
                    if (url.charAt(i) == '&') {
                        if (!str.equals("")) {
                            values[count++] = str;
                            str = "";
                        }
                        else
                            throw new UrlException("ошибка при вводе ключей в строку URL");
                    }
                    else {
                        str += url.charAt(i);
                        if (i == url.length() - 1)
                            values[count++] = str;
                    }
                }
            } catch (Exception e) {
                str = "";
                System.out.println(e.getMessage());
            }
            if (!str.equals("")) {
                do {   //всё нормально, работаем с URL
                    System.out.println("Чтоб закончить работу - введите 0 (ноль).");
                    System.out.print("Чтоб продолжить - введите искомый параметр в формате AB (A - ключ k или v, B - его номер): ");
                    str = sc.nextLine();
                    if (!str.equals("0")) {
                        try {
                            if (str.charAt(0) == 'k') {
                                int task = Integer.parseInt(str.substring(1));
                                if (task > 0 && task <= params.length)
                                    System.out.println("Название искомого параметра: " + params[task - 1]);
                                else
                                    throw new KeyException("неправильный ввод порядкового номера");
                            }
                            else
                            if (str.charAt(0) == 'v') {
                                int task = Integer.parseInt(str.substring(1));
                                if (task > 0 && task <= values.length)
                                    System.out.println("Название искомого значения: " + values[task - 1]);
                                else
                                    throw new KeyException("неправильный ввод порядкового номера");

                            }
                            else
                                throw new KeyException("неправильный ввод ключа/параметра");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("До свидания.");
                } while (!str.equals("0"));
            }
        }
        while (!str.equals("0"));
   }
}