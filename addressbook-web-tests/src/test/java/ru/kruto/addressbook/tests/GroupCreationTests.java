package ru.kruto.addressbook.tests;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase

  @DataProvider
  public Iterator<Object[]> validGroups () {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withGroupName("test1").withGroupHeader("header 1").withGroupFooter("footer 1")});
    list.add(new Object[] {new GroupData().withGroupName("test2").withGroupHeader("header 2").withGroupFooter("footer 2")});
    list.add(new Object[] {new GroupData().withGroupName("test3").withGroupHeader("header 3").withGroupFooter("footer 3")});
    return list.iterator();
  }



  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group)  { // не стоит называть метод, как класс
    app.goTo().groupPage();
    Groups before = app.group().all();

    app.group().create(group);//это из GroupHelper теперь
    assertThat(app.group().count(),equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
  /*@Test
  public void testBadGroupCreation()  { // не стоит называть метод, как класс
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupName("Test1");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before));
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size()));


  }*/



}
