package com.javarush.test.level03.lesson12.home03;

/* Я буду зарабатывать $50 в час
Ввести с клавиатуры число n.
Вывести на экран надпись «Я буду зарабатывать $n в час».
Пример:
Я буду зарабатывать $50 в час
*/
import java.io.*;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        InputStream potok = System.in;
        Reader isr = new InputStreamReader(potok);
        BufferedReader buf = new BufferedReader(isr);

        String b = buf.readLine();
        System.out.print("Я буду зарабатывать $" + b + " в час");
    }
}