package ru.kruto.sandbox;

public class Rectangle {
    public double a;
    public double b;

    public Rectangle(double a, double b){ // а это реализация конструктора
        this.a = a;
        this.b = b;
    }
    public double area () { //это метод
        return this.a * this.b;
    }

}
