package com.javarush.test.level25.lesson07.home01;

import com.sun.org.apache.xpath.internal.SourceTree;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread thread;
    String threadName;


    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                //Thread.sleep(0); // выкинет InterruptedException в случае forth.
                System.out.println(threadName);
                Thread.sleep(100); // Метод научного тыка, пробовал и другие числа.
            }
        } catch (InterruptedException e) {}

    }
}
