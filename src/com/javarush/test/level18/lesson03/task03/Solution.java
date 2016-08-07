package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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

        for(int b : arr){
            if (!(map.containsKey(b))){
                map.put(b, 0);
            }else{
                int x = map.get(b) + 1;
                map.remove(b);
                map.put(b, x);
            }
        }

        int k = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() > k) k = pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == k) System.out.println(pair.getKey());
        }







    }
}
