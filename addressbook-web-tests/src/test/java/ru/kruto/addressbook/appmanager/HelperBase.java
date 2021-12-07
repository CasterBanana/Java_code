package ru.kruto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver wd;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void enter(By locator) {
        wd.findElement(locator).click();
    }

    protected void fillInformContact(By firstname, String text) {
        enter(firstname);
        wd.findElement(firstname).clear();
        wd.findElement(firstname).sendKeys(text);
    }
}
