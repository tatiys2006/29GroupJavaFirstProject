package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by tetyana.kostyrkina on 5/18/2016.
 */
public class ContactPhoneTest extends TestBase{

   /* @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("FirstNameMod-Del").withLastName("4").withAddress("5")
                    .withPhoneNumberHome("6").withEmail("firstnameModDel.lastname@test.com").withGroup("[none]"));
            app.goTo().homePage();
        }
    }*/

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getPhoneNumberHome(), equalTo(contactInfoEditForm.getPhoneNumberHome()));
        assertThat(contact.getMobileHome(), equalTo(contactInfoEditForm.getMobileHome()));
        assertThat(contact.getWorkPhone(), equalTo(contactInfoEditForm.getWorkPhone()));

    }
}
