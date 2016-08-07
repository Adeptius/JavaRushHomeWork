package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
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
                for (int k = 0; k < word.length(); k++) {
                    if (Character.isDigit(word.charAt(k))){
                        words.add(word);
                        break;
                    }
                }
            }
        }

        for (String x : words) writter.write(x + " ");
        writter.close();
    }
}
