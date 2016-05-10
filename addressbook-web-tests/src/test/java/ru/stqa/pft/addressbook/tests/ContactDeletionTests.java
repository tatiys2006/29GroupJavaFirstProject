package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


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

   /*@Test
    public void testContactDeletion() throws InterruptedException {


    Contacts before = app.contact().all();
        int index = before.size() - 1;
        app.contact().selectContactById(index);
        app.contact().initContactDeletion();
        app.contact().confirmDeletion();
        Thread.sleep(5000);
    Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    } */
}
