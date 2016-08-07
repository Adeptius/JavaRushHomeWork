package com.javarush.test.level03.lesson08.task04;

/* Спонсор - это звучит гордо
Ввести с клавиатуры два имени и вывести надпись:
name1 проспонсировал name2, и она стала известной певицей.
Пример:
Коля проспонсировал Лену, и она стала известной певицей.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream InputStream = System.in;
        Reader InputStreamReader = new InputStreamReader(InputStream);
        BufferedReader bufferedReader = new BufferedReader(InputStreamReader);

        String name1 = bufferedReader.readLine();
        String name2 = bufferedReader.readLine();
        System.out.println(name1 + " проспонсировал " + name2 + ", и она стала известной певицей.");

    }
}