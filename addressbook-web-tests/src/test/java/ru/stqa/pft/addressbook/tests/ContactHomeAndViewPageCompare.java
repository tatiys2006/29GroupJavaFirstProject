package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactHomeAndViewPageCompare extends TestBase {


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
    public void testContactHomeAndViewPageCompare() {
        app.goTo().homePage();
        ContactData contact = app.contact().allInfoForTable().iterator().next();
        ContactData contactInfoViewForm = app.contact().infoAllFromViewForm(contact);

        assertThat(contact.getFirstnameLastname(), equalTo(contactInfoViewForm.getFirstnameLastname()));
        assertThat(contact.getAddress(), equalTo(contactInfoViewForm.getAddress()));
        assertThat(contact.getAllEmailAddresses(), equalTo(mergeEmailAddresses(contactInfoViewForm)));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoViewForm)));

    }


    private String mergeEmailAddresses(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getPhoneNumberHome(), contact.getMobileHome(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }
}
