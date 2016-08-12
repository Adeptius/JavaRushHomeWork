package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* –исуем линии
»спользу€ цикл for вывести на экран:
- горизонтальную линию из 10 восьмЄрок
- вертикальную линию из 10 восьмЄрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 10; i++) {
            System.out.print("8");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("8");
        }

    }
}
