package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

public class Model {

    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("Z:\\Programs\\Java\\Projects\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }


    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction))
            return;
        if (checkBoxCollision(direction)) {
            return;
        }

        switch (direction) {
            case LEFT:
                player.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_SELL_SIZE);
        }

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {

        Player player = gameObjects.getPlayer();

        GameObject stopObject = null;

        for (GameObject object : gameObjects.getBoxes()) {
            if (!(object instanceof Player) && !(object instanceof Home) && player.isCollision(object, direction)) {
                stopObject = object;
            }
        }

        if (stopObject == null) {
            return false;
        }

        if (stopObject instanceof Box) {
            Box stopBox = (Box) stopObject;

            if (checkWallCollision(stopBox, direction)) {
                return true;
            }

            for (Box box : gameObjects.getBoxes()) {
                if (stopBox.isCollision(box, direction)) {
                    return true;
                }
            }
            switch (direction) {

                case LEFT:
                    stopBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopBox.move(0, FIELD_SELL_SIZE);
                    break;
            }
        }
        return false;
    }

    public void checkCompletion() {
        boolean isBoxInHome = true;
        for (Home home : gameObjects.getHomes()) {

            isBoxInHome = false;
            for (Box box : gameObjects.getBoxes()) {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY())) {
                    isBoxInHome = true;
                    break;
                }
            }
            if (!isBoxInHome) {
                break;
            }
        }
        if (isBoxInHome) {
            eventListener.levelCompleted(currentLevel);
        }
    }
}
