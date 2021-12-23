package ru.kruto.addressbook.tests;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class EditingContact extends TestBase {


    @Test (enabled = false)
    public void testEditContact() throws Exception { // что-то неправильно отрабатывает предусловие
        if ( app.getContactHelper().isThereAContact()){
            app.getContactHelper().initializationNewContact();
            app.getContactHelper().fillInfoNewContact(new ContactData("Раз", "Kek", "88005553535", "omega_pepega@mail.com"));
            app.getContactHelper().confirmNewContact();
            app.returnToHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initializationEditContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"omg", "мнеплохояхочуболи", "omg", "omg");
        app.getContactHelper().editContact(contact);
        app.getContactHelper().safeUpdateContact();
        app.returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
        //Assert.assertEquals(new HashSet<>(after), new HashSet<>(before)); // старый вариант
    }


}