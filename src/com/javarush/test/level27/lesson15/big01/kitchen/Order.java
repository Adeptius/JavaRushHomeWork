package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Владелец on 18.08.2016.
 */
public class Order {

    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }






    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }
}
