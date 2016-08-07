package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> allDishes = new ArrayList<>();
        List<Dish> resultList = new ArrayList<>();

        Collections.addAll(allDishes, Dish.values());

        writeMessage("Please choose the Dish");
        writeMessage(Dish.allDishesToString());

        String message = "";

        while (!(message = readString()).trim().equalsIgnoreCase("exit")) {
            boolean flag = false;

            if (!message.trim().isEmpty()) {

                for (Dish d : allDishes) {
                    if (message.trim().equalsIgnoreCase(d.name())) {
                        resultList.add(d);
                        flag = true;
                        break;
                    }
                }
            }


            if (flag == false) {
                ConsoleHelper.writeMessage("Sorry. Wrong dish name, please try again.");
            }

        }
        return resultList;
    }


}
