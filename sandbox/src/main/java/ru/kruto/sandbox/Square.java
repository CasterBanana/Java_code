package ru.kruto.sandbox;

public class Square {
    public double l;// это поле
    public Square (double l) { // реализация конструктора
        this.l = l;
    }
    public double area () { // это метод для расчёта площади, где используется поле l,
        // он стал неразрывен с классом Square
        return this.l * this.l;
    }
}
