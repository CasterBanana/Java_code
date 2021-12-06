package ru.kruto.addressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditingContact extends TestBase {
    private WebDriver wd;


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    @Test
    public void testEditContact() throws Exception {
        editContact("Yakovlev11");
        safeUpdate();
        returnToHomePage();
    }

    private void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void safeUpdate() {
        wd.findElement(By.name("update")).click();
    }

    private void editContact(String editFamily) {
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[6]/td[8]/a/img")).click();
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(editFamily);
    }

    private void login(String login, String password) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();

    }


}