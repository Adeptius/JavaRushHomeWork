package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* ������� � ��������� �����
�������� ���������, ������� ������ � ���������� ������ ������.
��������� ������ ������� �� ����� ��� ������:
1. ������ ������ �������� ������ ������� �����
2. ������ - ������ ��������� ����� � ����� ���������� �� �������� ������.
����� ��������� ��������, ������ ������ ������ ������������� ��������.

������ �����:
���� ���� ����.
������ ������:
� � � � � �
� � � � � � .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();                 // ������ ������ S
        char[] all = new char[s.length()];            // ������ ������ ���, � ������� �������� ������
        ArrayList<String> glas = new ArrayList<>();   // ������ ����� ��� �������
        ArrayList<String> soglas = new ArrayList<>(); // ������ ����� ��� ���������

        for (int i = 0; i < s.length(); i++) {
            all[i] = s.charAt(i);  // � ���� ����� �������� �� �� ������ s � ��� ������
        }

        String temp = " ";            // ������ ������ � ��������
        char probel = temp.charAt(0); //� ������� ������ � ��� ����������

        // ��� �� � ���������� �� ���� ������� �������� (� �  � �  � � .) - ����� �� �������.

        for (int i = 0; i < all.length; i++)  { //�������� ������� ������� ���� � ��������������� ������
            if (all[i] != probel){                                      // ���� �� ������ - ������������ �� �������
                if (isVowel(all[i])) glas.add(String.valueOf(all[i])); //���� ������� - � �������
                else               soglas.add(String.valueOf(all[i])); //���� ��������� - � ���������
            }
        }
        for (String a : glas){
            System.out.print(a + " "); //������� �� ����� ��������
        }

        System.out.println();

        for (String a : soglas){
            System.out.print(a + " "); //������� �� ����� ����������
        }

    }


    public static char[] vowels = new char[]{'�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};

    //����� ���������, ������� �� �����
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //�������� ������ � ������ ������� - �� ��������� � �������� ������

        for (char d : vowels)          //���� ����� ������� �������
        {
            if (c == d)
                return true;
        }
        return false;
    }
}

