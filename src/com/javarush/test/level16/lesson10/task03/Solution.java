package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread tt = new TestThread();
        Thread thread = new Thread(tt);
        thread.start();
        Thread.sleep(1);
        thread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {


        public void run(){
            Thread th = Thread.currentThread();
            while (!th.isInterrupted()){

            }

        }
    }
}
