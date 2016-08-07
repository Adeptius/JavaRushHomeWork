package com.javarush.test.level34.lesson15.big01.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fawn on 09.02.2016.
 */
public class LevelLoader
{

    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level)
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(levels.toFile())))
        {

            Set<Wall> walls = new HashSet<>();
            Set<Box> boxes = new HashSet<>();
            Set<Home> homes = new HashSet<>();
            Player player = null;
            int fieldSellSize = Model.FIELD_SELL_SIZE;

            level = level > 60 ? level % 60 : level;

            String str;
            while ((str = bufferedReader.readLine()) != null)
            {
                if (str.equals("Maze: " + level))
                {
                    bufferedReader.readLine();
                    str = bufferedReader.readLine();
                    int width = Integer.valueOf(str.substring(str.indexOf(":") + 2)) ;
                    str = bufferedReader.readLine();
                    int height = Integer.valueOf(str.substring(str.indexOf(":") + 2));
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    for (int i = 0; i < height; i++)
                    {
                        str = bufferedReader.readLine();
                        int y = fieldSellSize / 2 + i * fieldSellSize;
                        for (int j = 0; j < width; j++)
                        {
                            int x = fieldSellSize / 2 + j * fieldSellSize;
                            char ch = str.charAt(j);
                            switch (ch)
                            {
                                case 'X':
                                    walls.add(new Wall(x, y));
                                    break;
                                case '*':
                                    boxes.add(new Box(x, y));
                                    break;
                                case '.':
                                    homes.add(new Home(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                                    break;
                                case '&':
                                    homes.add(new Home(x, y));
                                    boxes.add(new Box(x, y));
                                    break;
                            }
                        }
                    }
                    break;
                }
            }


            return new GameObjects(walls, boxes, homes, player);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}