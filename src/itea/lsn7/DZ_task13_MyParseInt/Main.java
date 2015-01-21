package itea.lsn7.DZ_task13_MyParseInt;

import java.util.Scanner;

/**
 * Написать аналог Integer.parseInt. Использовать исключения.
 */
public class Main {

    public static class DigitException extends Exception {
        public DigitException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "Digit Exception: " + super.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.print("Для завершения работы - введите ноль; для конвертации - введите число: ");
            str = sc.nextLine();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                try {
                    if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                        flag = false;
                        throw new DigitException("встречаются символы, преобразовать в число нельзя!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            int rez = 0;
            if (flag) {
                int pointer = 1;
                for (int i = 1; i < str.length(); i++) {
                    pointer *= 10;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != '0')
                        rez += selectDigit(str.charAt(i)) * pointer;
                    pointer /= 10;
                }
                System.out.println("Преобразованное число: " + rez);
            }
        } while (!str.equals("0"));
    }

    public static int selectDigit(char ch) {
        int rez = -1;
        switch (ch) {
            case '0':
                rez = 0;
                break;
            case '1':
                rez = 1;
                break;
            case '2':
                rez = 2;
                break;
            case '3':
                rez = 3;
                break;
            case '4':
                rez = 4;
                break;
            case '5':
                rez = 5;
                break;
            case '6':
                rez = 6;
                break;
            case '7':
                rez = 7;
                break;
            case '8':
                rez = 8;
                break;
            case '9':
                rez = 9;
                break;
            default:
                break;
        }
        return rez;
    }
}