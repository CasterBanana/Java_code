package ru.kruto.sandbox;

public class Rectangle {
    public double a;
    public double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double area () { //создали функцию с двумя параметрами
        return this.a * this.b;
    }

}
