package ru.kruto.sandbox;

import ru.kruto.sandbox.Square;

public class Lesson1_7 {
    public static void main(String[] args) {
        /*hello("Димоня");
        //hello("Пепега");
        hello("world"); */
        //Square azaza = new Square(1);
        Square s = new Square(5); // это обращение к конструктору
        // вызываем конструктор класса Square, s - объект класса, Square() - конструктор
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6 ); // r - объект класса Rectangle
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }

    /* public static void hello(String somebody) {
       System.out.println("Hello," + somebody + "!");*/

    }





