package ru.kruto.addressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteContact extends TestBase {
    private WebDriver wd;


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    @Test
    public void testDeleteContact() throws Exception {
        wd.findElement(By.xpath("//*[@id=\"9\"]")).click();
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
        wd.switchTo().alert().accept();
        wd.findElement(By.linkText("home")).click();
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
