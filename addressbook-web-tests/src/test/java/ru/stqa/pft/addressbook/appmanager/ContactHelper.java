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

    public void initContactModification(int id) {
        click(By.xpath(".//a[@href='"+ "edit.php?id=" + id + "']/img[@title='Edit']")); ///PROBLEM!!!!
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDeletion() {
        click(By.xpath(".//*[@value='Delete']"));
    }

    public void confirmDeletion() {
        wd.switchTo().alert().accept();
    }


    public void create(ContactData contact) {
        initContactCreation();
        fillContactData(contact, true);
        submitContactData();
        contactCache = null;

    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        initContactDeletion();
        confirmDeletion();
        contactCache = null;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillContactData(contact, false);
        submitContactModification();
        contactCache = null;


    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    private Contacts contactCache = null;

 //  public Contacts all() {
    public Set<ContactData> all() {
        if (contactCache != null) {
            return  new Contacts(contactCache);
        }
       contactCache = new Contacts();
      /*  List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']//tr[@name='entry']"));
        for (WebElement element: elements) {
            String name = element.findElement(By.xpath(".//td[3]")).getText();
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
           int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withFirstName(name).withLastName(lastName));
        }
        return new Contacts(contactCache);
        */
   Set<ContactData> contacts = new HashSet<ContactData>();
       List<WebElement> rows = wd.findElements(By.name("entry"));
       for (WebElement row : rows) {
           List<WebElement> cells = wd.findElements(By.name("td"));
           int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
           String lastname = cells.get(1).getText();
           String firstname = cells.get(2).getText();
           String[] phones = cells.get(5).getText().split("\n");

           contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
                   .withPhoneNumberHome(phones[0]).withMobileHome(phones[1]).withWorkPhone(phones[2]));
       }
       return contacts;
   }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withPhoneNumberHome(home).withMobileHome(mobile).withWorkPhone(work);

    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../..")); // "." - поиск начинается с текущего эл-та и поднимаемся на 2 уровня вверх
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
        //wd.findElement(By.xpath(String.format("//tr[.input[@value='%s']]/td[8]/a",id))).click();
       // wd.findElements(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).clear();
    }
}
