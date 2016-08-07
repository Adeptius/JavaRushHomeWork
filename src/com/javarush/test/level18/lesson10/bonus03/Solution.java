package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/



import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static ArrayList<String> lines = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = null;
        while ((line = fileReader.readLine()) != null){  lines.add(line);  }
        fileReader.close();

        if (args[0].equals("-u")){
            for (int i = 0; i < lines.size(); i++) {
                if (getId(lines.get(i).substring(0,8)).equals(args[1])){
                    lines.set(i, getFullId(args[1]) + getProductName(args[2]) + getPrice(args[3]) + getQuantity(args[4]));
                }
            }
        }
        if (args[0].equals("-d")) {
            for (int i = 0; i < lines.size(); i++) {
                if (getId(lines.get(i).substring(0,8)).equals(args[1])){
                    lines.remove(i);
                }
            }
        }
        BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (int i = 0; i < lines.size(); i++) {
            writter.write(lines.get(i));
            writter.newLine();
        }
        writter.close();


    }

    public static String getProductName(String original){
        while (original.length() < 30) {
            original += " ";
        }
        return original;
    }

    public static String getPrice(String original){
        while (original.length() < 8) {
            original += " ";
        }
        return original;
    }

    public static String getQuantity(String original){
        while (original.length() < 4) {
            original += " ";
        }
        return original;
    }


    public static String getFullId(String original){
        while (original.length() < 8) {
            original += " ";
        }
        return original;
    }

    public static String getId(String original){
        if (original.contains(" ")) original = original.substring(0, original.indexOf(" "));
        return original;
    }
}