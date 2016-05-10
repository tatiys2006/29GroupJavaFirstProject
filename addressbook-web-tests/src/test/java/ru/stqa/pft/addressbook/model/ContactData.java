package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String phoneNumberHome;
    private  String email;
    private String group;

    public ContactData(String firstName, String lastName, String address, String phoneNumberHome, String email, String group) {
        this.id ;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumberHome = phoneNumberHome;
        this.email = email;
        this.group = group;
    }

    public ContactData(int id, String firstName, String lastName, String address, String phoneNumberHome, String email, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumberHome = phoneNumberHome;
        this.email = email;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
