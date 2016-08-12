package com.javarush.test.level15.lesson12.home04;


public class Earth implements Planet {
    private  static  Earth ourInstance = null;

    public static synchronized Earth getInstance() {
        if (ourInstance == null)
            ourInstance = new Earth();
        return ourInstance;
    }

    private Earth() {
    }
}
