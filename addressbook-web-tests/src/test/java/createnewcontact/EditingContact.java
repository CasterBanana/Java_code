package createnewcontact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EditingContact {
    private WebDriver wd;


    @BeforeMethod (alwaysRun = true)
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // авторизация
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");

    }
    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }
   @Test
   public void editContact() throws Exception {
        wd.findElement(By.xpath("//*[@id=\"1\"]")).click();
        wd.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[5]/td[8]/a/img")).click();
        wd.findElement(By.name("address")).sendKeys("Kek123");
        wd.findElement(By.name("update")).click();
        wd.findElement(By.linkText("home page")).click();

   }
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }
}
