package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    int left, top, widht, height;
    //Rectangle rectangle = new Rectangle();

    public Rectangle(int left, int top, int widht, int height)
    {
        this.left = left;
        this.top = top;
        this.widht = widht;
        this.height = height;
    }

    public Rectangle(int left, int top)
    {
        this.left = left;
        this.top = top;
        this.height = 0;
        this.widht = 0;
    }

    public Rectangle(int left, int top, int widht)
    {
        this.height = this.widht;
        this.left = left;
        this.top = top;
        this.widht = widht;
    }

   // public Rectangle(Rectangle rect)
   // {
   //     this.rectangle = rect;
   // }
}
