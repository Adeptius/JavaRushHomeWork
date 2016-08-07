package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat simple_Date_Format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]){
            case "-c":
                if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], simpleDateFormat.parse(args[3])));
                else allPeople.add(Person.createFemale(args[1], simpleDateFormat.parse(args[3])));
                System.out.println((allPeople.size() - 1));
                break;

            case "-u" :
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if (args[3].equals("м")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                else allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(simpleDateFormat.parse(args[4]));
                break;
            case "-d" :
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                allPeople.get(Integer.parseInt(args[1])).setName("");
                break;
            case "-i" :
                String sex = allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)
                        ? "м" : "ж";
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + sex +
                        " " + simple_Date_Format.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
                break;
        }//start here - начни тут
    }
}