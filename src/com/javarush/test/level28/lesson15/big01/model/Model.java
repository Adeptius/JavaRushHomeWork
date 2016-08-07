package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владелец on 05.07.2016.
 */
public class Model {

    View view;
    Provider[] providers;

    public Model(View view, Provider[] providers) {
        if (view != null && providers != null && providers.length != 0) {
            this.view = view;
            this.providers = providers;
        } else throw new IllegalArgumentException();
    }

    public void selectCity(String city) {
        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers) {
            vacancies.addAll(provider.getJavaVacancies(null));
        }

        view.update(vacancies);
    }
}
