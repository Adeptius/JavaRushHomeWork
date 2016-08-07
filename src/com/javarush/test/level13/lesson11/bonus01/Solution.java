package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> numbers = new ArrayList<>();

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
         int a = scanner.nextInt();
            if (a%2 == 0) numbers.add(a);
        }

        Collections.sort(numbers);

        for (Integer x: numbers){

            System.out.println(x);
        }

        reader.close();
    }
}
