package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        br.close();

        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = fr.readLine()) != null){
            list.add(s);
        }
        fr.close();

        int words = 0;
        for (int i = 0; i < list.size(); i++) {
            String d = list.get(i);
            String[] wor = d.split("[., !?;:-]");
            for (int j = 0; j < wor.length; j++) {
                if (wor[j].equals("world")) words++;
            }
        }
        System.out.println(words);
    }
}
