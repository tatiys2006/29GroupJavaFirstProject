package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String phoneNumberHome;
    private  String email;
    private String group;
    private String WorkPhone;
    private String MobileHome;
    private String allPhones;

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;


        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    public ContactData withAddress(String address) {
        this.address = address;

        return this;
    }

    public ContactData withPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome;
        return this;
    }

    public ContactData withMobileHome(String MobileHome) {
        this.MobileHome = MobileHome;
        return this;
    }
    public ContactData withWorkPhone(String WorkPhone) {
        this.WorkPhone = WorkPhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
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

    public String getEmail() {
        return email;
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
    public String getGroup() {
        return group;
    }
    public String getWorkPhone() {
        return WorkPhone;
    }

    public String getMobileHome() {
        return MobileHome;
    }
}
