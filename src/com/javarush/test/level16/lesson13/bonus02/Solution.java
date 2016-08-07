package com.javarush.test.level16.lesson13.bonus02;
import java.io.*;
import java.util.*;
/* Клубок
    1. Создай 5 различных своих нитей c отличным от Thread типом:
    1.1. нить 1 должна бесконечно выполняться;
    1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
    1.3. нить 3 должна каждые полсекунды выводить "Ура";
    1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
    1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
    2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
    3. Нити не должны стартовать автоматически.
*/
public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new Eternal());
        threads.add(new InterEx());
        threads.add(new Ura());
        threads.add(new MessageImpl());
        threads.add(new Sum());
    }
    public static class Eternal extends Thread {
        public void run() {
            while (true) {}
        }
    }
    public static class InterEx extends Thread {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Ura extends Thread {
        public void run(){
            try {
                while (!isInterrupted()){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (Exception e) {
            }
        }
    }
    public static class MessageImpl extends Thread implements  Message {
        public void showWarning(){
            try{
                this.interrupt();
                this.join();
            } catch (Exception e) {}
        }
        public void run() {
            while (!(this.isInterrupted())){
            }
            return;
        }
    }
    public static class Sum extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        public void run() {
            try {
                String line = reader.readLine();
                int sum = 0;
                while (!line.equals("N")){
                    sum += Integer.parseInt(line);
                    line = reader.readLine();
                }
                System.out.println(sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // может тут в файнали закрыть ридэр?
        }
    }
}