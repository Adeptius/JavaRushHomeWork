package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Leonid on 21.01.2016.
 */

//4.1.	Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за
//        инициализацию меню и панелей редактора.
//        4.2.	Объяви в представлении метод initGui(). Он будет инициализировать графический
//        интерфейс. Вызови из него инициализацию меню initMenuBar(), инициализацию редактора
//        initEditor() и метод pack(), реализацию которого мы унаследовали от класса JFrame.
//        Разберись что делает метод pack().
//        4.3.	Реализуй метод init() представления. Он должен:
//        4.3.1.	Вызывать инициализацию графического интерфейса initGui().
//        4.3.2.	Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй
//        объект класса FrameListener. В качестве метода для добавления подписчика используй
//        подходящий метод из класса Window от которого наследуется и наш класс через
//        классы JFrame и Frame.
//        4.3.3.	Показывать наше окно. Используй метод setVisible с правильным параметром.
//        На этом этапе приложение при запуске должно показывать окно, которое можно растягивать,
//        разворачивать, закрыть и т.д.
public class FrameListener extends WindowAdapter
{
    View view;
    public FrameListener(View view )    {
        this.view = view;
    }

    @Override public void windowClosing (WindowEvent windowEvent)   {
        view.exit();
    }
}
