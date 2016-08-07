package com.javarush.test.level24.lesson14.big01;

public abstract class BaseObject {

    double x;
    double y;
    double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setX(double x)           {this.x = x;          }
    public void setY(double y)           {this.y = y;          }
    public void setRadius(double radius) {this.radius = radius;}

    public double getX()      {return x;     }
    public double getY()      {return y;     }
    public double getRadius() {return radius;}

    abstract void draw(Canvas canvas);
    abstract void move();

    public boolean isIntersec(BaseObject o){
        double x1,x2,y1,y2,r1,r2,maxRad;
        x1 = this.getX();
        y1 = this.getY();
        x2 = o.getX();
        y2 = o.getY();
        double distance =  Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2-y1) * (y2 - y1)));
        r1 = this.getRadius();
        r2 = o.getRadius();
        maxRad = r1 > r2 ? r1 : r2;
        return (distance < maxRad);
    }

    public void checkBorders(double minx, double maxx, double miny, double maxy)
    {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

}
