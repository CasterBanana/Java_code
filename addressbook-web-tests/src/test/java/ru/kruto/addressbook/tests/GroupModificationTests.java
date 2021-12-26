package ru.kruto.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;



import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
     public  void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withGroupName("test3"));
        }
    }

    @Test
    public void testGroupModification() {
       Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withGroupName("Test1").withGroupHeader("Test2").withGroupFooter("Test3");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(),before.size());

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}
