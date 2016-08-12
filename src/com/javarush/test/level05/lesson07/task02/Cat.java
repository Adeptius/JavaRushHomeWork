package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name, colour, address, kot;
    int weight, age;


    public void initialize(String name)
    {
        this.kot = name;
    }
    public void initialize(String name, int weight, int age)
    {
        this.kot = name + weight + age;
    }
    public void initialize(String name, int age)
    {
        weight = 3;
        this.kot = name + age + weight;
    }
    public void initialize(int weight, String colour)
    {
        this.name = null;
        this.address = null;
        this.kot = weight + colour;
    }
    public void initialize(int weight, String colour, String address)
    {
        this.kot = weight + colour + address;
    }
}
