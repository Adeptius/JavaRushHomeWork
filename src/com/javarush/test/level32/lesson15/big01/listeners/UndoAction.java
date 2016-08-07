package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import java.awt.event.ActionEvent;

/**
 * Created by Владелец on 15.07.2016.
 */
public class UndoAction {

    private View view;

    public UndoAction(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent actionEvent){
        view.undo();
    }
}