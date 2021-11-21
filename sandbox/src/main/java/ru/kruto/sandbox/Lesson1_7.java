package ru.kruto.sandbox;

import ru.kruto.sandbox.Square;

public class Lesson1_7 {
    public static void main(String[] args) {
        /*hello("Димоня");
        //hello("Пепега");
        hello("world"); */

        Square s = new Square(5); // вызываем конструктор класса Square, s - объект класса, Square() - конструктор
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь треугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }

    /* public static void hello(String somebody) {
       System.out.println("Hello," + somebody + "!");*/

    }





