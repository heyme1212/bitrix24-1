package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.AppreciationTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import com.automation.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppreciationTabTests extends AbstractTestBase {

    //peer review :
    //All clean codes and you have great implementations
    //2 important point is:
    //We do not find elements in test class, all locators must be in page class
    //And all wait methods needs to be used in page class as common practice.

    private WebDriver driver = Driver.getDriver();
    AppreciationTab appreciationTab = new AppreciationTab();

    @FindBy(className = "bxhtmled-top-bar-wrap")
    private WebElement editorTextBar;

    @Test(description = "US 6 -AC6")
    public void verifySelectedContactName() {
        test = report.createTest("Click add mention icon and select contact ");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");

        BrowserUtils.wait(2);
        appreciationTab.clickAddMentionIconAndSelectContactList();
        String actual = appreciationTab.selectedContactName();
        String expected = "helpdesk31@cybertekschool.com";
        Assert.assertEquals(actual, expected);

        test.pass("User click add mention icon and selected contact name successfully");
    }


    @Test(description = "US 6 -AC7")
    public void verifyEditorTextBarDisplay() {
        test = report.createTest("Editor text bar display");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");

        BrowserUtils.wait(2);
        appreciationTab.clickVisualEditor();
        BrowserUtils.wait(3);
        Assert.assertTrue(driver.findElement(By.className("bxhtmled-top-bar-wrap")).isDisplayed());

        test.pass("Editor text bar displayed successfully");

    }


    @Test(description = "US 6 -AC8")
    public void verifyTopicTextBoxDisplay() {
        test = report.createTest("Topic text icon display");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");

        BrowserUtils.wait(2);
        appreciationTab.clickTopicIcon();
        WebElement topicTitle = driver.findElement(By.id("blog-title"));
        Assert.assertTrue(topicTitle.isDisplayed());

        test.pass("Topic text box displayed successfully");
    }


    @Test(description = "US 6 -AC10")
    public void verifyCreatedNewTag() {
        test = report.createTest("Create new Tag ");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");

        appreciationTab.createNewTag("#Batch15");

    }

    @Test
    public void quoteTextBox() {
        test = report.createTest("Creating a quote through the icon displayed on the appreciation page as a Marketing user");
        LoginPage login = new LoginPage();
        login.loginAsMarketing();
        AppreciationTab appreciation = new AppreciationTab();
        appreciation.navigateTo("Appreciation");
        String message = "Hello World";
        String actual = appreciation.addaQuotetotheMessage(message);
        Assert.assertEquals(actual, message);

        test.pass("Quote is written successfully");

    }

}
