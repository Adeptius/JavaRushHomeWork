package com.javarush.test.level36.lesson04.home01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владелец on 10.08.2016.
 */
public class Model {


    private Service service = new Service();
    public List<String> getStringDataList()
    {
        return service.getData();
    }
}
