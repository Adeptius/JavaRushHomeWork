package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Владелец on 05.07.2016.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
