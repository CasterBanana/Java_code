package ru.kruto.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String mobilePhone;
    private final String eMail;

    public ContactData(String firstName, String lastName, String mobilePhone, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String geteMail() {
        return eMail;
    }
}
