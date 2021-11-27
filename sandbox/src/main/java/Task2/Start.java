package Task2;

public class Start {
    public static void main(String[] args){
        Point p1 = new Point(5, 6);
        Point p2 = new Point(8, 10);
        System.out.println("Выводим расчеты из метода класса Point " + p2.distance(p1));
        //System.out.println(p2.y); - таким образом я вызвал поле y из класса Point, оно содержит значение 10
        double str = distance(p1,p2);
        System.out.println("Выводим расчёты через функцию и результат её расчетов равен = " + str);
    }
    public static double distance(Point p1, Point p2){ // Point - Это тип, его надо указывать
        double distance = Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
        return distance;
    }
    }

