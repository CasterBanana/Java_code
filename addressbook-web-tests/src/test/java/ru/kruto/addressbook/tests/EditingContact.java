package ru.kruto.addressbook.tests;
import org.testng.annotations.*;





public class EditingContact extends TestBase {


    @Test
    public void testEditContact() throws Exception {
        app.getContactHelper().initializationEditContact();
        app.getContactHelper().editContact("Oleg");
        app.getContactHelper().safeUpdateContact();
        app.returnToHomePage();
    }


}