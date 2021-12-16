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
    app.getGroupHelper().createGroup(new GroupData("2", "logo", "test"));//это из GroupHelper теперь
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size() + 1);
  }

}
