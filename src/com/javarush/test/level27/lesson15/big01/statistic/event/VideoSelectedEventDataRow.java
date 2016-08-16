package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by Leonid on 19.12.2015.
 * totalDuration - время приготовления заказа в секундах
 2.3. VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
 optimalVideoSet - список видео-роликов, отобранных для показа
 amount - сумма денег в копейках
 totalDuration - общая продолжительность показа отобранных рекламных роликов
 3. В классы, созданные в п.2., добавьте поле Date currentDate, которое проинициализируйте в конструкторе текущей датой.
 */
public class VideoSelectedEventDataRow implements EventDataRow
{
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow (List<Advertisement> optimalVideoSet, long amount, int totalDuration)
    {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public EventType getType()
    {
        return EventType.SELECTED_VIDEOS;
    }

    public long getAmount()
    {
        return amount;
    }

    @Override
    public Date getDate()

    {
        return currentDate;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }
}
