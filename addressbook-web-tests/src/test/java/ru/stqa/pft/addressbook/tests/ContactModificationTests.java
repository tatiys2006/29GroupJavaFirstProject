package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactModificationTests extends TestBase {


    @Test(enabled = false)
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("FirstName", null, null, null, "firstname.lastname@test.com",
                    "[none]"));
            app.goTo().gotoHomePage();
        }

        List<ContactData> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification(before.size());
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "FirstName4", "LastNameModif",
                "Myaddress 8Modif", null, "firstname.lastname@test.com", null);
        app.getContactHelper().fillContactData(contact, false);
        app.getContactHelper().submitContactModification();
        app.goTo().gotoHomePage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
