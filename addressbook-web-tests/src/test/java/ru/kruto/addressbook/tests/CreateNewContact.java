package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class CreateNewContact extends TestBase {


    @Test (enabled = false)
    public void testCreatenewcontact() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initializationNewContact();
        ContactData contact = new ContactData("Test18", "Raz", "2123", "1231@as.ru");
        app.getContactHelper().fillInfoNewContact(contact);
        app.getContactHelper().confirmNewContact();
        app.returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);


       /* int max = 0;
        for(ContactData c : after)  {
           if (c.getId() > max){
                max = c.getId();
            }
        } */


       // contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
