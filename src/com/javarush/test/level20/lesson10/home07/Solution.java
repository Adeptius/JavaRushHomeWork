package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private static final long serialVersionUID = 1L;
    private String fileName;

    public Solution() {
    }
    public static void main(String[] args)throws Exception {
        Solution s = new Solution("output.txt");
        s.writeObject("Привет");
        s.writeObject("Привет2");
        s.writeObject("Привет3");

        ByteArrayOutputStream storage = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(storage);
        objectOutputStream.writeObject(s);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(storage.toByteArray()));
        Solution read = (Solution) objectInputStream.readObject();
        read.writeObject("Hello");
        read.writeObject("Hello2");
        read.writeObject("Hello3");
        read.close();
    }
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}