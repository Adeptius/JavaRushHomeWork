package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* ������ �������������
������ � ���������� ��� ����� m � n.
��������� ���� for ������� �� ����� ������������� �������� m �� n �� ��������.
������: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        int m = Integer.parseInt(s1);
        int n = Integer.parseInt(s2);
        for (int i = 0; i < m; i++) {

            for (int a = 0; a < n; a++) {
                System.out.print("8");

            }
            System.out.println();

        }

    }
}
