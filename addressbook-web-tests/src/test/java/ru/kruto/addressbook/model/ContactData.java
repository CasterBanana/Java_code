package ru.kruto.addressbook.model;
import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String mobilePhone;
    private final String eMail;

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactData(String firstName, String lastName, String mobilePhone, String eMail) {
        this.id =  Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.eMail = eMail;
    }

    public ContactData(int id, String firstName, String lastName, String mobilePhone, String eMail) {
        this.id = id;
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
