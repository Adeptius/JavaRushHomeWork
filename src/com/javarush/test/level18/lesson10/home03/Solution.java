package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();

        FileInputStream fis2 = new FileInputStream(f2);
        FileInputStream fis3 = new FileInputStream(f3);

        FileOutputStream fos = new FileOutputStream(f1);
        FileOutputStream fos2 = new FileOutputStream(f1, true);

        while (fis2.available() > 0){
            int data = fis2.read();
            fos.write(data);
        }

        while (fis3.available() > 0 ){
            int data2 = fis3.read();
            fos2.write(data2);
        }

        reader.close();
        fos.close();
        fos2.close();
        fis2.close();
        fis3.close();
    }
}
