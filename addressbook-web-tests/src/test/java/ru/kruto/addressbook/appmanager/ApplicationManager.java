package ru.kruto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //protected final ApplicationManager app = new ApplicationManager();
    private ContactHelper contactHelper;
    public WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper; // тут код взаимодействия с тестируемой системой
    private Browser browser;

    public ApplicationManager(Browser browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.CHROME)){
            wd = new ChromeDriver();
        } else if(browser.equals(Browser.FIREFOX)){
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.IE)){
            wd = new InternetExplorerDriver();
        }
        //wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("admin", "secret");

    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
