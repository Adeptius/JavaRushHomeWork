package com.javarush.test.level15.lesson12.home04;


public class Moon implements Planet {
    private static Moon ourInstance = null;

    public static synchronized Moon getInstance() {
        if (ourInstance == null)
            ourInstance = new Moon();
        return ourInstance;
    }

    private Moon() {
    }
}
