package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Диденко", "Женя");
        map.put("Лысенко", "Вова");
        map.put("Шапинская", "Аня");
        map.put("Дунская", "Людмила");
        map.put("Челомбитько", "Вова");
        map.put("Лобунец", "Денис");
        map.put("Дударенко", "Женя");
        map.put("Езловецкий", "Женя");
        map.put("Антоненко", "Ирина");
        map.put("Вялько", "Женя");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int a = 0;
        for (Map.Entry<String, String> x : map.entrySet()){
            if (name.equals(x.getValue())) a++;
        }
        return a;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int b = 0;
        for (Map.Entry<String, String> x : map.entrySet()){
            if (familiya.equals(x.getKey())) b++;
        }
        return b;

    }
}
