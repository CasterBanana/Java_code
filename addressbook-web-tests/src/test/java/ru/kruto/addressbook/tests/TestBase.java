package ru.kruto.addressbook.tests;

//import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.kruto.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;


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


}
