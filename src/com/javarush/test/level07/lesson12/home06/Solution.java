package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Мазай", true, 50);
        Human ded2 = new Human("Фёдорыч", true, 60);
        Human baba1 = new Human("Тимофеевна", false, 50);
        Human baba2 = new Human("Карповна", false, 60);
        Human batya = new Human("Батяня", true, 40, ded1, baba1);
        Human mama = new Human("Маманя", false, 40, ded2, baba2);
        Human ditya1 = new Human("Сашик", true, 20, batya, mama);
        Human ditya2 = new Human("Женька", true, 20, batya, mama);
        Human ditya3 = new Human("Лизочка", false, 20, batya, mama);

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
        Human father;
        Human mother;

        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }



        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
