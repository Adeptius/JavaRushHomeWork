package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {

    public static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses(){return horses;}

    public static Hippodrome game;

    public void run(){
        for (int i = 1; i <= 10; i++) {
            move();
            print();
            try {Thread.sleep(200);} catch (Exception e){}
        }
    }

    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print(){
        System.out.println();
        System.out.println();
        for (Horse horse : horses) {
            horse.print();
        }

    }

    public Horse getWinner(){
        Horse winner = getHorses().get(0);
        for (Horse horse : horses) {
            if (horse.getDistance()>winner.getDistance()) winner = horse;
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horse1 = new Horse("Lucky", 2, 0);
        Horse horse2 = new Horse("May", 2, 0);
        Horse horse3 = new Horse("Firebird", 2, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
}
