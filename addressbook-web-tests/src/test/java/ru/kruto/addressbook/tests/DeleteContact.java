package ru.kruto.addressbook.tests;

import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;
import ru.kruto.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class DeleteContact extends TestBase {

    @BeforeTest
    public  void ensurePreconditions(){
        if (app.db().contacts().size() == 0){
            ContactData contact = new ContactData().withFirstName("Test18").withLastName("Raz").withMobilePhone("2123").witheMail("1231@as.ru");
            app.contact().create(contact);
        }
    }


    @Test (enabled = true)
    public void testDeleteContact() throws Exception {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.contact().openHome();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        //assertEquals(after.size(),before.size() - 1);

        assertThat(after, equalTo(before.without(deletedContact)));



    }




}
