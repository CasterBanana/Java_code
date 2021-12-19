package ru.kruto.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;


public class EditingContact extends TestBase {


    @Test
    public void testEditContact() throws Exception { // что-то неправильно отрабатывает предусловие
        if ( app.getContactHelper().isThereAContact()){
            app.getContactHelper().initializationNewContact();
            app.getContactHelper().fillInfoNewContact(new ContactData("PepВЫВ1ega", "Kek", "88005553535", "omega_pepega@mail.com"));
            app.getContactHelper().confirmNewContact();
            app.returnToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initializationEditContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Oleg12");
        app.getContactHelper().editContact(contact);
        app.getContactHelper().safeUpdateContact();
        app.returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }


}