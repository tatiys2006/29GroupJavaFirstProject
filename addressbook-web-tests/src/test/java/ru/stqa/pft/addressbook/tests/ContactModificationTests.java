package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification() {
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(new ContactData("FirstName 2Mod", "LastName 2", "Myaddress 8", "111222333", "firstname.lastname@test.com"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().gotoHomePage();
    }
}
