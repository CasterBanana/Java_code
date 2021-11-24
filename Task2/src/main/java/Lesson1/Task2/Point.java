package Lesson1.Task2;
import java.lang.Math.*;



public class Point {
    public double x;
    public double y;

    public Point (double x, double y){ //конструктор
      this.x = x; // определили, что поле x = параметру конструктора x
      this.y = y; // определили, что поле y = параметру конструктора y
    }

    public double distance(Point p2){ // дистанция от второй точки до первой
        double distance = Math.sqrt((p2.x-this.x)*(p2.x-this.x)+(p2.y-this.y)*(p2.y-this.y)); //формула расчёта
        return distance;
    }
}

