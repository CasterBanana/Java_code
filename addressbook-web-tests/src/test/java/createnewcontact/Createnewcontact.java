package createnewcontact;

import createnewcontact.model.ContactData;
import org.testng.annotations.Test;

public class CreateNewContact extends TestBase {


  @Test
  public void testCreateNewContact() throws Exception {

    initNewContact();
    fillInfoContact(new ContactData("Name", "Family", "88005553535", "omega_pepega@mail.com")); //вызом метода и заполнение данными
    submitCreateNewContact();
    returnHomePage();
    //wd.findElement(By.linkText("Logout")).click();
  }


}
