package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();


        FileInputStream fis1 = new FileInputStream(f1);
        FileInputStream fis2 = new FileInputStream(f2);

        byte[] file1Byte = new byte[fis1.available()];
        while (fis1.available() > 0)   {
            fis1.read(file1Byte);
        }
        fis1.close();

        byte[] file2Byte = new byte[fis2.available()];
        while (fis2.available() > 0)   {
            fis2.read(file2Byte);
        }
        fis2.close();

        FileOutputStream fos1 = new FileOutputStream(f1);
        fos1.write(file2Byte);
        fos1.close();
        FileOutputStream fos2 = new FileOutputStream(f1, true);
        fos2.write(file1Byte);
        fos2.close();
    }
}
