package com.javarush.test.level04.lesson06.task01;

/* ������� ���� �����
������ � ���������� ��� �����, � ������� �� ����� ����������� �� ���.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int a = Integer.parseInt(s);

        String s2 = reader.readLine();
        int b = Integer.parseInt(s2);

        if (a < b)
            System.out.println(a);
        else
            System.out.println(b);

    }
}
