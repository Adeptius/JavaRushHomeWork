package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        FileWriter fw = new FileWriter(br.readLine(), true);
        br.close();

        ArrayList<String> list = new ArrayList<>();
        String s;

        while ((s = fr.readLine()) != null){
            list.add(s);
        }
        fr.close();

        String[] wor = null;
        for (int i = 0; i < list.size(); i++) {
            String d = list.get(i);
            wor = d.split(" ");
        }
        for (int j = 0; j < wor.length; j++) {
            String a = wor[j];
            boolean numbersOnly = true;

            for (int k = 0; k < a.length(); k++) {
                if (!(a.charAt(k) == '0' ||
                        a.charAt(k) == '1' ||
                        a.charAt(k) == '2' ||
                        a.charAt(k) == '3' ||
                        a.charAt(k) == '4' ||
                        a.charAt(k) == '5' ||
                        a.charAt(k) == '6' ||
                        a.charAt(k) == '7' ||
                        a.charAt(k) == '8' ||
                        a.charAt(k) == '9'
                )) numbersOnly = false;

                if (numbersOnly) fw.write(a.charAt(k));
            }
            if (numbersOnly) fw.write(' ');

        }
        fw.close();
    }


}
