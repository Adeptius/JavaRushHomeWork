package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream is = new FileInputStream(reader.readLine());
        String s1 = new BufferedReader(new InputStreamReader(is)).readLine();
        FileWriter writer = new FileWriter(reader.readLine());
        reader.close();

        String[] numbers =  s1.split(" ");

        for (int i = 0; i < numbers.length; i++) {
            float f = Float.parseFloat(numbers[i]);
            int b = (int) f;
            float ostatok = f - b;
            if      (ostatok  < 0.5 && f > 0) ostatok = 0;
            else if (ostatok >= 0.5 && f > 0) ostatok = 1;
            else if (ostatok >= -0.5 && f < 0) ostatok = 0;
            else if (ostatok  < -0.5 && f < 0) ostatok = -1;
            float result = b + ostatok;



            writer.write( (int) result + " ");

        }
        writer.close();
        is.close();
    }
}
