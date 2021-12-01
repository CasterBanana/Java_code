package ru.kruto.addressbook.tests;

import org.testng.annotations.*;
import ru.kruto.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation() throws Exception { // не стоит называть метод, как класс
    app.gotoGroupPage();
    app.initGroupCreation();
    //вызываем метод fillGroupForm и заполняем значения
    app.fillGroupForm(new GroupData("test_recorder", "logo", "test"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    //app.stop();
  }

}
