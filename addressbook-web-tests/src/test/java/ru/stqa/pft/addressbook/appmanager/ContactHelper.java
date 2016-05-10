package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tetyana.kostyrkina on 4/20/2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void submitContactData() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhoneNumberHome());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModification(int index) {
        click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index + 1) + "]/td[8]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDeletion() {
        click(By.xpath("//*[@value='Delete']"));
    }

    public void confirmDeletion() {
        wd.switchTo().alert().accept();
    }


    public void create(ContactData contact) {
        initContactCreation();
        fillContactData(contact, true);
        submitContactData();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        initContactDeletion();
        confirmDeletion();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public Set<ContactData> all() {
    // public Contacts all() {
         Set<ContactData> contacts = new HashSet<ContactData>();
       //  Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']//tr[@name='entry']"));
        for (WebElement element: elements) {
            String name = element.findElement(By.xpath(".//td[3]")).getText();
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
           int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstName(name).withLastName(lastName));
        }

        return contacts;
    }


}
