package createnewcontact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EditingContact extends TestBase {



   @Test
   public void editContact() throws Exception {
       initEdit(); // нужно для начала редактирования определенного контакта
       fullContact("Kek123"); // вызвали редактирования адреса
       safeEdit(); // сохранили редактирование
       returnHomePage(); // возврат на главную страницу

   }



    private void safeEdit() {
        wd.findElement(By.name("update")).click();
    }

    private void fullContact(String adress) {
        wd.findElement(By.name("address")).sendKeys(adress);
    }

    private void initEdit() {
        wd.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[4]/td[8]/a/img")).click();
    }


}
