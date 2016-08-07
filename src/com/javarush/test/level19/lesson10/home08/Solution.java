package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader strreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(strreader.readLine())));
        ArrayList<String> list = new ArrayList<>();
        String s;  while((s = reader.readLine()) != null){  list.add(s);  }
        reader.close();
        strreader.close();

        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            String newLine = "";
            for (int j = line.length()-1; j >= 0 ; j--) {
                newLine += line.charAt(j);
            }
            System.out.println(newLine);
        }
    }
}
