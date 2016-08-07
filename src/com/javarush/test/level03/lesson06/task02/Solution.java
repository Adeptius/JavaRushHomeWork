package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        int c = 10; // требуемое количество рядов
        int d = 11; // требуемое количество строк, но плюс 1 (LOL)
        int b = 1; // сюда будут накапливатся циклы рядов
        int f = 1; // сюда будут накапливатся циклы строк
        int a = 1; // Стартовое число

        do {
            int m = a;
            System.out.print(a + " "); // Это нужно, что бы к первому числу не добавлялась еденица
            do {
                a = a + m;
                System.out.print(a + " ");
                b = b + 1;
            } while (b < c);
            System.out.println(" ");
            b = 1; // сбиваем счётчик циклов
            f = f+1;
            a = m + 1;
        } while (f < d);



    }
}