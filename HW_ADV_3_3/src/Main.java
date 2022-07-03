/**
 * Домашнее задание 3
 * Задание 3
 * Необходимо создать строку с текстом (текст взять любой из интернета).
 * Разбить эту строку на 2 подстроки равной длине и вывести на экран каждое предложения с новой строки.
 */

public class Main {
    public static void main(String[] args) {
        String str = "Выберите дату, чтобы купить билет на автобус Одесса — Бремен";
        String str1 = str.substring(0, str.length() / 2).trim();
        String str2 = str.substring(str.length() / 2).trim();
        System.out.println("Строка оригинал: " + str);
        System.out.println("Полученные подстроки: ");
        System.out.println("1. " + str1);
        System.out.println("2. " + str2);
    }
}
