package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;


/**
 * Created by Leonid on 20.12.2015.


 4. В StatisticManager создайте метод (придумать самостоятельно), который из хранилища достанет все данные,
 относящиеся к работе повара, и посчитает общую продолжительность работы для каждого повара отдельно.

 Реализуем логику метода printCookWorkloading в классе DirectorTablet.
 Используя метод из предыдущего пункта вывести в консоль в убывающем порядке даты, имена поваров и время работы в минутах (округлить в большую сторону).
 Для каждой даты из хранилища событий, для которой есть запись о работе повара, должна выводится продолжительность работы в минутах для этой даты.
 Если повар не работал в какой-то из дней, то с пустыми данными его НЕ выводить (см. 13-May-2013)
 Поваров сортировать по имени
 Пример:
 14-May-2013
 Ivanov - 60 min
 Petrov - 35 min

 13-May-2013
 Ivanov - 129 min

 12-May-2013
 Ivanov - 6 min
 Petrov - 5 min
 */
public class DirectorTablet
{

    public void printAdvertisementProfit() {
        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().getAdvertisementProfit();
        BigDecimal totalProfit = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            BigDecimal profit = new BigDecimal(entry.getValue()).setScale(2, RoundingMode.HALF_UP);
            ConsoleHelper.writeMessage(String.format(
                    "%1$td-%1$tb-%1$TY - %2$.2f",
                    entry.getKey(),
                    profit.doubleValue()
            ));
            totalProfit = totalProfit.add(profit);
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalProfit.doubleValue()));
        ConsoleHelper.writeMessage("");
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloading = StatisticManager.getInstance().getCookWorkloading();
        boolean firstrow = true;
        for (Map.Entry<Date, Map<String, Integer>> entry : cookWorkloading.entrySet()) {
            if (!firstrow) ConsoleHelper.writeMessage("");
            firstrow = false;
            ConsoleHelper.writeMessage(String.format(
                    "%1$td-%1$tb-%1$TY",
                    entry.getKey()
            ));
            Map<String, Integer> nameLoadMap = entry.getValue();
            for (Map.Entry<String, Integer> nameLoadEntry : nameLoadMap.entrySet()) {
                ConsoleHelper.writeMessage(String.format(
                        "%s - %d min",
                        nameLoadEntry.getKey(),
                        nameLoadEntry.getValue()
                ));
            }
        }
    }




    public void printActiveVideoSet()
    {

    }
    public void printArchivedVideoSet()
    {

    }
}
