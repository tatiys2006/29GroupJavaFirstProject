package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test(enabled = false)
    public void testContactDeletion() throws InterruptedException {

        if (! app.contact().isThereAContact()) {
            app.contact().create(new ContactData("FirstName", "1", "2", "3", "firstname.lastname@test.com", "[none]"));
            app.goTo().homePage();
        }
        List<ContactData> before = app.contact().all();
        app.contact().selectContactById(before.size() - 1);
        app.contact().initContactDeletion();
        app.contact().confirmDeletion();
        Thread.sleep(5000);
        List<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
