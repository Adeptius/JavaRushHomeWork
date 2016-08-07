package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кот-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = reader.readLine();
        String babaName = reader.readLine();
        String papaName = reader.readLine();
        String mamaName = reader.readLine();
        String sonName = reader.readLine();
        String daughterName = reader.readLine();

        Cat catded = new Cat(dedName);
        Cat catbaba = new Cat(babaName);
        Cat catpapa = new Cat(papaName, catded, null);
        Cat catmama = new Cat(mamaName, null, catbaba);
        Cat catson = new Cat(sonName, catpapa, catmama);
        Cat catdaughter = new Cat(daughterName, catpapa, catmama);

        System.out.println(catded);
        System.out.println(catbaba);
        System.out.println(catpapa);
        System.out.println(catmama);
        System.out.println(catson);
        System.out.println(catdaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat papa;
        private Cat mama;

        Cat(String name)
        {
            this.name = name;
        }


        Cat(String name, Cat papa, Cat mama)
        {
            this.name = name;
            this.mama = mama;
            this.papa = papa;
        }


        @Override
        public String toString()
        {

            if (mama == null && papa == null)
                return "Cat name is " + name + ", no mother, no father";
            if (mama == null)
                return "Cat name is " + name + ", no mother, father is " + papa.name;
            if (papa == null)
                return "Cat name is " + name + ", mother is " + mama.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + mama.name + ", father is " + papa.name;
        }

    }

}
