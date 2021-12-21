package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.List;


public class CreateNewContact extends TestBase {


    @Test
    public void testCreatenewcontact() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initializationNewContact();
        app.getContactHelper().fillInfoNewContact(new ContactData("PepВЫВ1ega", "Raz", "2123", "1231@as.ru"));
        app.getContactHelper().confirmNewContact();
        app.returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);

    }


}
