package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
       Contacts before = app.contact().all();
        //Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("FirstName").withLastName("LastName").withAddress(null).withPhoneNumberHome("111222333")
                .withEmail("firstname.lastname@test.com").withGroup("[none]");
        app.contact().create(contact);
        app.goTo().homePage();
       Contacts after = app.contact().all();
       // Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));


     //   before.add(contact);

       assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
}
