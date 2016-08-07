package com.javarush.test.level04.lesson06.task03;

/* —ортировка трех чисел
¬вести с клавиатуры три числа, и вывести их в пор€дке убывани€.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Solution2
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int max = 0, med = 0, min = 0;

        if (a > b && a > c) max = a;
        if (a > b && a < c) med = a;
        if (a < b && a > c) med = a;
        if (a < b && a < c) min = a;

        if (b > a && b > c) max = b;
        if (b > a && b < c) med = b;
        if (b < a && b > c) med = b;
        if (b < a && b < c) min = b;

        if (c > a && c > b) max = c;
        if (c > a && c < b) med = c;
        if (c < a && c > b) med = c;
        if (c < a && c < b) min = c;

        System.out.println(max);
        System.out.println(med);
        System.out.println(min);



    }
}
