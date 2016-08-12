package com.javarush.test.level04.lesson06.task03;

/* —ортировка трех чисел
¬вести с клавиатуры три числа, и вывести их в пор€дке убывани€.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int high = 0;
        int mid = 0;
        int low = 0;

        if (a>b && a>c)
        {
            high = a;
            if (b>c)
            {
                mid = b;
                low = c;
            }
            else
            {
                mid = c;
                low = b;
            }
        }
        if (b>a && b>c)
        {
            high = b;
            if (a>c)
            {
                mid = a;
                low = c;
            }
            else
            {
                mid = c;
                low = a;
            }
        }
        if (c>b && c>a)
        {
            high = c;
            if (b>a)
            {
                mid = b;
                low = a;
            }
            else
            {
                mid = a;
                low = b;
            }
        }
        System.out.println(high);
        System.out.println(mid);
        System.out.println(low);



    }
}
