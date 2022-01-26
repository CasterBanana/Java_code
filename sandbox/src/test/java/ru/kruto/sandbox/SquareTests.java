package ru.kruto.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test // аннотация её пишем либо @test, либо org.testng.annotations.Test, но в таком случае импорт не делается
    public void testArea() { // у этого тестового метода нет никакого возвращаемого результата
        // и параметров, а результат сообщает тестовому фреймворку
        Square s = new Square(5);
        assert s.area() == 25;
        //Assert.assertEquals(s.area(),25);
        Assert.assertNotEquals(s.area(),24);

    }
}
