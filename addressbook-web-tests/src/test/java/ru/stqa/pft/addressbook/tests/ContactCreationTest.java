package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


   @Test
    public void testContactCreation() {
       Contacts before = app.contact().all();

        ContactData contact = new ContactData().withFirstName("FirstName").withLastName("LastName").withAddress(null).withPhoneNumberHome("111222333")
                .withEmail("firstname.lastname@test.com").withGroup("[none]");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
       Contacts after = app.contact().all();
       assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
}
