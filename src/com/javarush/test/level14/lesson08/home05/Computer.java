package com.javarush.test.level14.lesson08.home05;


public class Computer {
    private Mouse Mouse;
    private Keyboard Keyboard;
    private Monitor Monitor;

    public Mouse getMouse() {
        return Mouse;
    }

    public Keyboard getKeyboard() {
        return Keyboard;
    }

    public Monitor getMonitor() {
        return Monitor;
    }


    public Computer() {
        this.Mouse = new Mouse();
        this.Keyboard = new Keyboard();
        this.Monitor = new Monitor();
    }
}
