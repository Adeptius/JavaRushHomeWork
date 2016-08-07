package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();

        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) break;
            files.add(s);
        }

        String[] filesArr = new String[files.size()];

        for (int i = 0; i < files.size(); i++) {
            String fileName = files.get(i);
            int numberOfPart = Integer.parseInt(fileName.substring(fileName.lastIndexOf(".")+5, fileName.length())) - 1;
            filesArr[numberOfPart] = fileName;
        }

        String destinationFile = filesArr[1].substring(0, filesArr[1].lastIndexOf("."));
        FileOutputStream fos = new FileOutputStream(destinationFile,true);

        for (int i = 0; i < filesArr.length ; i++) {
            FileInputStream fis = new FileInputStream(filesArr[i]);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();
            fos.write(data);
        }
        fos.close();
        reader.close();






    }
}
