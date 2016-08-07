package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.5, "a");
        labels.put(2.5, "b");
        labels.put(3.5, "c");
        labels.put(4.5, "d");
        labels.put(5.5, "e");
    }

    public static void main(String[] args) {


        System.out.println(labels);
    }
}
