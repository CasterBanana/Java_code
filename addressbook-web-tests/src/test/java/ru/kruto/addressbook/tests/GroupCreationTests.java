package ru.kruto.addressbook.tests;

import org.testng.annotations.*;
import ru.kruto.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation() throws Exception { // не стоит называть метод, как класс
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Firefox", "logo", "test"));//это из GroupHelper теперь
    /*app.getGroupHelper().initGroupCreation(); // на всякий случай оставлю старый вариант, когда в тесте описывались шаги
    //вызываем метод fillGroupForm и заполняем значения
    app.getGroupHelper().fillGroupForm(new GroupData("Firefox", "logo", "test"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    //app.stop();*/
  }

}
