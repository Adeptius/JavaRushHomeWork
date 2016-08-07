package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br1 = new BufferedReader(new FileReader(new File(reader.readLine())));
            String eachLine;
            while (true) {
                eachLine = br1.readLine();
                if (eachLine == null) break;
                allLines.add(eachLine);
            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader(new File(reader.readLine())));
            while (true) {
                eachLine = br2.readLine();
                if (eachLine == null) break;
                forRemoveLines.add(eachLine);
            }
            br2.close();
        }catch (IOException e) {}

        try{new Solution().joinData();}catch (CorruptedDataException e){}
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            return;
        }

        for (String s : forRemoveLines){
            if (!allLines.contains(s)){
                allLines.clear();
                throw new CorruptedDataException();
            }
        }

    }
}
