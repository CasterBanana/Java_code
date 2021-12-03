package createnewcontact.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditingContact extends TestBase {



   @Test
   public void editContact() throws Exception {
       initEdit(); // нужно для начала редактирования определенного контакта
       fullContact("Kek123"); // вызвали редактирования адреса
       safeEdit(); // сохранили редактирование
       app.getHomePage().returnHomePage(); // возврат на главную страницу

   }



    private void safeEdit() {
        app.getHomePage().wd.findElement(By.name("update")).click();
    }

    private void fullContact(String adress) {
        app.getHomePage().wd.findElement(By.name("address")).sendKeys(adress);
    }

    private void initEdit() {
        app.getHomePage().wd.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[4]/td[8]/a/img")).click();
    }


}
