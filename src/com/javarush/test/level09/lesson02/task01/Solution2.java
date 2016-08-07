package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution2
{
    public static void main(String[] args) throws Exception {
        long sleepingTime = 1500;

        System.out.println("Method main() in action:\nmain() -->  method1()");
        Thread.sleep(sleepingTime);
        for (int i = 2; i < 5; i++) {
            System.out.println("            method" + i + "()");
            Thread.sleep(sleepingTime);
        }
        System.out.println("            method5() { // Stack Trace }\n");
        Thread.sleep(sleepingTime);
        System.out.println("Stack Trace in action:");

        for (int i = 5; i > 0; i--) {
            System.out.println("method" + i + "();");
            Thread.sleep(sleepingTime);
        }
        System.out.println("main();");
        Thread.sleep(sleepingTime);

        System.out.println("\nCompiling...");
        Thread.sleep(sleepingTime);

        System.out.println("Output: ");
        for (int i = 5; i > 0; i--) {
            System.out.println("method" + i);
        }
        System.out.println("main");
    }
}
