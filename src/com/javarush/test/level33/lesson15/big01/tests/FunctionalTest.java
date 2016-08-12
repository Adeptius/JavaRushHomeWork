package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){

        String s1 = "строка";
        String s2 = "строка2";
        String s3 = "строка";

        long l1 = shortener.getId(s1);
        long l2 = shortener.getId(s2);
        long l3 = shortener.getId(s3);

        Assert.assertNotEquals(l2, l1);
        Assert.assertNotEquals(l2, l3);
        Assert.assertEquals(l1, l3);

        String t1 = shortener.getString(l1);
        String t2 = shortener.getString(l2);
        String t3 = shortener.getString(l3);

        Assert.assertEquals(s1,t1);
        Assert.assertEquals(s2,t2);
        Assert.assertEquals(s3,t3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
