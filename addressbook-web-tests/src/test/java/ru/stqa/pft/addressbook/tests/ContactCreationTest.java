package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


   @Test //(enabled = false)
    public void testContactCreation() {
       Contacts before = app.contact().all();

       File photo = new File("src/test/resources/b269688.jpg");
       ContactData contact = new ContactData().withFirstName("FirstName2").withLastName("LastName2").withAddress(null).withPhoneNumberHome("22111222333")
              .withEmail("firstname2.lastname2@test.com").withGroup("[none]").withPhoto(photo);

        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
       Contacts after = app.contact().all();
       assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    /*@Test
    public void testCurrentDir() {
      File currentDir = new File("."); // to4ka - eto tekucshaya directoriya
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/b269688.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
    */
}
