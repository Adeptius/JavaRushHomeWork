package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.*;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = new HashSet<>();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strs = new HashSet<>();
        for (Long key : keys) {
            strs.add(shortener.getString(key));
        }
        return strs;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strs = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            strs.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        long timeBefore = new Date().getTime();
        Set<Long> keys = getIds(shortener,strs);
        long timeAfter = new Date().getTime();
        Helper.printMessage("" + (timeAfter-timeBefore));


        timeBefore = new Date().getTime();
        Set<String> resultStrings = getStrings(shortener, keys);
        timeAfter = new Date().getTime();
        Helper.printMessage("" + (timeAfter-timeBefore));

        if (strs.equals(resultStrings)){
            Helper.printMessage("Тест пройден.");
        }
        else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        Solution.testStrategy(new HashMapStorageStrategy(), 10000);
        Solution.testStrategy(new OurHashMapStorageStrategy(), 10000);
        Solution.testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        Solution.testStrategy(new HashBiMapStorageStrategy(), 10000);
        Solution.testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }
}
