package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        load(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties property = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()){
            property.put(pair.getKey(), pair.getValue());
        }
        property.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties property = new Properties();
        property.load(inputStream);
        for (Map.Entry<Object, Object> pair : property.entrySet()){
            String s1 = (String) pair.getKey();
            String s2 = (String) pair.getValue();
            properties.put(s1,s2);
        }
    }
}
