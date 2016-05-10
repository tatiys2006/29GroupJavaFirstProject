package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withName("FirstName").withLastName("LastName").withAddress(null).withPhoneNumber("111222333")
                .withEmail("firstname.lastname@test.com").withGroup("[none]");
        app.contact().create(contact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        Assert.assertEquals(before, after);
    }

}
