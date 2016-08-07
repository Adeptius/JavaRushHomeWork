package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File files = new File(args[0]);
        File result = new File(args[1]);
        File fileToSave = new File(result.getParent() + "/allFilesContent.txt");
        ArrayList<File> fileList = checkDir(files, args[1]);
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return (o1.getName()).compareTo(o2.getName());
            }
        });
        FileOutputStream fileWriter = new FileOutputStream(result);
        byte[] array;
        Iterator<File> iterator = fileList.iterator();
        while (iterator.hasNext()) {
            array = Files.readAllBytes(iterator.next().toPath());
            fileWriter.write(new String(array).getBytes());
            if (iterator.hasNext()) {
                fileWriter.write("\n".getBytes());
            }
        }
        fileWriter.close();
        result.renameTo(fileToSave);
        removeEmptyDir(files);

    }

    public static ArrayList<File> checkDir(File files, String fileNotDelete) throws IOException {
        ArrayList<File> fileList = new ArrayList<>();
        Iterator<File> iterator = Arrays.asList(files.listFiles()).iterator();
        while (iterator.hasNext()) {
            File file = iterator.next();
            if (!file.getAbsolutePath().equals(fileNotDelete)) {
                if (file.isDirectory()) {
                    fileList.addAll(checkDir(file, fileNotDelete));

                } else {
                    if (file.length() <= 50) {
                        fileList.add(file);
                    } else if (file.length() > 50) {
                        Files.delete(file.toPath());
                    }
                }
            }
        }
        return fileList;
    }

    public static void removeEmptyDir(File files) {
        Iterator<File> iterator = Arrays.asList(files.listFiles()).iterator();
        while (iterator.hasNext()) {
            File file = iterator.next();
            if (file.isDirectory()) {
                file.delete();
            }
        }
    }
}