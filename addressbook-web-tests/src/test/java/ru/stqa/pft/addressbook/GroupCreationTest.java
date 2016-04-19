package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("GroupName1", "Group Header1", "Group Footer1"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
