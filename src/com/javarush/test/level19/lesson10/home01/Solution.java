package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
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

        SortedSet<String> keys = new TreeSet<String>(map.keySet());
        for (String key : keys) {
            double value = map.get(key);
            System.out.println(key + " " + value);
        }


    }
}
