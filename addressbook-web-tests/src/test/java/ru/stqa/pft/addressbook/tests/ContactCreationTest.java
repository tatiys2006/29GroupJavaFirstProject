package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactData(new ContactData("FirstName", null, null, "111222333", "firstname.lastname@test.com"));
        //app.getContactHelper().fillContactData(new ContactData("FirstName", "LastName", "Myaddress", "111222333", "firstname.lastname@test.com"));
        app.getContactHelper().submitContactData();
        app.getContactHelper().gotoHomePage();
    }

}
