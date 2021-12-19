package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;



public class CreateNewContact extends TestBase {


    @Test
    public void testCreatenewcontact() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initializationNewContact();
        app.getContactHelper().fillInfoNewContact(new ContactData("PepВЫВ1ega", "Kek", "88005553535", "omega_pepega@mail.com"));
        app.getContactHelper().confirmNewContact();
        app.returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before + 1);

    }


}
