package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.LinkedList;

/**
 * Created by Владелец on 10.08.2016.
 */
public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(new LinkedList<User>());
        modelData.getUsers().add(new User("A", 1,1));
        modelData.getUsers().add(new User("B", 2,1));
    }
}
