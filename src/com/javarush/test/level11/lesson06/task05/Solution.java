package com.javarush.test.level11.lesson06.task05;

/* ИТ-компания
Написать девять классов: Worker(сотрудник),
Clerk (клерк),
IT (ИТ-специалист),
Programmer(программист),
ProjectManager(менеджер проекта),
CTO(технический директор),
HR(рекрутер),
OfficeManager(офис-менеджер),
Cleaner (уборщик).

Унаследовать программиста, менеджера проекта и технического директора от ИТ-специалиста.
Унаследовать рекрутера, уборщика и офис-менеджера от клерка.
Унаследовать клерка и ИТ-специалиста от сотрудника.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Worker
    {
        int salary;
        boolean sex;
    }

    public class Clerk extends Worker
    {
        int pens;
    }

    public class IT extends Worker
    {
        int skill;
    }

    public class Programmer extends IT
    {
        boolean haveAComputer;
    }

    public class ProjectManager extends IT
    {
        int workinghours;
    }

    public class CTO extends IT
    {
        boolean cool;
    }

    public class OfficeManager extends Clerk
    {
        int papers;
    }

    public class HR extends Clerk
    {
        int peoples;
    }

    public class Cleaner extends Clerk
    {
        int water;
    }
}
