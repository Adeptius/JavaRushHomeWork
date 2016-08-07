package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception   {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Через сколько лет");
        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        System.out.println("Имя завоевателя");
        String name = bufferedReader.readLine(); //читаем строку с клавиатуры

        int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.
        System.out.println(name + " захватит мир через " + sAge + " лет. Му-ха-ха!");

    }
}