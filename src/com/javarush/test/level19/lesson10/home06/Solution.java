package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException{
        // Решение не моё
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(reader1.readLine())));
        reader1.close();
        String data = "";
        String textResult = "";

        while(reader.ready()){
            data += reader.readLine();
        }

      reader.close();

        while (true){
            String[] dataParts = data.split("[\\p{Punct}\\p{Space}]", 2);

            if (!dataParts[0].equals("")&& dataParts.length > 1){
                data = data.split(dataParts[0], 2)[1];
            }

            boolean changed = false;

            for (Map.Entry<Integer, String> pair : map.entrySet()){
                if (dataParts[0].equals(pair.getKey() + "")){
                    textResult += pair.getValue();
                    if (dataParts.length > 1)
                        textResult += data.charAt(0);
                    changed = true;
                }
            }

            if (!changed){
                textResult += dataParts[0];
                if (dataParts.length > 1)
                    textResult += data.charAt(0);
            }

            if (dataParts.length < 2)
                break;

            data = dataParts[1];
        }
        System.out.println(textResult);
    }
    /*
    А это решение моё:

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(reader1.readLine())));
        reader1.close();
        ArrayList<String> list = new ArrayList<>();
        String s;  while ((s = reader.readLine()) != null){ list.add(s); }
        reader.close();
        for (int i = 0; i < list.size() ; i++) {
            for (int j = 0; j < 13; j++) {
                String from = " " + j + " ";
                String to = " " + map.get(j) + " ";
                String s1 = list.get(i);
                s1 = s1.replaceAll(from, to);
                list.set(i, s1);
            }
        }
        for (String x : list) System.out.println(x);
     */
}