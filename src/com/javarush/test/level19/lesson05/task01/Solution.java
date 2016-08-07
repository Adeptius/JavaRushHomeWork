package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileReader reader = new FileReader(br.readLine());
        FileWriter writer = new FileWriter(br.readLine());

        int i = 0;
        while (reader.ready())
        {
            int data = reader.read();
            i++;
            if (i % 2 == 0)  writer.write(data);
        }


        reader.close();
        writer.close();

    }
}
