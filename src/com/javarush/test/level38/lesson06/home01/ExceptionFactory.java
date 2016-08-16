package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Владелец on 15.08.2016.
 */
public class ExceptionFactory {
    public static Throwable getException(Enum e){
        if (e == null) return new IllegalArgumentException();

        String exMessage = e.toString().substring(0,1) + e.toString().substring(1).replace("_"," ").toLowerCase();

        if (e instanceof ExceptionApplicationMessage){
            return new Exception(exMessage);
        }else if (e instanceof ExceptionDBMessage){
            return new RuntimeException(exMessage);
        }else if (e instanceof ExceptionUserMessage){
            return new Error(exMessage);
        }else
            return new IllegalArgumentException();
    }
}