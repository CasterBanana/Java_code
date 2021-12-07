package ru.kruto.addressbook.tests;

import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;
import ru.kruto.addressbook.model.GroupData;


public class CreateNewContact extends TestBase {


    @Test
    public void testCreatenewcontact() throws Exception {

        app.getContactHelper().initializationNewContact();
        app.getContactHelper().fillInfoNewContact(new ContactData("What", "Test", "88005553535", "omega_pepega@mail.com"));
        app.getContactHelper().confirmNewContact();
        app.returnToHomePage();

    }


}
