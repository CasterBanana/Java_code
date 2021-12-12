package ru.kruto.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.kruto.addressbook.appmanager.ApplicationManager;



public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(Browser.CHROME); // базовый класс


    @BeforeMethod(alwaysRun = true) //фикстура до метода
    public void setUp() throws Exception {
        app.init();
    }


    @AfterMethod(alwaysRun = true) //фикстура после метода
    public void tearDown() throws Exception {
        app.stop();
    }


}
