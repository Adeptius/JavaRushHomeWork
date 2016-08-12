package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Владелец on 01.07.2016.
 */
public class MyThread extends Thread {
    static AtomicInteger integer = new AtomicInteger(1);

    private void setPriority(){
        int priority = integer.getAndIncrement();
        if (priority == 10) integer = new AtomicInteger(1);
        if (this.getThreadGroup()!=null){
            int threadGroupPriority = this.getThreadGroup().getMaxPriority();
            if (threadGroupPriority < priority) this.setPriority(threadGroupPriority);
            else this.setPriority(priority);
        }else this.setPriority(priority);
    }

    public MyThread() {
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }
}
