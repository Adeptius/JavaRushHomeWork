package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* ���� � ����������� ������� �/��� ���������
1. ������� ������� Map (<String, String>) � �������� ���� 10 ������� � ���� ���������-�����.
2. ����� ����� ���� 10 ������� ���� ���� � ����������� �������.
3. ����� ����� ���� 10 ������� ���� ���� � ����������� ���������.
4. ������� ���������� Map �� �����.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("�������", "����");
        map.put("�������", "����");
        map.put("���������", "���");
        map.put("�������", "�������");
        map.put("�����������", "����");
        map.put("�������", "�����");
        map.put("���������", "����");
        map.put("����������", "����");
        map.put("�������", "�����");
        map.put("������", "����");

        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
