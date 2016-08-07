package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Владелец on 01.08.2016.
 */
public class Wall extends CollisionObject {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        int beginX = this.getX() - this.getWidth() / 2;
        int beginY = this.getY() - this.getHeight() / 2;
        int width = this.getWidth();
        int height = this.getHeight();

        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(beginX, beginY, width, height);
    }
}
