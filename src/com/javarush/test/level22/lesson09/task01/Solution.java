package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
            sb.append("\n");
        }
        fileReader.close();

        String[] splitted = sb.toString().split("[ \n\r]");
        StringBuilder s;
        ArrayList<String> was = new ArrayList<>();

        for (int i = 0; i < splitted.length; i++) {
            for (int j = i; j < splitted.length; j++) {
                s = new StringBuilder(splitted[j]);
                if (i != j && !was.contains(splitted[i])) {
                    if (splitted[i].equals(s.reverse().toString())){
                        Pair pair = new Pair();
                        pair.first = splitted[i];
                        pair.second = s.reverse().toString();
                        result.add(pair);
                        was.add(splitted[i]);
                    }
                }
            }
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
