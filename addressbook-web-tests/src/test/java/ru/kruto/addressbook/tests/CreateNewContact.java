package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;


public class CreateNewContact extends TestBase {


    @Test
    public void testCreatenewcontact() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initializationNewContact();
        ContactData contact = new ContactData("PepВЫВ1ega", "Raz", "2123", "1231@as.ru");
        app.getContactHelper().fillInfoNewContact(contact);
        app.getContactHelper().confirmNewContact();
        app.returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);


        int max = 0;
        for(ContactData c : after)  {
           if (c.getId() > max){
                max = c.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }


}
