package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Leonid on 19.12.2015.
 */
public interface EventDataRow
{
    EventType getType();
    Date getDate();
    int getTime();
}
