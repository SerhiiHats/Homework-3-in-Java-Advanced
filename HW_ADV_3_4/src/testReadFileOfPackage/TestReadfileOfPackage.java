package testReadFileOfPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Домашнее задание 3
 * Задание 4
 * Создайте в package текстовый файл и клас, внесите в файл некий текст.
 * Выведите на экран содержимое файла.
 */

public class TestReadfileOfPackage {
    public static void main(String[] args) {
        File fileAvto = new File("src/testReadFileOfPackage/avto");             // клик правой клавишей на файле + Copy Path + Path From Content Root (выбрали- скопировали) - вставили в путь в конструкторе к File
        try (Scanner scanFileAvto = new Scanner(fileAvto)) {
            System.out.println("Файл был удачно прочитан!");
            System.out.println(scanFileAvto.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден (при чтении), рекомендуем проверить: \n1. наличее файла, 2. места его расположения, 3. правильности пути к нему");
        }

    }
}
