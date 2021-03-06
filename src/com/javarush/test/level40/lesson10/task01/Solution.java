package com.javarush.test.level40.lesson10.task01;

/* Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответсвии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1
AM или PM: 1
Часы: 3
Часы дня: 15
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 2
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 3
Год: 2014
Эра: 1

3) Для "17:33:40":
AM или PM: 1
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.M.yyyy HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("dd.M.yyyy");
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm:ss");
        StringBuilder result = new StringBuilder("");
        try {
            calendar.setTime(format1.parse(date));
            result.append("День: " + calendar.get(Calendar.DAY_OF_MONTH)).append("\n");
            result.append("День недели: " + calendar.get(Calendar.DAY_OF_WEEK)).append("\n");
            result.append("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH)).append("\n");
            result.append("День года: " + calendar.get(Calendar.DAY_OF_YEAR)).append("\n");
            result.append("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH)).append("\n");
            result.append("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR)).append("\n");
            result.append("Месяц: " + calendar.get(Calendar.MONTH)).append("\n");
            result.append("Год: " + calendar.get(Calendar.YEAR)).append("\n");
            result.append("Эра: " + calendar.get(Calendar.ERA)).append("\n");
            result.append("AM или PM: " + calendar.get(Calendar.AM_PM)).append("\n");
            result.append("Часы: " + calendar.get(Calendar.HOUR)).append("\n");
            result.append("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY)).append("\n");
            result.append("Минуты: " + calendar.get(Calendar.MINUTE)).append("\n");
            result.append("Секунды: " + calendar.get(Calendar.SECOND));
            System.out.print(result.toString());
            return;
        } catch (ParseException ignored) {}

        try {
            calendar.setTime(format2.parse(date));
            result.append("День: " + calendar.get(Calendar.DAY_OF_MONTH)).append("\n");
            result.append("День недели: " + calendar.get(Calendar.DAY_OF_WEEK)).append("\n");
            result.append("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH)).append("\n");
            result.append("День года: " + calendar.get(Calendar.DAY_OF_YEAR)).append("\n");
            result.append("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH)).append("\n");
            result.append("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR)).append("\n");
            result.append("Месяц: " + calendar.get(Calendar.MONTH)).append("\n");
            result.append("Год: " + calendar.get(Calendar.YEAR)).append("\n");
            result.append("Эра: " + calendar.get(Calendar.ERA)).append("\n");
            System.out.print(result.toString());
            return;
        } catch (ParseException ignored) {}

        try {
            calendar.setTime(format3.parse(date));
            result.append("AM или PM: " + calendar.get(Calendar.AM_PM)).append("\n");
            result.append("Часы: " + calendar.get(Calendar.HOUR)).append("\n");
            result.append("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY)).append("\n");
            result.append("Минуты: " + calendar.get(Calendar.MINUTE)).append("\n");
            result.append("Секунды: " + calendar.get(Calendar.SECOND));
            System.out.print(result.toString());
            return;
        } catch (ParseException ignored) {}
    }
}
