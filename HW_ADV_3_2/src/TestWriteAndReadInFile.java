import color.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Домашнее задание 3
 * Задание 2
 * Создайте файл, запишите в него произвольные данные и закройте файл.
 * Затем снова откройте этот файл, прочитайте из него данные и выведете их на консоль.
 */

public class TestWriteAndReadInFile {
    public static void main(String[] args) {
        File file = new File("testFile");                    // еслы вы ошибетесь в пути при записи - файл все равно будет создан по указаному имени в конструкторе
        try (PrintWriter pwFile = new PrintWriter(file)) {            //конструкции try-with-resources после использования закроет ресурс (поток записи)
            pwFile.print("Audi" + " ");
            pwFile.print("Q8" + " ");
            pwFile.print("white" + " ");
            pwFile.print(2019 + " ");
            pwFile.print(45150 + " ");
            pwFile.println(65500 + " ");
            pwFile.print("Audi" + " ");
            pwFile.print("Q8-Sline" + " ");
            pwFile.print("black" + " ");
            pwFile.print(2020 + " ");
            pwFile.print(27150 + " ");
            pwFile.println(74999 + " ");
            pwFile.println("Mercedes-Benz" + " " + "GLE-350" + " " + "grey" + " " + 2019 + " " + 45000 + " " + 85000);
            System.out.println("Файл был записан удачно !");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден (при записи), рекомендуем проверить: \n наличее файла, места его расположения и правильности пути к нему");
        }

        try (Scanner scanner = new Scanner(file)) {     //конструкции try-with-resources после использования закроет ресурс (поток чтения)
            String strFile = scanner.nextLine();
            System.out.println("Файл был прочитан удачно !");
            System.out.println(Color.GREEN + "Выведем первую строчку файла" + Color.DEFAULT);
//            System.out.println(strFile);               // простой вывод файла в виде прочитаной его строки и переданой в String
            toStringFile(strFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден (при чтении), рекомендуем проверить: \n наличее файла, места его расположения и правильности пути к нему");
        }

        System.out.println(Color.GREEN + "Выводим все данные файла, читаем и выводим построчно в цикле с условием (пока есть следующая строка)" + Color.DEFAULT);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String strFile = scanner.nextLine();
//                System.out.println(strFile);           // простой вывод файла в виде прочитаной его строки и переданой в String
                toStringFile(strFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден (при чтении), рекомендуем проверить: \n наличее файла, места его расположения и правильности пути к нему");
        }
    }

    private static void toStringFile(String strFile) {
        String[] data = strFile.split(" ");            // если структура файла нам заранее известна, применив split и передав данные в массив данных - мы сможем потом поработать с каждой ячейкой данных по отдельности применяя различные операции
        String sp1 = bildSpace(15 - data[0].length());
        String sp2 = bildSpace(12 - data[1].length());
        String sp3 = bildSpace(8 - data[2].length());
        String sp4 = bildSpace(5 - data[3].length());
        String sp5 = bildSpace(7 - data[4].length());
        String sp6 = bildSpace(7 - data[5].length());
        System.out.println("Марка автомобиля: " + data[0] + sp1 + ", модель: " + data[1] + sp2 + ", цвет: "
                + data[2] + sp3 + ", год выпуска: " + data[3] + sp4 + ", пробег, км : " + data[4] + sp5 + ", цена: " + data[5] + sp6);
    }

    public static String bildSpace(int leghtString) {
//        StringBuilder strBld = new StringBuilder();
//        for (int i = 0; i < leghtString; i++) {
//            strBld.append(" ");
//        }
//        return strBld.toString();
        return " ".repeat(Math.max(0, leghtString));
    }
}
