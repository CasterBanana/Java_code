package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.kruto.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation()  { // не стоит называть метод, как класс
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withGroupName("Test1");
    app.group().create(group);//это из GroupHelper теперь
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size() + 1);


    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before ,after);
  }

}
