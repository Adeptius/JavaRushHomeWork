package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int beginX = this.getX() - this.getWidth() / 2;
        int beginY = this.getY() - this.getHeight() / 2;
        int width = this.getWidth();
        int height = this.getHeight();

        graphics.setColor(Color.ORANGE);
        graphics.fillRect(beginX + 1, beginY + 1, width - 1, height - 1);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
