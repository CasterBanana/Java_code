package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;

import java.util.List;

public class DeleteContact extends TestBase {

    @BeforeTest
    public  void ensurePreconditions(){
        if (app.contact().list().size() == 0){
            ContactData contact = new ContactData().withFirstName("Test18").withLastName("Raz").withMobilePhone("2123").witheMail("1231@as.ru");
            app.contact().create(contact);
        }
    }


    @Test (enabled = true)
    public void testDeleteContact() throws Exception {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1 ;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }




}
