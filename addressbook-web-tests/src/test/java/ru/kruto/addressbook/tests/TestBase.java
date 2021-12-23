package ru.kruto.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.kruto.addressbook.appmanager.ApplicationManager;



public class TestBase {
    protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME); // базовый класс


    @BeforeSuite(alwaysRun = true) //фикстура до метода
    public void setUp() throws Exception {
        app.init();
    }


    @AfterSuite(alwaysRun = true) //фикстура после метода
    public void tearDown() throws Exception {
        app.stop();
    }


}
