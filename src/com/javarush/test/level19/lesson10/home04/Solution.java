package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{

        BufferedReader strreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(strreader.readLine())));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = reader.readLine()) != null){  list.add(s);  }
        reader.close();
        strreader.close();

        for (int i = 0; i < list.size(); i++) {
            String[] splitted = list.get(i).split(" ");
            int count = 0;
            for (int j = 0; j < splitted.length; j++) {
                String s2 = splitted[j];
                for (int k = 0; k < words.size(); k++) {
                    if (s2.equals(words.get(k))) count ++;
                }
            }
            if (count == 2) System.out.println(list.get(i));
        }
    }
}
