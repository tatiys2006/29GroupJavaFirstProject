package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {

            app.getContactHelper().createContact(new ContactData("FirstName", null, null, null, "firstname.lastname@test.com", "[none]"));
            app.getNavigationHelper().gotoHomePage();

        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(new ContactData(null, "LastName", "Myaddress 8", null, "firstname.lastname@test.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
