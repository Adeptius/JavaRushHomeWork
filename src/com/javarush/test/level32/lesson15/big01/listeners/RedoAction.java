package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import java.awt.event.ActionEvent;

/**
 * Created by Владелец on 15.07.2016.
 */
public class RedoAction {

    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent actionEvent){
        view.redo();
    }
}
