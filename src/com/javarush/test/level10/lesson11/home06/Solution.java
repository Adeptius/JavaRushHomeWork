package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String a, b, c;
        int d, e, f;

        Human(String a){
            this.a = a;
        }
        Human(String a, String b){
            this.a = a;
            this.b = b;
        }
        Human(String a, String b, String c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        Human(String a, String b, String c, int d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        Human(String a, String b, String c, int d, int e){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        Human(String a, String b, String c, int d, int e, int f){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        Human(int d){
           this.d = d;
        }
        Human(int d, int e){
            this.d = d;
            this.e = e;
        }

        Human(int d, int e, int f){
            this.d = d;
            this.e = e;
            this.f = f;
        }
        Human(String a, int d){
            this.a = a;
            this.d = d;
        }
    }
}
