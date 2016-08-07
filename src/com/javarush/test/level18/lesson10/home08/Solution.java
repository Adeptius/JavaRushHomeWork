package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();
        while (true){
            String s = reader.readLine();
            if (s.equals("exit")) break;
            files.add(s);
        }
        reader.close();
        for (String s : files) { new ReadThread(s).start();}
    }

    public static class ReadThread extends Thread  {
        private String filename;

        public ReadThread(String fileName) {
            this.filename = fileName;
        }

        public void run() {
            try{
                FileInputStream is = new FileInputStream(filename);
                int[] file = new int[is.available()];
                while (is.available() >0){
                    for (int i = 0; i < file.length; i++) {
                        file[i] = is.read();
                    }
                }
                is.close();
                int[] counts = new int[file.length];
                for (int i = 0; i < file.length; i++) {
                    int co =0;
                    for (int j = 0; j < file.length; j++) {
                        if (file[i] == file[j]) co++;
                    }
                    counts[i] = co;
                }
                int k = 0;
                int max = 0;
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] > max){
                        max = counts[i];
                        k = i;
                    }
                }
                resultMap.put(filename, file[k]);
            }catch (IOException e){}
        }
    }
}
