package ru.kruto.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;


public class EditingContact extends TestBase {


    @Test
    public void testEditContact() throws Exception { // что-то неправильно отрабатывает предусловие
        int before = app.getContactHelper().getContactCount();
        if ( app.getContactHelper().isThereAContact()){
            app.getContactHelper().initializationNewContact();
            app.getContactHelper().fillInfoNewContact(new ContactData("PepВЫВ1ega", "Kek", "88005553535", "omega_pepega@mail.com"));
            app.getContactHelper().confirmNewContact();
            app.returnToHomePage();
        }
        app.getContactHelper().initializationEditContact();
        app.getContactHelper().editContact("Oleg12");
        app.getContactHelper().safeUpdateContact();
        app.returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before);
    }


}