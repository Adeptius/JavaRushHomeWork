package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(reader.readLine());
        int max = Integer.parseInt(reader.readLine());

        if (min > max){ int temp = min; min = max; max = temp;}

        int NOD = min;

        for (int i = min; !(min%i==0 && max%i==0); i--) { NOD = i-1; }

        //Это тоже работает:
        //int i = min;
        //while (i>0){
        //    if (min%i==0 && max%i==0){
        //        NOD = i;
        //        break;
        //    } i--;
        //}

        System.out.println(NOD);


    }
}