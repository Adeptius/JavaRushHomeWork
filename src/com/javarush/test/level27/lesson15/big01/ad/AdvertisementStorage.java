package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Владелец on 18.08.2016.
 */
public class AdvertisementStorage {

    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
    }
}
