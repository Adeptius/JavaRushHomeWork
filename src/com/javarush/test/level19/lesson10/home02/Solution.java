package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        ArrayList<String> list = new ArrayList<>();
        String s;
        while ((s = reader.readLine()) != null){
            list.add(s);
        }
        reader.close();

        Map<String,Double> map = new HashMap<>();

        for (int i = 0; i < list.size() ; i++) {
            String name = list.get(i).substring(0, list.get(i).indexOf(" "));
            double salary = Double.parseDouble(list.get(i).substring(list.get(i).indexOf(" ") + 1));
            if (map.containsKey(name)){
                double oldSalary = map.get(name);
                double newSalary = oldSalary + salary;
                map.remove(name);
                map.put(name, newSalary);
            }else   map.put(name, salary);
        }

        double maxValue = 0;
        SortedSet<String> keys = new TreeSet<String>(map.keySet());
        for (String key : keys) {
            double value = map.get(key);
            if (value > maxValue) maxValue = value;
        }

        for (Map.Entry<String, Double> pair : map.entrySet() ) {
            if (pair.getValue() == maxValue) System.out.println(pair.getKey());
        }


    }
}
