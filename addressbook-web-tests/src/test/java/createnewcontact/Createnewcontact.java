package createnewcontact;

import java.util.concurrent.TimeUnit;

import createnewcontact.model.ContactData;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewContact {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
   // System.setProperty("webdriver.chrome.driver", "");
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
  public void testCreateNewContact() throws Exception {

    initNewContact();
    fillInfoContact(new ContactData("Name", "Family", "88005553535", "omega_pepega@mail.com")); //вызом метода и заполнение данными
    submitCreateNewContact();
    returnHomePage();
    //wd.findElement(By.linkText("Logout")).click();
  }

  private void returnHomePage() { //для открытия домашней страницы со списком контактов
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitCreateNewContact() { // подтвердить создание нового контакта
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillInfoContact(ContactData contactData) { // заполнение данных контакта
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

  private void initNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }




}
