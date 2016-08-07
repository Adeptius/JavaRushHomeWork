package com.javarush.test.level11.lesson06.task03;

/* В гостях у бабушки
Написать шесть классов: Animal (животное), Cow(корова) и Pig(свинья), Sheep(овца), Bull(бык), Goat(козел).
Унаследовать корову, свинью, овцу, быка и козла от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Animal
    {
        String name;
        int age, weiht;
    }

    public class Cow extends Animal
    {
        String muuuu;
    }

    public class Pig extends Animal
    {
        String hruu;

    }

    public class Sheep extends Animal
    {
        String meee;

    }

    public class Bull extends Animal
    {
        String MUUUUU;

    }

    public class Goat extends Animal
    {
        String meeeee;

    }

}
