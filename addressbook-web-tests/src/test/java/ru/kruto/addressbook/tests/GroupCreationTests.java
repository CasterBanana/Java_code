package ru.kruto.addressbook.tests;

import org.testng.annotations.*;
import ru.kruto.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation() throws Exception { // не стоит называть метод, как класс
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    //вызываем метод fillGroupForm и заполняем значения
    app.getGroupHelper().fillGroupForm(new GroupData("test_recorder", "logo", "test"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    //app.stop();
  }

}
