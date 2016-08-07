package com.javarush.test.level11.lesson06.task04;

/* Все мы работники
Написать четыре класса: Employee(сотрудник), Manager(управляющий), Chief(директор) и  Secretary(секретарь).
Унаследовать управляющего, директора и секретаря от сотрудника.
*/

public class Solution
{
    public class Manager extends Employee
    {
        String charisma;

    }

    public class Chief extends Employee
    {
        boolean orator;

    }

    public class Employee
    {
        int Salary;
        boolean sex;

    }

    public class Secretary extends Employee
    {
        boolean sexy;

    }
}
