package com.javarush.test.level04.lesson02.task02;

/* ����������� ����� addNewCat
����������� ����� addNewCat, ����� ��� ��� ������ (�.�. ���������� ������ ����), ���������� ����� ������������� �� 1. �� ���������� ����� �������� ���������� catsCount.
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        Cat cat = new Cat();
        catsCount = catsCount + 1;
    }
}
