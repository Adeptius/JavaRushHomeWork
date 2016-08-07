package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String string = new String(result);
        String newString = "";
        for (int i = 0; i < string.length() ; i++) {

            if     (string.charAt(i) == '0' ||
                    string.charAt(i) == '1' ||
                    string.charAt(i) == '2' ||
                    string.charAt(i) == '3' ||
                    string.charAt(i) == '4' ||
                    string.charAt(i) == '5' ||
                    string.charAt(i) == '6' ||
                    string.charAt(i) == '7' ||
                    string.charAt(i) == '8' ||
                    string.charAt(i) == '9'
                    ) newString += string.charAt(i);
        }
        System.out.println(newString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}