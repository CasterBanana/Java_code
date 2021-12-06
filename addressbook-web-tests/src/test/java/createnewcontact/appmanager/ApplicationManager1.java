package createnewcontact.appmanager;

import createnewcontact.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager1 {
    public WebDriver wd;

    private homePage homePage;


    public void init() {
       wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // авторизация
        wd.get("http://localhost/addressbook/");
        homePage = new homePage(wd);
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

    public void stop() {
        wd.quit();
    }

    public void submitCreateNewContact() { // подтвердить создание нового контакта
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillInfoContact(ContactData contactData) { // заполнение данных контакта
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.geteMail());
    }

    public void initNewContact() { // инициализация создания нового контакта
      wd.findElement(By.linkText("add new")).click();
    }

    public void openHome() { // открытие главной страницы
        wd.findElement(By.linkText("home")).click();
    }

    public void getAcceptContact() { // подтверждение для всплыващющего окна
        wd.switchTo().alert().accept();
    }

    public void deleteContact() { //для удаления контакта
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.xpath("//*[@id=\"9\"]")).click(); // для выбора определённого контакта по чекбоксу
    }

    public void returnHomePage() { //для открытия домашней страницы со списком контактов
        wd.findElement(By.linkText("home page")).click();
    }

    public createnewcontact.appmanager.homePage getHomePage() {
        return homePage;
    }
}
