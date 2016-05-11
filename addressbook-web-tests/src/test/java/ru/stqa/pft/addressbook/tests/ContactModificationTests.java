package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("FirstNameMod-Del").withLastName("4").withAddress("5")
                    .withPhoneNumberHome("6").withEmail("firstnameModDel.lastname@test.com").withGroup("[none]"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactModification() {
        //Set<ContactData> before = app.contact().all();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();

        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("FirstName").withLastName("1").withAddress("2")
                     .withPhoneNumberHome("3").withEmail("firstname.lastname@test.com");
        app.contact().modify(contact);

        app.goTo().homePage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Set<ContactData> after = app.contact().all();
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

       // before.remove(modifiedContact);
       // before.add(contact);
       // Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }
}
