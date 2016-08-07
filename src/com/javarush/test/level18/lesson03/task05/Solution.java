package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        Map<Integer, Integer> map = new HashMap<>();



        FileInputStream is = new FileInputStream(file);
        ArrayList<Integer> arr = new ArrayList<>();

        while (is.available() > 0){
            int i = is.read();
            if (!(arr.contains((i)))){ arr.add(i); }

        }
        is.close();

        Collections.sort(arr);

        for (Integer s : arr){
            System.out.println(s + " ");
        }
    }
}
