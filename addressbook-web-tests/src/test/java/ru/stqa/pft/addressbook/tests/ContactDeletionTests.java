package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().confirmDeletion();
    }
}
