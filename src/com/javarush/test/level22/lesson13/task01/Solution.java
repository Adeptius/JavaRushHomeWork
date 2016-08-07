package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> result = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(query, delimiter);
        while (token.hasMoreTokens()){
            result.add(token.nextToken());
        }
        return result.toArray(new String[0]);
    }
}
