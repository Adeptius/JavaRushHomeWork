package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Владелец on 01.08.2016.
 */
public class Player extends CollisionObject implements Movable {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int beginX = this.getX() - this.getWidth() / 2;
        int beginY = this.getY() - this.getHeight() / 2;
        int width = this.getWidth();
        int height = this.getHeight();

        graphics.setColor(Color.red);
        graphics.fillOval(beginX + 1, beginY + 1, width -3 , height -3 );
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
