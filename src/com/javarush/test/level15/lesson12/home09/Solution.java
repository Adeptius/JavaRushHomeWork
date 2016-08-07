package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        String afterQ = URL.substring(URL.indexOf("?") + 1);
        String[] splitted = afterQ.split("&");

        ArrayList<String> str = new ArrayList<>();
        ArrayList<Double> dou = new ArrayList<>();
        for (String s : splitted){
            if (s.contains("=")){
                System.out.print(s.substring(0, s.indexOf("=")) + " ");
                if (s.substring(0,4).equals("obj=")){
                    try { dou.add(Double.parseDouble(s.substring(s.indexOf("=") + 1)));
                    }catch (Exception e) {
                        if (!(s.substring(s.indexOf("=") + 1).isEmpty())) str.add(s.substring(s.indexOf("=") + 1));
                    }
                }
            }else System.out.print(s + " ");
        }
        System.out.println();
        for (double x : dou){
            alert(x);
        }
        for (String x : str){
            alert(x);
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
