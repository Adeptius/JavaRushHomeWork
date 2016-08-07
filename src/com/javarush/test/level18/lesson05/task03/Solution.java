package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1In = new FileInputStream(reader.readLine());
        FileOutputStream file2Out = new FileOutputStream(reader.readLine());
        FileOutputStream file3Out = new FileOutputStream(reader.readLine());

        int halfFile1Size = file1In.available() /2;


        if (file1In.available() %2 == 1){
            while (file1In.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[file1In.available()];
                int count = file1In.read(buffer);
                file2Out.write(buffer, 0, halfFile1Size+1);
                file3Out.write(buffer, halfFile1Size+1, count - (halfFile1Size+1));
                System.out.println("file is odd");
            }
        }
        else {
            while (file1In.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[file1In.available()];
                int count = file1In.read(buffer);
                file2Out.write(buffer, 0, halfFile1Size);
                file3Out.write(buffer, halfFile1Size, count - halfFile1Size);
                System.out.println("file is no odd");
            }
        }
        reader.close();
        file1In.close();
        file2Out.close();
        file3Out.close();
    }
}
