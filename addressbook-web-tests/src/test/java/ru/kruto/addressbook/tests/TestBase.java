package ru.kruto.addressbook.tests;

//import org.openqa.selenium.remote.Browser;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.kruto.addressbook.appmanager.ApplicationManager;
import ru.kruto.addressbook.model.ContactData;
import ru.kruto.addressbook.model.Contacts;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME)); // базовый класс Browser.CHROME


    @BeforeSuite(alwaysRun = true) //фикстура до метода
    public void setUp() throws Exception {
        app.init();
    }


    @AfterSuite(alwaysRun = true) //фикстура после метода
    public void tearDown() throws Exception {
        app.stop();
    }
    @BeforeMethod
    public void logTestStart (Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());

    }

    public void verifyContactListInUI() {
        if (Boolean.getBoolean("cVerifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contact().all();
            assertThat(uiContacts, equalTo(dbContacts.stream()
                    .map((c) -> new ContactData().withId(c.getId()).withFirstName(c.getFirstName())
                            .withLastName(c.getLastName()))
                    .collect(Collectors.toSet())));
        }
    }



    public void verifyGroupListInUI() {
        if(Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withGroupName(g.getGroupName()))
                    .collect(Collectors.toSet())));
        }


    }

}
