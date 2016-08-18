package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    @SuppressWarnings("deprecation")
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("FEBRUARY 1 1980"));
        map.put("Tommy", new Date("JUNE 1 1980"));
        map.put("Jonson", new Date("NOVEMBER 1 1980"));
        map.put("Mike", new Date("JUNE 1 1980"));
        map.put("Tom", new Date("JULY 1 1980"));
        map.put("Bred", new Date("AUGUST 1 1980"));
        map.put("Arnold", new Date("SEPTEMBER 1 1980"));
        map.put("Cruise", new Date("DECEMBER 1 1980"));
        map.put("Bill", new Date("APRIL 1 1980"));
        map.put("James", new Date("JANUARY 1 1980"));
        return map;
    }

    @SuppressWarnings("deprecation")
    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> temp = map.entrySet().iterator();
        while (temp.hasNext()) {
            Date d = temp.next().getValue();
            if (d.getMonth() > 4 && d.getMonth() < 8)
                temp.remove();
        }



    }
}
