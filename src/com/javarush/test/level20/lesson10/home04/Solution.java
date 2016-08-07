package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("your.file.name"));

        Solution solution = new Solution();
        System.out.println(solution.size());
        oos.writeObject(solution);
        oos.close();
        //loading
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("your.file.name"));
        Solution loadedObject = (Solution) ois.readObject();
        ois.close();
        //Attention!!
        System.out.println(loadedObject.size());
    }

    static private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    static  {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
