package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;

import java.util.Date;


/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

@SuppressWarnings("deprecation")
public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println(isDateOdd("JANUARY 3 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        Date checkDate = new Date(Date.parse(date));
        checkDate.setYear(2000);

        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);
        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);
        yearStartTime.setYear(2000);
        yearStartTime.setYear(0);

        System.out.println(checkDate);
        System.out.println(yearStartTime);

        long msTimeDistance = checkDate.getTime() - yearStartTime.getTime();

        System.out.println(checkDate.getTime());
        System.out.println(yearStartTime.getTime());



        long msDay = 24 * 60 * 60 * 1000;




        int dayCount = (int) (msTimeDistance / msDay);


        if (dayCount == 0) return true;
        else
            return false;

    }
}