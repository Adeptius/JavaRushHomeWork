package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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

        String productName = args[1];
        float price = Float.parseFloat(args[2]);
        int quantity = Integer.parseInt(args[3]);

        String newLine = getNewId() + getProductName(args[1]) + getPrice(args[2]) + getQuantity(args[3]);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
        //Странно, но c переводом новой строки не принимало. writer.newLine();
        writer.write(newLine);
        writer.close();
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


    public static int getNewId(){
        String ids = null;
        int currentId = 0;
        int maxId = 0;
        for (int i = 0; i < lines.size(); i++) {
            ids = lines.get(i).substring(0,8);
            if (ids.contains(" ")) ids = ids.substring(0,ids.indexOf(" "));
            currentId = Integer.parseInt(ids);
            if (currentId > maxId) maxId = currentId;
        }
        return ++maxId;
    }
}