package com.automation.bitrix24.tests.activityStream;

import com.automation.bitrix24.pages.LoginPage;
import com.automation.bitrix24.pages.activityStream.AppreciationTab;
import com.automation.bitrix24.tests.AbstractTestBase;
import com.automation.bitrix24.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppreciationTabTests extends AbstractTestBase {


    /**
     * 6. User should be able to add mention by clicking on the Add mention icon and
     * select contacts from the lists provided in dropdown.
     */

    @Test(description = "US 6 -AC6")
    public void verifySelectedContactName() {
        test = report.createTest("Click add mention icon and select contact ");
        AppreciationTab appreciationTab = new AppreciationTab();
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

    /**
     * 7. User should be able to click on Visual Editor and
     * see the editor text-bar displays on top of the message box.
     */

    @Test(description = "US 6 -AC7")
    public void verifyEditorTextBarDisplay() {

        test = report.createTest("Editor text bar display");
        LoginPage loginPage = new LoginPage();
        AppreciationTab appreciationTab = new AppreciationTab();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");


        appreciationTab.clickVisualEditor();
        Assert.assertTrue(appreciationTab.editorTextBarDisplay());

        test.pass("Editor text bar is displayed successfully");

    }

    /**
     * User should be able to click on the Topic icon to see
     * the Appreciation Topic text box displays on top of the message box.
     */

    @Test(description = "US 6 -AC8")
    public void verifyTopicTextBoxDisplay() {
        test = report.createTest("Topic text icon display");
        LoginPage loginPage = new LoginPage();
        AppreciationTab appreciationTab = new AppreciationTab();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");


        appreciationTab.clickTopicIcon();

        Assert.assertTrue(appreciationTab.topicTitleDisplay());

        test.pass("Topic text box is displayed successfully");
    }

    /**
     * User should be able to  creating new tags by clicking on the # icon.
     */
    @Test(description = "US 6 -AC10")
    public void verifyCreatedNewTag() {
        test = report.createTest("Create new Tag ");
        LoginPage loginPage = new LoginPage();
        AppreciationTab appreciationTab = new AppreciationTab();
        loginPage.loginAsHr();
        appreciationTab.navigateTo("Appreciation");

        appreciationTab.createNewTag("#Batch15");

        String actual=appreciationTab.getTagName().substring(1);
        String expected="Batch15";

        Assert.assertEquals(actual,expected);

        test.pass("Tag is created successfully");

    }

    @Test(description = "AC5")
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

    @Test(description = "AC3")
    public void addLink(){
        test = report.createTest("Add a link and explanation, and send it to everyone");
        LoginPage login = new LoginPage();
        login.loginAsMarketing();
        AppreciationTab appreciation = new AppreciationTab();
        appreciation.navigateTo("Appreciation");
        appreciation.addaLink("https://www.amazon.com/","amazonwebsite");
        Assert.assertEquals(appreciation.returnTitleofAddedLink(),"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
        test.pass("Link was added successfully");
    }

    @Test (description = "AC1-TC1-addLink")
    public void addaImage(){
        test = report.createTest("Upload file and images from local");
        LoginPage login = new LoginPage();
        login.loginAsMarketing();
        AppreciationTab appreciation = new AppreciationTab();
        appreciation.navigateTo("Appreciation");
        Assert.assertTrue(appreciation.addFileFromLocal());
        test.pass("Image was added successfully");

    }


    @Test(description = "AC4-TC1-vimeoURL")
    public void insertVideoVimeo(){
        test = report.createTest("Upload a vimeo vidoe");
        LoginPage login = new LoginPage();
        login.loginAsMarketing();
        AppreciationTab appreciation = new AppreciationTab();
        appreciation.navigateTo("Appreciation");
        Assert.assertTrue(appreciation.InsertVideo("https://vimeo.com/223939510"));
        test.pass("Vimeo video was inserted successfully");
    }


    @Test(description = "AC4-TC2-youtubeURL")
    public void insertVideoYoutube(){
        test = report.createTest("Upload a youtube vidoe");
        LoginPage login = new LoginPage();
        login.loginAsMarketing();
        AppreciationTab appreciation = new AppreciationTab();
        appreciation.navigateTo("Appreciation");
        Assert.assertTrue(appreciation.InsertVideo("https://www.youtube.com/watch?v=WPvGqX-TXP0"));
        test.pass("Youtube video was inserted successfully");
    }







}
