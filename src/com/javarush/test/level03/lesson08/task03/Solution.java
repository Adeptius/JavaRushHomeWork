package com.javarush.test.level03.lesson08.task03;

/* Скромность украшает человека
Ввести с клавиатуры имя и вывести надпись:
name зарабатывает $5,000. Ха-ха-ха!
Пример: Тимур зарабатывает $5,000. Ха-ха-ха!
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream vvod = System.in;
        Reader inputStreamReader = new InputStreamReader(vvod);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //System.out.println("Имя");
        String name = bufferedReader.readLine(); //читаем имя

        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");


    }
}