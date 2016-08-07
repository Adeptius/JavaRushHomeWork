package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bure = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(bure.readLine()); // читаем файл в строку
        bure.close();
        String mainStr = "";
        while (reader.ready()) mainStr += (char) reader.read();
        reader.close();

        mainStr = mainStr.replace("\r\n", " "); // убираем все переносы на новую строку

        String openTag = "<" + args[0]; // <span
        String closedTag = "/" + args[0]; // /span
        int tagLength = closedTag.length(); // длинна тэга

        for (int i = 0; i < mainStr.length()-tagLength; i++) { // по кусочкам перебираем части равные длинне тэга
            String temp = mainStr.substring(i, i+tagLength);
            if (temp.equals(openTag)){ // если мы нашли открывающий тэг - далее ищем закрывающий
                int tagsCount = 1; // если мы попадём на еще один открывающий тэг ++ а если закрывающий --
                for (int j = i+1; j < mainStr.length()-tagLength; j++) { // повторный перебор. ищем закрывающий тэг
                    String temp2 = mainStr.substring(j, j+tagLength);
                    if(temp2.equals(openTag)) tagsCount++; // нашли открывающий тэг
                    if(temp2.equals(closedTag)) { // нашли закрывающий тэг
                        tagsCount--;
                        if (tagsCount == 0) { // если мы нашли именно наш закрывающий тэг - выдаём на экран
                            System.out.println(mainStr.substring(i, j+tagLength+1));
                            break; // прерываем поиск закрытого тэга и возвращаемся к поиску открывающего
                        }
                    }
                }
            }
        }
    }
}