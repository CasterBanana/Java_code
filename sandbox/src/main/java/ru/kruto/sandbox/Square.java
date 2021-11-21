package ru.kruto.sandbox;

public class Square {
    public double l;
    public Square (double l) { // конструктор
        this.l = l;
    }
    public double area () {
        return this.l * this.l;
    }
}
