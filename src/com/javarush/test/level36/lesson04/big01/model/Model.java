package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Владелец on 10.08.2016.
 */
public interface Model {

    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();
}
