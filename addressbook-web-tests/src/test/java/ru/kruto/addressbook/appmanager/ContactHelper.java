package ru.kruto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kruto.addressbook.model.ContactData;

public class ContactHelper {
    private WebDriver wd;

    public ContactHelper(WebDriver wd) {
        this.wd = wd;

    }

    public void confirmNewContact() {
        enterCreate(); // нижняя кнопка
    }

    private void enterCreate() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillInfoNewContact(ContactData contactData) { //
        fillInformContact(By.name("firstname"), contactData.getFirstName());
        fillInformContact(By.name("lastname"), contactData.getLastName());
        fillInformContact(By.name("mobile"), contactData.geteMail());
        fillInformContact(By.name("email"), contactData.getMobilePhone());
    }

    private void fillInformContact(By firstname, String text) {
        wd.findElement(firstname).click();
        wd.findElement(firstname).clear();
        wd.findElement(firstname).sendKeys(text);
    }

    /*public void fillInfoNewContact(String name, String family, String email, String phoneNumber) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(name);
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(family);
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(email);
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(phoneNumber);
    } */

    public void initializationNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void safeUpdateContact() {
        wd.findElement(By.name("update")).click();
    }

    public void editContact(String editFamily) {
        fillInformContact(By.name("lastname"), editFamily);
    }

    public void initializationEditContact() {
        wd.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[7]/td[8]/a/img")).click();
    }

    public void selectContact() {
        wd.findElement(By.xpath("//*[@id=\"9\"]")).click(); // для выбора определённого контакта по чекбоксу
    }

    public void deleteContact() { //для удаления контакта
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void getAcceptContact() { // подтверждение для всплыващющего окна
        wd.switchTo().alert().accept();
    }

    public void openHome() { // открытие главной страницы
        wd.findElement(By.linkText("home")).click();
    }
}
