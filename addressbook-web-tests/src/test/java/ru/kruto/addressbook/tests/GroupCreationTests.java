package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation()  { // не стоит называть метод, как класс
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("Test2", null, null);
    app.group().create(group);//это из GroupHelper теперь
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(),before.size() + 1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before ,after);
  }

}
