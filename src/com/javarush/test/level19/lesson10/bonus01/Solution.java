package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5


Решение полностью не моё
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> stringsFromFileOne = new ArrayList<String>();
    public static List<String> stringsFromFileTwo = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReaderOne = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileReaderTwo = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while (fileReaderOne.ready())
            stringsFromFileOne.add(fileReaderOne.readLine());
        fileReaderOne.close();

        while (fileReaderTwo.ready())
            stringsFromFileTwo.add(fileReaderTwo.readLine());
        fileReaderTwo.close();

        int initOne = 0, initTwo = 0;
        boolean isEmptyFirstList = false;
        boolean isEmptySecondList = false;

        while (true)
        {
            if (initOne >= stringsFromFileOne.size())
                isEmptyFirstList = true;
            if (initTwo >= stringsFromFileTwo.size())
                isEmptySecondList = true;

            /*This is scenario when only first list is empty */
            if (isEmptyFirstList && !isEmptySecondList)
            {
                if (lines.get(lines.size() - 1).type.equals(Type.SAME))
                {
                    lines.add(new LineItem(Type.ADDED, stringsFromFileTwo.get(initTwo)));
                    break;
                } else
                    return;
            }
            /*This is scenario when only second list is empty */
            if (isEmptySecondList && !isEmptyFirstList)
            {
                if (lines.get(lines.size() - 1).type.equals(Type.SAME))
                {
                    lines.add(new LineItem(Type.REMOVED, stringsFromFileOne.get(initOne)));
                    break;
                } else
                    return;
            }
            /*This is scenario when both lists are empty */
            if (isEmptyFirstList && isEmptySecondList)
                break;

            /*If both values from lists are equals*/
            if (stringsFromFileOne.get(initOne).equals(stringsFromFileTwo.get(initTwo)))
            {
                lines.add(new LineItem(Type.SAME, stringsFromFileOne.get(initOne)));

                if (initOne < stringsFromFileOne.size())
                    initOne++;
                else
                    isEmptyFirstList = true;

                if (initTwo < stringsFromFileTwo.size())
                    initTwo++;
                else
                    isEmptySecondList = true;
            }


            else if (!isEmptyFirstList && !isEmptySecondList)
            {

                if ((initTwo + 1 < stringsFromFileTwo.size()) && stringsFromFileOne.get(initOne).equals(stringsFromFileTwo.get(initTwo + 1)))
                {
                    lines.add(new LineItem(Type.ADDED, stringsFromFileTwo.get(initTwo)));
                    lines.add(new LineItem(Type.SAME, stringsFromFileOne.get(initOne)));

                    if (initOne < stringsFromFileOne.size())
                        initOne++;
                    else
                        isEmptyFirstList = true;

                    if (initTwo < stringsFromFileTwo.size())
                        initTwo++;
                    else
                        isEmptySecondList = true;

                    if (initTwo < stringsFromFileTwo.size())
                        initTwo++;
                    else
                        isEmptySecondList = true;
                }

                else if ((initOne + 1 < stringsFromFileOne.size()) && stringsFromFileTwo.get(initTwo).equals(stringsFromFileOne.get(initOne + 1)))
                {
                    lines.add(new LineItem(Type.REMOVED, stringsFromFileOne.get(initOne)));
                    lines.add(new LineItem(Type.SAME, stringsFromFileTwo.get(initTwo)));

                    if (initOne < stringsFromFileOne.size())
                        initOne++;
                    else
                        isEmptyFirstList = true;

                    if (initOne < stringsFromFileOne.size())
                        initOne++;
                    else
                        isEmptyFirstList = true;

                    if (initTwo < stringsFromFileTwo.size())
                        initTwo++;
                    else
                        isEmptySecondList = true;
                }
            }
        }

        for (LineItem line : lines)
            System.out.printf("%s %s%n", line.type, line.line);
    }


    public static enum Type
    {
        ADDED,        //added new line
        REMOVED,      //removed line
        SAME          //no changes
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}