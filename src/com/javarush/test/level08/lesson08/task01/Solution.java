package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("Люда");
        set.add("Лена");
        set.add("Любовь");
        set.add("Лысый");
        set.add("Лень");
        set.add("Лазурь");
        set.add("Ласково");
        set.add("Ламборджини");
        set.add("Ленится");
        set.add("Льстить");
        set.add("Луна");
        set.add("Луноход");
        set.add("Лизать");
        set.add("Лыжа");
        set.add("Ли");
        set.add("Любой");
        set.add("Люди");
        set.add("Легко");
        set.add("Лет");
        set.add("Лучше");
        return set;
    }
}
