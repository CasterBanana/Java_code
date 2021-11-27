package ru.kruto.sandbox;

import Task2.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(8, 10);
        //assert p2.distance(p1) == 5;
        Assert.assertEquals(p2.distance(p1), 5); // ожидаем, что выдаст 5 и он выдал 5
 
    }

    @Test
    public void testDistanceUnvalid() {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(8, 10);
        //assert p2.distance(p1) == 5;
        //Assert.assertEquals(p2.distance(p1), 4); // ожидаем, что выдаст 4, но выдал 5 и вывел результат как раз
        Assert.assertNotEquals(p2.distance(p1),4);
    }
}
