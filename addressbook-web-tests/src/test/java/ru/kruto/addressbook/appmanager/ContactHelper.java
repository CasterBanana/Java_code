package ru.kruto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.kruto.addressbook.model.ContactData;
import org.openqa.selenium.NoSuchElementException;
import ru.kruto.addressbook.model.Contacts;
import ru.kruto.addressbook.model.GroupData;
import ru.kruto.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void initializationNewContact() {
        enter(By.linkText("add new"));
    }

    public void create(ContactData contact) {
        initializationNewContact();
        fillInfoNewContact(contact);
        confirmNewContact();
        contactCache = null;
        returnToHomePage();
    }

    public void mofify(ContactData contact) {
        initializationEditContactById(contact.getId());
        editContact(contact);
        safeUpdateContact();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteButton();
        getAcceptContact(); // подтверждение для всплыващющего окна
        contactCache = null;
        openHome();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteButton();
        getAcceptContact(); // подтверждение для всплыващющего окна
        openHome();
    }




    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void safeUpdateContact() {
        enter(By.name("update"));
    }

    public void editContact(ContactData contactData) {
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("email"), contactData.geteMail());
        type(By.name("mobile"), contactData.getMobilePhone());
        //fillInformContact(By.name("lastname"), editFamily);
    }



    public void initializationEditContactById(int id) { // для редактирования контакта
        //enter(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
        // wd.findElements(By.xpath("img[@alt='Edit']")).get(index).click();
        //enter (By.xpath("img[@alt='Edit']")); // оставлю, если не будет работать выше
    }



    public void initializationEditContact(int index) { // для редактирования контакта
        //enter(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
        // wd.findElements(By.xpath("img[@alt='Edit']")).get(index).click();
        //enter (By.xpath("img[@alt='Edit']")); // оставлю, если не будет работать выше
    }

    public void selectContact(int index) { // выбора чекбокса на странице контактов
        wd.findElements(By.name("selected[]")).get(index).click();
        //enter(By.name("selected[]")); // оставлю на всякий тоже
    }

    public void selectContactById(int id) { // выбора чекбокса на странице контактов
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        //enter(By.name("selected[]")); // оставлю на всякий тоже
    }



    public void deleteButton() { //для удаления контакта
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
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
        ////img[@alt='Edit'] определял через консоль разработчика
    }

    private boolean isElementPresent(By xpath) {
        try {
            wd.findElement(xpath);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isThereAContactCheckBox() { // оставлю для чего-нибудь
        return isElementPresent(By.xpath("//img[@alt='Edit']"));

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement element : elements){
            //String firstName = element.getText();
            List<WebElement> tds = element.findElements(By.xpath(".//td"));
            String firstName = tds.get(2).getText();
            String lastName = tds.get(1).getText();
            //String firstName = element.findElement(By.xpath("//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //String lastName = element.findElement(By.xpath("//td[2]")).getText();
            String mobilePhone = element.findElement(By.xpath("//td[6]")).getText();
            String eMail = element.findElement(By.tagName("a")).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withMobilePhone(mobilePhone).witheMail(eMail));
        }
        return  contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if(contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement element : elements){
            //String firstName = element.getText();
            List<WebElement> tds = element.findElements(By.xpath(".//td"));
            String firstName = tds.get(2).getText();
            String lastName = tds.get(1).getText();
            String[] phones = tds.get(5).getText().split("\n");
            //String firstName = element.findElement(By.xpath("//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //String lastName = element.findElement(By.xpath("//td[2]")).getText();
            String mobilePhone = element.findElement(By.xpath("//td[6]")).getText();
            String eMail = element.findElement(By.tagName("a")).getText();
            contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .witheMail(eMail).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return  contactCache;
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

    private void initContactModification(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
    }
}
