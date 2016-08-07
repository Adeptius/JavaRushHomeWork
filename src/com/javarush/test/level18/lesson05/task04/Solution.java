package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis1 = new FileInputStream(reader.readLine());
        FileOutputStream fis2 = new FileOutputStream(reader.readLine());

        byte [] buffer = new byte[fis1.available()];
        byte [] reffub = new byte[fis1.available()];
        int buf_size = fis1.read(buffer);
        for(int i = buf_size - 1; i >= 0; i--){
            reffub[buf_size - 1 - i] = buffer[i];
        }
        fis2.write(reffub);

        fis1.close();
        fis2.close();
        reader.close();
    }
}
