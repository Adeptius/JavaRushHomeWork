package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <T> Map convert(List<? extends Convertable<T>> list) {
        Map<T, ? super Convertable> result = new HashMap<>();

        for (Convertable<T> c : list) {
            result.put(c.getKey(), c);
        }

        return result;
    }
}
