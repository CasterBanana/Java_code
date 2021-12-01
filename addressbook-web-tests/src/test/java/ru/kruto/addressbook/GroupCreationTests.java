package ru.kruto.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation() throws Exception { // не стоит называть метод, как класс
    gotoGroupPage();
    initGroupCreation();
    //вызываем метод fillGroupForm и заполняем значения
    fillGroupForm(new GroupData("test_recorder", "logo", "test"));
    submitGroupCreation();
    returnToGroupPage();
    wd.findElement(By.linkText("Logout")).click();
  }

}
