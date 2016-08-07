package com.javarush.test.level03.lesson08.task05;

/* Чистая любовь
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!
Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream potok = System.in;
        Reader isr = new InputStreamReader(potok);
        BufferedReader buf = new BufferedReader(isr);

        String name1 = buf.readLine();
        String name2 = buf.readLine();
        String name3 = buf.readLine();
        System.out.print(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");

    }
}