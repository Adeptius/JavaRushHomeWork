package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setHeight(2);
        setWidth(2);
    }

    @Override
    public void draw(Graphics graphics) {
        int beginX = this.getX() - this.getWidth() / 2;
        int beginY = this.getY() - this.getHeight() / 2;
        int width = this.getWidth();
        int height = this.getHeight();

        graphics.setColor(Color.RED);
        graphics.drawOval(beginX, beginY, width, height);
    }
}