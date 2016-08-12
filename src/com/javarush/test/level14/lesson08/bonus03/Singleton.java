package com.javarush.test.level14.lesson08.bonus03;


class Singleton{

    private static Singleton only;

    private Singleton(){}

    static Singleton getInstance(){
        if (only == null) only = new Singleton();
        return only;
    }
}
