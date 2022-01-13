package ru.kruto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
       super(wd);
    }

    public void groupPage() {
        click(By.linkText("groups"));
    }

    public void ContactMDPage() {
        if (isElementPresen(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("home")
                && isElementPresen(By.name("Edit"))){
            return;
        }
        click(By.linkText("home"));
    }


}
