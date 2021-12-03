package createnewcontact.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    public WebDriver wd;

    public homePage(WebDriver wd) {
        this.wd = wd;

    }

    public void returnHomePage() { //для открытия домашней страницы со списком контактов
      wd.findElement(By.linkText("home page")).click();
    }
}
