public class Lesson1_7 {
    public static void main(String[] args) {
        hello("Димоня");
        hello("Пепега");
        hello("world");
        double l = 5; // Объявили переменную типа double и проинициализировали со значением 5
        System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));
        /* вывод на консоль текста и значения переменной l, далее использовали функцию area,
        где в её параметр ввели значение 5 и это вернуло 25
        */
        // переменные l в mail и area разные, ибо используются только в рамках своих функций из-за ограничений {}
        double a = 4;
        double b = 6;
        System.out.println("Площадь треугольника со сторонами " + a + " и " + b + " = " + area(a,b));/*тянем функцию
        с двумя параметрами */
    }

    public static void hello(String somebody) {
       System.out.println("Hello," + somebody + "!");

    }
    public static double area (double len) { // создали функцию area с параметром double len
        return len * len; // в функции вернули значение len, как len * len
    }
    public static double area (double a, double b) { //создали функцию с двумя параметрами
        return a * b;
    }

}
