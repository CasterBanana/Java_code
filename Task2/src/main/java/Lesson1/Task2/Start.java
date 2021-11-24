package Lesson1.Task2;

public class Start {
    public static void main(String[] args){
        Point p1 = new Point(5, 6);
        Point p2 = new Point(8, 10);
        System.out.println(p2.distance(p1));
        //System.out.println(p2.y); - таким образом я вызвал поле y из класса Point, оно содержит значение 10

    }
}
