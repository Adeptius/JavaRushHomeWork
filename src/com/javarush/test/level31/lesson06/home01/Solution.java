package com.javarush.test.level31.lesson06.home01;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.
Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip
Файлы внутри test.zip:
a.txt
b.txt
После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt
Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {

        String fileFullName = args[0];
        String zipName = args[1];
        String fileName = fileFullName.substring(fileFullName.lastIndexOf("\\") + 1);
        boolean isFileInZip = false;
        Map<String, byte[]> zipEntryHashMap = new HashMap<>();
        try (FileInputStream zipfile = new FileInputStream(zipName);
             ZipInputStream zipInputStream = new ZipInputStream(zipfile))
        {
            ZipEntry ze;
            while ((ze = zipInputStream.getNextEntry()) != null)
            {
                if (!ze.getName().equals(fileName))
                {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zipInputStream.read(buffer)) != -1)
                    {
                        baos.write(buffer, 0, count);
                    }
                    zipEntryHashMap.put(ze.getName(), baos.toByteArray());
                } else
                {
                    isFileInZip = true;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        try (FileOutputStream zipOutfile = new FileOutputStream(zipName);
             FileInputStream file = new FileInputStream(fileFullName);
             ZipOutputStream zipOutputStream = new ZipOutputStream(zipOutfile))
        {
            if (isFileInZip)
            {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = file.read(buffer)) != -1)
                {
                    baos.write(buffer, 0, count);
                }
                zipEntryHashMap.put("new/" + fileName, baos.toByteArray());
            }
            for (Map.Entry<String, byte[]> zipEntry : zipEntryHashMap.entrySet())
            {
                zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey()));
                zipOutputStream.write(zipEntry.getValue());
                zipOutputStream.closeEntry();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}