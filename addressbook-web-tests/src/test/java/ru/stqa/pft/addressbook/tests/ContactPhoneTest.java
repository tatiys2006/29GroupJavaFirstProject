package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by tetyana.kostyrkina on 5/18/2016.
 */
public class ContactPhoneTest extends TestBase{

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

   // @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().allForPhoneTest().iterator().next();
        ContactData contactInfoEditForm = app.contact().infoFromEditForm(contact);

       // assertThat(contact.getPhoneNumberHome(), equalTo(cleaned(contactInfoEditForm.getPhoneNumberHome())));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoEditForm)));
       // assertThat(contact.getMobileHome(), equalTo(cleaned(contactInfoEditForm.getMobileHome())));
       // assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoEditForm.getWorkPhone())));

    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getPhoneNumberHome(), contact.getMobileHome(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    @Test
    public void testAdresses() {
        app.goTo().homePage();
        ContactData contact = app.contact().allAddresses().iterator().next();
        ContactData contactInfoEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmailAddresses(), equalTo(mergeEmailAdresses(contactInfoEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoEditForm.getAddress()));

    }

    private String  mergeEmailAdresses(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

}
