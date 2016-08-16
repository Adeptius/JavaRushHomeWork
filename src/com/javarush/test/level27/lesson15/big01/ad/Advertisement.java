package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Leonid on 19.12.2015.

 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0)
            amountPerOneDisplaying = (long) (initialAmount * 1.0 / hits);
    }

    public int getHits()
    {
        return hits;
    }

    /*
        2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
    2.5.1. кидать UnsupportedOperationException, если количество показов не положительное число
    2.5.2. уменьшать количество показов
    2.6. Для каждого показанного рекламного ролика пересчитать его данные вызвав метод revalidate() у объекта класса Advertisement.

         */
    public void revalidate() throws UnsupportedOperationException
    {

        if (hits<=0)
            throw new UnsupportedOperationException();
        hits --;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }
}
