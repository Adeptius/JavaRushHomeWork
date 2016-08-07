package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String string = result;
        String[] splitted = string.split("[ =]");
        ArrayList<String> list = new ArrayList();

        for (int i = splitted.length -1; i >= 0; i--) {
            if (!(splitted[i].equals(""))) list.add(splitted[i]);
        }
        int re = 0;
        int numberOne = Integer.parseInt(list.get(3));
        int numberTwo = Integer.parseInt(list.get(1));
        if (list.get(2).equals("+")){  re = numberOne + numberTwo;   }
        if (list.get(2).equals("-")){  re = numberOne - numberTwo;   }
        if (list.get(2).equals("*")){  re = numberOne * numberTwo;   }
        string += re;
        System.out.println(string);
        outputStream.close();
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

