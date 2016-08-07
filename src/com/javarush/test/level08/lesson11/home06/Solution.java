package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human ditya1 = new Human("Сашик", true, 20, null);
        Human ditya2 = new Human("Женька", true, 20, null);
        Human ditya3 = new Human("Лизочка", false, 20, null);
        ArrayList<Human> deti = new ArrayList<Human>();
        deti.add(ditya1);
        deti.add(ditya2);
        deti.add(ditya3);

        Human batya = new Human("Батяня", true, 40, deti);
        Human mama = new Human("Маманя", false, 40, deti);
        ArrayList<Human> roditeli = new ArrayList<Human>();
        roditeli.add(batya);
        roditeli.add(mama);


        Human ded1 = new Human("Мазай", true, 50, roditeli);
        Human ded2 = new Human("Фёдорыч", true, 60, roditeli);
        Human baba1 = new Human("Тимофеевна", false, 50, roditeli);
        Human baba2 = new Human("Карповна", false, 60, roditeli);



        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba1.toString());
        System.out.println(baba2.toString());
        System.out.println(batya.toString());
        System.out.println(mama.toString());
        System.out.println(ditya1.toString());
        System.out.println(ditya2.toString());
        System.out.println(ditya3.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human(String name, boolean sex, int age, ArrayList<Human> childrens){
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (childrens == null) this.children = new ArrayList<Human>();
            else  this.children = childrens;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
