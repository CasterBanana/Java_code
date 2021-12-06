package createnewcontact.tests;

import createnewcontact.model.ContactData;
import org.testng.annotations.Test;

public class CreateNewContact extends TestBase {


  @Test
  public void testCreateNewContact() throws Exception {

    app.initNewContact();
    app.fillInfoContact(new ContactData("Sergey", "Family", "88005553535", "omega_pepega@mail.com")); //вызом метода и заполнение данными
    app.submitCreateNewContact();
    app.getHomePage().returnHomePage();
    //wd.findElement(By.linkText("Logout")).click();
  }


}
