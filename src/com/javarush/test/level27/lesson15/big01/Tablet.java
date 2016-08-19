package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Владелец on 18.08.2016.
 */
public class Tablet extends Observable{
//Написано в тестовой ветке

    public final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }


    public void createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                setChanged();
                notifyObservers(order);
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
        }
        catch (IOException e) { logger.log(Level.SEVERE, "Console is unavailable."); }
        catch (NoVideoAvailableException e) { logger.log(Level.INFO, "No video is available for the order " + order); }

    }

    @Override
    public String toString() { return "Tablet{number=" + number + "}"; }
}
