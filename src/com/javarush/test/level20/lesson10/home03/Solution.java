package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{

    public static void main(String[] args)throws Exception{
        /*
        Solution solution = new Solution();
        Solution.B b1 = solution.new B("123");
        System.out.println(b1.name);

        File file = new File("some.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(b1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Solution.B b2 = solution.new B("D");
        System.out.println(b2.name);
        b2 = (Solution.B)(ois.readObject());
        System.out.println(b2.name);
        */
    }
    public static class A {
        protected String name = "A";
        public A(){}

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String)in.readObject();
        }

    }


}
