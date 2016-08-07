package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        Map<Integer, Integer> map = new HashMap<>();



        FileInputStream is = new FileInputStream(file);
        int[] arr = new int[is.available()];
        int i = 0;
        while (is.available() > 0){
            arr[i] = (byte) is.read();
            i++;
        }
        is.close();

        int someValue = 0;
        for(int b : arr){
            if (!(map.containsKey(b))){
                map.put(b, 0);
            }else{
                int x = map.get(b) + 1;
                map.remove(b);
                map.put(b, x);
                someValue = x;
            }
        }


        for (Map.Entry<Integer, Integer> pair : map.entrySet()){

            if (pair.getValue() < someValue) someValue = pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == someValue) System.out.println(pair.getKey());
        }
    }
}
