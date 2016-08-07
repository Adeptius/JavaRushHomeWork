package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Мой ввод и вывод (если добавить форич на оллПипл)
-c Вова м 26/11/1989 Катя ж 20/03/1991 Костя м 13/10/1887
Вывод:
2
3
4
Иванов Иван м 27-Jan-2016
Петров Петр м 27-Jan-2016
вова м 26-Nov-1989
катя ж 20-Mar-1991
костя м 13-Oct-1887

-u 0 вова м 26/11/1989 1 костя м 13/10/1887
Вывод:
вова м 26-Nov-1989
костя м 13-Oct-1887

-d 0 1
ПринтЛН выдаёт NullPointerException
Ну ведь правильно, потому что там нулами всё заделано.

-i 0 1
Иванов Иван м 27-Jan-2016
Петров Петр м 27-Jan-2016
Иванов Иван м 27-Jan-2016
Петров Петр м 27-Jan-2016
первые 2 выдаёт метод, 2 остальных показывает мой принт тех объектов, что находятся в аррэй

*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simple_Date_Format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    static  int id, numberOfPersons;
    static  Date date;
    static  String name;
    static  Sex sex;

    public  static void main(String[] args) throws ParseException{
        switch (args[0]) {
            case "-c": Create(args); break;
            case "-u": Update(args); break;
            case "-d": Delete(args); break;
            case "-i": Print(args);  break;
        }
    }
    public synchronized static void Create(String[] args) throws ParseException{
        numberOfPersons = (args.length - 1) / 3;
        for (int i = 1; i <= numberOfPersons; i++) {
            date = simpleDateFormat.parse(args[3 * i]);
            sex = ("м".equals(args[(3 * i) - 1]) ? Sex.MALE : Sex.FEMALE);
            name = args[(3 * i) - 2];
            if (sex.equals(Sex.MALE)) allPeople.add(Person.createMale(name, date));
            else allPeople.add(Person.createFemale(name, date));
            System.out.println((allPeople.size() - 1));
        }
    }

    public synchronized static void Update(String[] args) throws ParseException{
        numberOfPersons = (args.length - 1) / 4;
        for (int i = 1; i <= numberOfPersons; i++) {
            date = simpleDateFormat.parse(args[4 * i]);
            sex = (args[(4 * i) - 1].equals("м") ? Sex.MALE : Sex.FEMALE);
            name = args[(4 * i) - 2];
            id = Integer.parseInt(args[(4 * i) - 3]);
            allPeople.get(id).setName(name);
            if (sex.equals(Sex.MALE)) allPeople.get(id).setSex(Sex.MALE);
            else allPeople.get(id).setSex(Sex.FEMALE);
            allPeople.get(id).setBirthDay(date);
        }
    }

    public synchronized static void Delete(String[] args){
        for (int i = 1; i < args.length; i++) {
            id = Integer.parseInt(args[i]);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName("");
        }
    }

    public synchronized static void Print(String[] args){
        for (int i = 1; i < args.length; i++) {
            id = Integer.parseInt(args[i]);
            name = allPeople.get(id).getName();
            String sexx = allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж";
            System.out.println(name + " " + sexx + " " + simple_Date_Format.format(allPeople.get(id).getBirthDay()));
        }
    }
}


