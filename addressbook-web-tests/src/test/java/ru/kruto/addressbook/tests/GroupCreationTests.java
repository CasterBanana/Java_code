package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation()  { // не стоит называть метод, как класс
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("2", "logo", "test"));//это из GroupHelper теперь
    /*app.getGroupHelper().initGroupCreation(); // на всякий случай оставлю старый вариант, когда в тесте описывались шаги
    //вызываем метод fillGroupForm и заполняем значения
    app.getGroupHelper().fillGroupForm(new GroupData("Firefox", "logo", "test"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    //app.stop();*/
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(),before.size() + 1);
  }

}
