package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Владелец on 18.08.2016.
 */
public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;


    public static String allDishesToString(){
        String dishes = "";
        for (Dish dish : Dish.values()){
            dishes += dish + ", ";
        }
        return (dishes.length() != 0) ? dishes.substring(0, dishes.lastIndexOf(",")) : "";
    }
}
