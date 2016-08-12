package com.javarush.test.level04.lesson13.task03;

import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int m = 1;
        for (int i = 0; i < 11; i++) {

            for (int j = 1; j < m; j++) {
                System.out.print(8);

            }
            m = m + 1;
            System.out.println();
        }

    }
}
