package com.javarush.test.level10.lesson11.home08;
import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arr = new ArrayList[2];
        ArrayList<String> one = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            one.add(i + " строка");
        }
        ArrayList<String> two = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            two.add(i + " строка");
        }
        arr[0] = one;
        arr[1] = two;


        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}