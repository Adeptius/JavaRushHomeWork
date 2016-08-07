package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] mass = new Solution[2];
        for (int i = 0; i < 2; i++) {
            mass[i] = new Solution();
            InnerClass in = mass[i].new InnerClass();
            mass[i].innerClasses[0] = in;
            InnerClass in2 = mass[i].new InnerClass();
            mass[i].innerClasses[1] = in2;
        }
        return mass;
    }
}
