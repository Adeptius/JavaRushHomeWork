package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name, colour;
    int grouth;

    public void initialize(String name)
    {
        this.name = name;
    }
    public void initialize(String name, int grouth)
    {
        this.name = name + grouth;
    }
    public void initialize(String name, int grouth, String colour)
    {
        this.name = name + grouth + colour;
    }

}
