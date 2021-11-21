package ru.kruto.sandbox;

import ru.kruto.sandbox.Square;

public class Lesson1_7 {
    public static void main(String[] args) {
        hello("Димоня");
        hello("Пепега");
        hello("world");
        Square s = new Square(5);
        s.l = 5;
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));
        /* вывод на консоль текста и значения переменной l, далее использовали функцию area,
        где в её параметр ввели значение 5 и это вернуло 25
        */
        // переменные l в mail и area разные, ибо используются только в рамках своих функций из-за ограничений {}
        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь треугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
    }

    public static void hello(String somebody) {
       System.out.println("Hello," + somebody + "!");

    }
    public static double area (Square s) { // создали функцию area с параметром double len
        return s.l * s.l; // в функции вернули значение len, как len * len
    }
    public static double area (Rectangle r) { //создали функцию с двумя параметрами
        return r.a * r.b;
    }

}

