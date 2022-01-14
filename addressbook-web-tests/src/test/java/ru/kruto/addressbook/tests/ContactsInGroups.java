package ru.kruto.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.kruto.addressbook.model.ContactData;
import ru.kruto.addressbook.model.Contacts;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;

import java.util.HashSet;

public class ContactsInGroups extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withGroupName("test1"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().ContactMDPage();
            app.contact().create(new ContactData()
                    .withFirstName("Test18")
                    .withLastName("Raz")
                    .withMobilePhone("2123")
                    .witheMail("1231@as.ru"));

        }
    }

    @Test
    public void testContactInGroups() {
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        ContactData modifyedContact = selectedContact();
        app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
        Contacts after = app.db().contacts();

        int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        modifyedContact.setId(max);
        before.add(modifyedContact);
        

    }
    public ContactData selectedContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            } else if (contact.getGroups().size() > groups.size()) {
                Contacts contacts2 = app.db().contacts();
                for (ContactData contact2 : contacts2) {
                    selectedContact();
                    ContactData modifyedContact = selectedContact();
                    app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
                    return contact2;
                }
            } else if ((contact.getGroups().size() == groups.size())) {
                app.goTo().groupPage();
                app.group().create(new GroupData().withGroupName("G.Name").withGroupHeader("G.Header").withGroupFooter("G.Footer"));
                app.goTo().ContactMDPage();
                selectedContact();
                ContactData modifyedContact = selectedContact();
                app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
            }
        }
        return contacts.iterator().next();
    }

    }

