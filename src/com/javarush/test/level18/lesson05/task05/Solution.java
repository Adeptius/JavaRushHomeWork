package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream is;
            while (true) {
                is = new FileInputStream(reader.readLine());
                if (is.available() < 1000){
                    reader.close();
                    is.close();
                    throw new DownloadException();
                }
            }
        }catch (IOException e ){}
    }

    public static class DownloadException extends Exception{

    }
}
