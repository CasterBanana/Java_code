package ru.kruto.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.kruto.addressbook.model.ContactData;
import ru.kruto.addressbook.model.Contacts;
import ru.kruto.addressbook.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class CreateNewContact extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContactsFromXml () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.xml")));
        String xml = "";
        String line =  reader.readLine();
        while(line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.json")));
        String json = "";
        String line =  reader.readLine();
        while(line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json,new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

    }




    @Test (enabled = true, dataProvider = "validContactsFromXml")
    public void testCreatenewcontact(ContactData contact) throws Exception {
        Contacts before = app.contact().all();
        //File photo = new File("src/test/resources/pngwing.png");
        /*ContactData contact = new ContactData()// убрать
                .withFirstName("Test18").withLastName("Raz").withMobilePhone("2123").witheMail("1231@as.ru");//.withPhoto(photo);//("Test18", "Raz", "2123", "1231@as.ru")*/
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(),equalTo(before.size() + 1));

        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }




}
