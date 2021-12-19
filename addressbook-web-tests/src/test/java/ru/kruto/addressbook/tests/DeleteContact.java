package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

public class DeleteContact extends TestBase {


    @Test
    public void testDeleteContact() throws Exception {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().initializationNewContact();
            app.getContactHelper().fillInfoNewContact(new ContactData("PepВЫВ1ega", "Kek", "88005553535", "omega_pepega@mail.com"));
            app.getContactHelper().confirmNewContact();
            app.returnToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().getAcceptContact(); // подтверждение для всплыващющего окна
        app.getContactHelper().openHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before - 1);
    }


}
