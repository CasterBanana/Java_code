package ru.kruto.addressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class CreateNewContact extends TestBase {
    private WebDriver wd;


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    @Test
    public void testCreatenewcontact() throws Exception {

        initializationNewContact();
        fillInfoNewContact("Name", "Family", "88005553535", "omega_pepega@mail.com");
        confirmNewContact();
        openHomePage();

    }

    private void openHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void confirmNewContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillInfoNewContact(String name, String family, String email, String phoneNumber) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(name);
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(family);
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(email);
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(phoneNumber);
    }

    private void initializationNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void login(String login, String password) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();

    }


}
