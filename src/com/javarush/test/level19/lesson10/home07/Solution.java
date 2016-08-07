package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = reader.readLine()) != null){ list.add(s); }
        reader.close();
        ArrayList<String> words  = new ArrayList<>();

        for (int i = 0; i < list.size() ; i++) {
            String[] splitted = list.get(i).split(" ");
            for (int j = 0; j < splitted.length ; j++) {
                String word = splitted[j];
                if (word.length() > 6) words.add(word);
            }
        }

        writter.write(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            writter.write("," + words.get(i));
        }
        writter.close();

    }
}
