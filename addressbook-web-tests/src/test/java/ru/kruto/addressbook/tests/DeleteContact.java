package ru.kruto.addressbook.tests;

import org.testng.annotations.*;

public class DeleteContact extends TestBase {


    @Test
    public void testDeleteContact() throws Exception {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().getAcceptContact(); // подтверждение для всплыващющего окна
        app.getContactHelper().openHome();
    }


}
