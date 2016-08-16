package com.javarush.test.level27.lesson15.big01.statistic;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Created by Leonid on 19.12.2015.
 еализуем второй пункт статистики - загрузка (рабочее время) повара, сгруппировать по дням

 4. В StatisticManager создайте метод (придумать самостоятельно), который из хранилища достанет все данные,
 относящиеся к работе повара, и посчитает общую продолжительность работы для каждого покара отдельно.

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

 5. Убедитесь, что рекурсия не набирает видео, показы которых уже закончены.
 */
public class StatisticManager
{
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage  statisticStorage= new StatisticStorage();
    private Set<Cook> set = new HashSet<>();
    private StatisticManager()
    {

    }
    private Date getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        GregorianCalendar g = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        return g.getTime();
    }

    private class ComparatorDate implements Comparator<Date> {
        @Override
        public int compare(Date o1, Date o2) {
            return o2.compareTo(o1);
        }
    }
    public Map<Date, Double> getAdvertisementProfit() {
        Map<Date, Double> resultMap = new TreeMap<>(new ComparatorDate());
        List<EventDataRow> listEvent = statisticStorage.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow v : listEvent) {
            if (listEvent == null) continue;
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) v;
            Date date = getDay(videoEvent.getDate());
            long amount = videoEvent.getAmount();
            if (amount==0) continue;
            double profit = amount * 1d / 100d;
            if (resultMap.containsKey(date)) {
                profit += resultMap.get(date);
            }
            resultMap.put(date, profit);
        }
        return resultMap;
    }
    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        List<EventDataRow> eventDataRows = statisticStorage.get(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> result = new TreeMap<>(new ComparatorDate());
        for (EventDataRow eventDataRow : eventDataRows) {
            if (eventDataRow == null) continue;
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) eventDataRow;
            Map<String, Integer> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            Date date = getDay(cookEvent.getDate());
            int workTime = cookEvent.getTime();
            if (workTime == 0) continue;
            workTime = (workTime + 59) / 60;
            String cookName = cookEvent.getCookName();
            if (result.containsKey(date)) {
                treeMap = result.get(date);
                if (treeMap.containsKey(cookName)) {
                    workTime += treeMap.get(cookName);
                }
            }
            treeMap.put(cookName, workTime);
            result.put(date, treeMap);
        }
        return result;
    }

    public static StatisticManager getInstance ()
    {
        return instance;
    }

    public void register (Cook cook)
    {
        set.add(cook);
    }


    public void register (EventDataRow data)
    {
        statisticStorage.put(data);
    }



    private final static class StatisticStorage
    {
        private Map <EventType, List<EventDataRow>> eventTypeListMap= new HashMap();

        public Map<EventType, List<EventDataRow>> getEventTypeListMap()
        {
            return eventTypeListMap;
        }

        private List<EventDataRow> get(EventType eventType) {
            return eventTypeListMap.get(eventType);
        }
        private void  put (EventDataRow data)
        {
            eventTypeListMap.get(data.getType()).add(data);
        }

        private StatisticStorage ()
        {

            for (EventType  typeForMap : EventType.values())
            {
                eventTypeListMap.put (typeForMap, new ArrayList<EventDataRow>());
            }
        }


    }
}
