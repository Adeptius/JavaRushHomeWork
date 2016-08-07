package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = reader.readLine()) != null){  list.add(s);  }
        reader.close();

        for (int i = 0; i < list.size() ; i++) {
            s = list.get(i);
            String name = null;
            int firstDigitPosition = 0;
            int day = 0;
            int month = 0;
            int year = 0;
            for (int j = 0; j <s.length() ; j++) {
                char c = s.charAt(j);
                if (Character.isDigit(c)){
                    firstDigitPosition = j;
                    break;
                }
            }

            name = s.substring(0, firstDigitPosition-1);
            s = s.substring(firstDigitPosition);
            String[] dateString = s.split(" ");
            day = Integer.parseInt(dateString[0]);
            month = Integer.parseInt(dateString[1]);
            year = Integer.parseInt(dateString[2]);

            Date date = new Date(year-1900,month-1,day);
            PEOPLE.add(new Person(name, date));

        }
    }
}