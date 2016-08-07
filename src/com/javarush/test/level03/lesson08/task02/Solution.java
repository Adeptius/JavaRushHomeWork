package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream vvod = System.in;
        Reader inputStreamReader = new InputStreamReader(vvod);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Имя");
        String name = bufferedReader.readLine(); //читаем имя
        System.out.println("Зарплата");
        String salary = bufferedReader.readLine(); //читаем зарплату
        System.out.println("Через сколько лет");
        String years = bufferedReader.readLine(); //читаем лет
        System.out.println(name + " будет получать " + salary + " через " + years + " лет.");




    }
}