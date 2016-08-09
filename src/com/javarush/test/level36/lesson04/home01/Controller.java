package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by Владелец on 10.08.2016.
 */
public class Controller {

    private Model service = new Model();
    public List<String> onDataListShow()
    {
        return service.getStringDataList();
    }
}
