package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop
{
    @XmlElementWrapper(name = "goods")
    public List<String> names;
    public int count;
    public double profit;
    public List<String> secretData;

    @Override
    public String toString()
    {
        return "Shop{" +
                "names=" + names +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }
}