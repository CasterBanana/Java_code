package ru.kruto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.kruto.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {

        super(wd);

    }

    public void confirmNewContact() {
        enter(By.xpath("//div[@id='content']/form/input[21]")); // нижняя кнопка
    }

    public void fillInfoNewContact(ContactData contactData) { //
        fillInformContact(By.name("firstname"), contactData.getFirstName());
        fillInformContact(By.name("lastname"), contactData.getLastName());
        fillInformContact(By.name("mobile"), contactData.geteMail());
        fillInformContact(By.name("email"), contactData.getMobilePhone());
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
        enter(By.linkText("add new"));
    }

    public void safeUpdateContact() {
        enter(By.name("update"));
    }

    public void editContact(String editFamily) {
        fillInformContact(By.name("lastname"), editFamily);
    }

    public void initializationEditContact() { // для редактирования контакта
        enter(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }

    public void selectContact() { // выбора чекбокса на странице контактов
        enter(By.name("selected[]"));
    }

    public void deleteContact() { //для удаления контакта
        enter(By.xpath("//input[@value='Delete']"));
    }

    public void getAcceptContact() { // подтверждение для всплыващющего окна
        wd.switchTo().alert().accept();
    }

    public void openHome() { // открытие главной страницы
        enter(By.linkText("home"));
    }

    public boolean isThereAContact() {
        //return isElementPresent(By.xpath("//*[@id=\"maintable\"]/tbody/tr[7]/td[8]/a/img"));
        return isElementPresent(By.xpath("img[@alt='Edit']"));
        ////img[@alt='Edit'] определял через консоль разработчика
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public boolean isThereAContactCheckBox() { // оставлю для чего-нибудь
        return isElementPresent(By.xpath("//img[@alt='Edit']"));

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
