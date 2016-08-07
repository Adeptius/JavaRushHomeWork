package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(args[0]);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        is.close();
        Arrays.sort(bytes);
        ArrayList<Integer> check = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < bytes.length; i++) {
            count = 0;
            if (!(check.contains((int)bytes[i]))){
                for (int j = 0; j < bytes.length; j++) {
                    if (bytes[i] == bytes[j]) count++;
                }
                check.add((int)bytes[i]);
                result.add((char)(int)bytes[i] + " " + count );
            }
        }
        for (String s : result){
            System.out.println(s);
        }

    }
}
