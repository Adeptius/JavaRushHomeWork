package com.javarush.test.level34.lesson15.big01.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Владелец on 01.08.2016.
 */
public class GameObjects {

    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<GameObject> getAll(){
        Set<GameObject> gameObjects = new HashSet<>();
        for (Wall wall : walls) {
            gameObjects.add(wall);
        }
        for (Box box : boxes) {
            gameObjects.add(box);
        }
        for (Home home : homes) {
            gameObjects.add(home);
        }
        gameObjects.add(player);

        return gameObjects;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Player getPlayer() {
        return player;
    }


}
