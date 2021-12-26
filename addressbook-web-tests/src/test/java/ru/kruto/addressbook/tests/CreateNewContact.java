package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;


public class CreateNewContact extends TestBase {


    @Test (enabled = true)
    public void testCreatenewcontact() throws Exception {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstName("Test18").withLastName("Raz").withMobilePhone("2123").witheMail("1231@as.ru");//("Test18", "Raz", "2123", "1231@as.ru")
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }




}
