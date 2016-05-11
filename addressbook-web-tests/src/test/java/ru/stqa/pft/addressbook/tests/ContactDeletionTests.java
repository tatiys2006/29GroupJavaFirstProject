package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("FirstNameDel").withLastName("1").withAddress("2")
                    .withPhoneNumberHome("3").withEmail("firstnameDel-Del.lastname@test.com").withGroup("[none]"));
            app.goTo().homePage();
        }
    }

   @Test
    public void testContactDeletion() throws InterruptedException {

     //  Set<ContactData> before = app.contact().all();
       Contacts before = app.contact().all();
       ContactData deletedContact = before.iterator().next();


        app.contact().delete(deletedContact);

      // Set<ContactData> after = app.contact().all();
    Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        //before.remove(deletedContact);
        //Assert.assertEquals(before, after);
       assertThat(after, equalTo(before.withOut(deletedContact)));
    }
}
