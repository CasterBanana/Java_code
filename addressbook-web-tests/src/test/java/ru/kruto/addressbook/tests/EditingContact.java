package ru.kruto.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class EditingContact extends TestBase {

    @BeforeTest
    public  void ensurePreconditions(){
        if (app.contact().list().size() == 0){
            ContactData contact = new ContactData().withFirstName("Test18").withLastName("Raz").withMobilePhone("2123").witheMail("1231@as.ru");
            app.contact().create(contact);
        }
    }


    @Test (enabled = true)
    public void testEditContact() throws Exception { // что-то неправильно отрабатывает предусловие

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId())
                .withFirstName("Test18").withLastName("Raz").withMobilePhone("2123").witheMail("1231@as.ru");
        app.contact().mofify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size());



        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }




}