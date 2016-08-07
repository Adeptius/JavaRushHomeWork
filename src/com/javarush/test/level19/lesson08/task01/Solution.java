package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        // Сохраняем оригинальный систем аут

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаём массив, в который будет записавать систем аут

        PrintStream stream = new PrintStream(outputStream);
        //создаём поток, который будет писать данные из систем аут в массив

        System.setOut(stream);
        //Указываем систем ауту, что теперь надо пользоваться нашим новым потоком

        testString.printSomething();
        //Выполняем метод, но на экран ничего не выводится так как систем аут
        //теперь пишет данные в массив, а не на экран

        String result = outputStream.toString();
        //создаём строку из только что заполненного массива

        System.setOut(consoleStream);
        // Возвращаем старый систем аут

        StringBuilder stringBuilder = new StringBuilder(result);
        //Создали для форматирования

        System.out.println(stringBuilder.toString().toUpperCase());
        //И теперь наконец мы выводим отформатированный текст на экран.

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
