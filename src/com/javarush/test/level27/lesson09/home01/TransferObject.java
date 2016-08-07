package com.javarush.test.level27.lesson09.home01;

import java.util.concurrent.SynchronousQueue;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable
    private final SynchronousQueue<Integer> queue = new SynchronousQueue<>();

    public synchronized int get() {
        if (isValuePresent) {
            System.out.println("Got: " + value);
            isValuePresent = false;
            this.notifyAll();
        } else try { this.wait();} catch (InterruptedException e) {e.printStackTrace();}

        return value;
    }

    public synchronized void put(int value) {
        if (isValuePresent)  try { this.wait();} catch (InterruptedException e) {e.printStackTrace();}
        else {
            this.value = value;
            System.out.println("Put: " + value);
            isValuePresent = true;
            this.notifyAll();
        }
    }
}
