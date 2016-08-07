package My;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTesting {

    public static Lock lock = new ReentrantLock();
    static volatile int i = 0;

    public static void main(String[] args) {


        //Runnable r1 = () -> System.out.println("Это Runnable с помощью лямбд");

        Thread[] arr = new Thread[10];

        CountDownLatch latch = new CountDownLatch(1);
        //ExecutorService ex = Executors.newCachedThreadPool();
        for (int j = 0; j < 10; j++) {
            Thread r = new Thread(new MyRunnable(latch));
            arr[j] = r;
            r.start();
            //ex.submit(r);

        }
        latch.countDown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < 10; j++) {
            arr[j].interrupt();
        }
    }
    //не потоко безопасное 136379
    // c lock 140000
    // атомик 133724
    static class MyRunnable extends Thread{
        CountDownLatch latch;
        public MyRunnable(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread current = Thread.currentThread();
                latch.await();
                while(!current.isInterrupted()){
                    lock.lock();
                        System.out.println(i++);
                    lock.unlock();

                }
            } catch (InterruptedException e) {
                System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
            }

        }
    }
}
