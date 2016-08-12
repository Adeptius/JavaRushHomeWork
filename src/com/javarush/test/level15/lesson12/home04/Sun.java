package com.javarush.test.level15.lesson12.home04;


public class Sun implements Planet {
    private static  Sun ourInstance = null;

    public static synchronized Sun getInstance() {
        if (ourInstance == null)
            ourInstance = new Sun();
        return ourInstance;
    }

    private Sun() {
    }
}
