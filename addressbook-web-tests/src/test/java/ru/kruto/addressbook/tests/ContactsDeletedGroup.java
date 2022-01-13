package ru.kruto.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.kruto.addressbook.model.ContactData;
import ru.kruto.addressbook.model.Contacts;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsDeletedGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withGroupName("test1"));
        }
    }

    @Test
    public void testContactDeletedGroup() {

        ContactData addCont = selectedContact();
        Groups before = addCont.getGroups();
        GroupData GroupToAdd = selectGroups(addCont);
        app.contact().deleteContactGroup(addCont, GroupToAdd);

        Contacts contacts = app.db().contacts();
        Groups after = null;
        for(ContactData contact: contacts){
            if (contact.getId() == addCont.getId()){
                after = contact.getGroups();
            }
        }
        assertThat(after, equalTo(before.without(GroupToAdd)));
    }

    public GroupData selectGroups(ContactData contact){
        return contact.getGroups().iterator().next();
    }

    public ContactData selectedContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        int i = contacts.size();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() > 0) {
                return contact;
            }
            if (contact.getGroups().size() == 0) {
                i = i - 1;
            }
        }
        if (i == 0) {
            app.contact().create(new ContactData().withFirstName("C.FirstName").withLastName("C.LastName")
                    .inGroup(groups.iterator().next()));
            Contacts contacts2 = app.db().contacts();
            for (ContactData contact2 : contacts2) {
                if (contact2.getGroups().size() > 0) {
                    return contact2;
                }
            }
            contacts = contacts2;
        }
        return contacts.iterator().next();
    }
    }


