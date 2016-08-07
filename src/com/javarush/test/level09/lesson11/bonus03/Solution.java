package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        // разделяем общий массив на 2 (отдельно цифры, отдельно буквы)
        String[] bukva = new String[array.length];
        int[] cifra = new int[array.length];
        ArrayList<Integer> smallint = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])) {
                cifra[i] = Integer.parseInt(array[i]);
                smallint.add(Integer.parseInt(array[i]));
            }
                else bukva[i] = array[i];
        }

        // Сортируем буквы
        ArrayList<String> buk = new ArrayList<>();
        for (int i = 0; i < bukva.length; i++) {
            if (bukva[i] != null)
            buk.add(bukva[i]);
        }
        Collections.sort(buk);

        // Переносим буквы обратно в те позиции откуда взяли
        int b = 0;
        for (int i = 0; i < bukva.length; i++) {
            if (bukva[i] != null) {
                bukva[i] = buk.get(b);
                b++;
            }
        }

        //Сортируем цифры
        Collections.sort(smallint);


        // Теперь обратная сортировка
        int k = smallint.size() -1;

        ArrayList<Integer> cyfriFinish = new ArrayList<Integer>();
        for (int i = k; i >= 0; i--) {
            cyfriFinish.add(smallint.get(i));
        }




        //Теперь переносим и цифры туда, где уже лежат буквы
        int h=0;
        for (int i = 0; i < bukva.length; i++) {
            if (bukva[i] == null) {
                bukva[i] = String.valueOf(cyfriFinish.get(h));
                h++;
            }
        }

        // перекидываем всё обратно в аррэй, который был в самом начале
        for (int i = 0; i < array.length; i++) {
            array[i] = bukva[i];
        }


    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
