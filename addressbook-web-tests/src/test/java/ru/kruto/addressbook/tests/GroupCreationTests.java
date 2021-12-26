package ru.kruto.addressbook.tests;



import org.testng.annotations.Test;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase { // Теперь это наследник класса TestBase


  @Test
  public void testGroupCreation()  { // не стоит называть метод, как класс
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupName("Test1");
    app.group().create(group);//это из GroupHelper теперь
    Groups after = app.group().all();
    assertThat(after.size(),equalTo(before.size() + 1));
    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
