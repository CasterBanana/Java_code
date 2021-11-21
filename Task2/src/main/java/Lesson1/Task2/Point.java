package Lesson1.Task2;
import java.lang.Math.*;



public class Point {
    public double x;
    public double y;

    public Point (double x, double y){ //
      this.x = x;
      this.y = y;
    }

    public double distance(Point p2){ // дистанция от текущей до другой
        double distance = Math.sqrt((p2.x-this.x)*(p2.x-this.x)+(p2.y-this.y)*(p2.y-this.y));
        return distance;
    }
}

