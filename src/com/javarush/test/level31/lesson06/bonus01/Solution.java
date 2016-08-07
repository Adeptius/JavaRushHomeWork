package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws Exception {

        String[] temp =  {
                "Z:/ResultFile.mp4",
                "Z:/aviForTest.zip.004",
                "Z:/aviForTest.zip.001",
                "Z:/aviForTest.zip.003",
                "Z:/aviForTest.zip.005",
                "Z:/aviForTest.zip.002",
                "Z:/aviForTest.zip.006"
        };
        args = temp;

        ArrayList<File> partsZip = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            partsZip.add(new File(args[i]));
        }
        Collections.sort(partsZip);
        String resultFileName = args[0];

        ArrayList<FileInputStream> fileInputStreams = new ArrayList<>();

        for (File file : partsZip) {
            fileInputStreams.add(new FileInputStream(file));
        }

        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)))) {
            ZipEntry entry = null;
            while ((entry = is.getNextEntry()) != null) {
                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFileName))) {
                    final int bufferSize = 8 * 1024;
                    byte[] buffer = new byte[bufferSize];
                    int readBytes = -1;
                    while ((readBytes = is.read(buffer, 0, bufferSize)) > -1) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                }
            }
        }


        //        Мое решение с созданием временного файла

        /*
        String[] arguments = args;
        String resultFileName = arguments[0];
        ArrayList<String> listOfFiles = new ArrayList<>();

        for (int i = 1; i < arguments.length; i++) {
            listOfFiles.add(arguments[i]);
        }
        Collections.sort(listOfFiles);

        try {
            File tempFile = File.createTempFile("123",".temp");
            OutputStream os = new FileOutputStream(tempFile);
            for (String listOfFile : listOfFiles) {
                Files.copy(Paths.get(listOfFile), os);
            }
            os.close();

            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(tempFile));
            ZipEntry ze;
            while ((ze = zipInputStream.getNextEntry()) != null){
                Files.copy(zipInputStream, Paths.get(resultFileName));
            }
        } catch (Exception e) { e.printStackTrace(); }

        */
    }
}
