package com.javarush.test.level13.lesson11.home07;

/* Интерфейс SimpleObject
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.



как-то решил, но решение потерял
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    public static  class StringObject<String> implements SimpleObject<String>{
        public SimpleObject<String> getInstance() {
            StringObject s = new StringObject();
            return s;
        }
    }

}
*/