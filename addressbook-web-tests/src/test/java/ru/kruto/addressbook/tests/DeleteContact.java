package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.List;

public class DeleteContact extends TestBase {


    @Test (enabled = true)
    public void testDeleteContact() throws Exception {
        //int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().initializationNewContact();
            app.getContactHelper().fillInfoNewContact(new ContactData("PepВЫВ1ega", "Kek", "88005553535", "omega_pepega@mail.com"));
            app.getContactHelper().confirmNewContact();
            app.returnToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().getAcceptContact(); // подтверждение для всплыващющего окна
        app.getContactHelper().openHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }


}
