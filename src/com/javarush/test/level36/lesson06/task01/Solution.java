package com.javarush.test.level36.lesson06.task01;

import java.util.Collections;

/* Найти класс по описанию
1. Реализует интерфейс List
2. Является приватным статическим классом внутри популярного утилитного класса
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException
4. Используйте рефлекшн, чтобы добраться до искомого класса
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] aClass = Collections.class.getDeclaredClasses(); // получили массив всех классов в Collections
        for (int i = 0; i <aClass.length ; i++) {
            Class[] interfases = aClass[i].getInterfaces(); // получили массив интерфейсов для каждого класса

            for (int j = 0; j < interfases.length ; j++) {
                if (interfases[j].getSimpleName().equals("List")) // если интерфейс класса == интерфейс LIST
                    System.out.println(aClass[i].getSimpleName()); // выводим на экран название класса
            }
        }

        return null; // Принимает только Collections.EMPTY_LIST.getClass();
    }
}

/**
 *   try {
 Class clazz  = Class.forName(aClass[i].getName());
 Class<?>[] innerClasses = clazz.getDeclaredClasses();
 for (int k = 0; k < innerClasses.length; k++) {
 //System.out.println(innerClasses[k]);
 }
 } catch (ClassNotFoundException e) {
 e.printStackTrace();
 }
 */
