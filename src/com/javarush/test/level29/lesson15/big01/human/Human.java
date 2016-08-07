package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;
    private List<Human> children = new ArrayList<>();

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private BloodGroup bloodGroup;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }

    public class Size {
        public int height;
        public int weight;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        switch (bloodGroup.getCode()){
            case 1:         this.bloodGroup = BloodGroup.first(); break;
            case 2:         this.bloodGroup = BloodGroup.second();break;
            case 3:         this.bloodGroup = BloodGroup.third();break;
            case 4:         this.bloodGroup = BloodGroup.fourth();break;
        }
    }

    @Override
    public void live() {

    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
        children.add(human);
    }

    public void removeChild(Human human){
        children.remove(human);
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPosition(){
        return "Человек";
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}
