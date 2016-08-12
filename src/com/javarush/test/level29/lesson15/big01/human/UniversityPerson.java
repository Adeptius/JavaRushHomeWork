package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Владелец on 08.07.2016.
 */
public class UniversityPerson extends Human{
    public UniversityPerson(String name, int age) {
        super(name,age);
    }

    private University university;

    public void setUniversity(University university) {
        this.university = university;
    }

    public University getUniversity() {

        return university;
    }
}
