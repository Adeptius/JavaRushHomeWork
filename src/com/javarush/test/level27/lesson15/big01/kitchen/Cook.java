package com.javarush.test.level27.lesson15.big01.kitchen;
import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Leonid on 17.12.2015.
 * 1. Создадим класс Cook(Повар) в пакете kitchen, он будет готовить. Пусть в конструкторе приходит его имя, которое выводится методом toString.

 2. Tablet создает заказы, а Cook их обрабатывает. Расставьте правильно Observer и Observable между Tablet и Cook.

 3. Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.
 -observable - объект, который отправил нам значение
 -arg - само значение, в нашем случае - это объект Order
 На данном этапе мы сымитируем обработку и выведем в консоль "Start cooking - " + order
 Что мы имеем? Повар приготовил блюда, пора их уносить, а официант не знает об этом.
 Нужно уведомить официанта, что пора забирать заказ с кухни.
 Ситуация аналогична предыдущему заданию, поэтому снова будем использовать паттерн Observer.

 1. Создадим класс Waitor(Официант) в пакете kitchen, он будет относить заказы назад к столику. Официант будет безымянный.

 2. Cook(Повар) готовит заказы, а Waitor их обрабатывает. Расставьте правильно Observer и Observable между Waitor и Cook.

 3. Метод void update пусть выведет в консоль следующее:
 order + " was cooked by " + cook

 4. В классе-Observable перед отправкой заказа сделаем следующее:
 4.1. Установим флаг setChanged()
 4.2. Отправим обсерверу заказ notifyObservers(order);
 */
public class Cook extends Observable implements Observer
{
    private String name;

    public Cook (String name)
    {
        this.name = name;
    }
    @Override
    public String toString ()
    {
        return name;
    }

    @Override
    /*
     2.4. Добавим нашему повару вывод в консоль этой информации. Пусть теперь выводится аналогичное сообщение:
 Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
     */
    public void update(Observable o, Object arg)
    {

            Order order = (Order) arg;
            ConsoleHelper.writeMessage("Start cooking - " + order.toString() + ", cooking time "+ order.getTotalCookingTime()+"min");
            StatisticManager.getInstance().register(new CookedOrderEventDataRow( o.toString (), this.toString(), order.getTotalCookingTime()*60,order.getDishes() ));
           setChanged();
            notifyObservers(arg);


    }
}
