package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage  registrationSuccessPage = new RegistrationSuccessPage();

    //Computers page
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();

    NewReleasePage newReleasePage = new NewReleasePage();

    //To refer a product to a friend
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ProductEmailAFriendPage productEmailAFriendPage = new ProductEmailAFriendPage();


    @Test
    public void verifyUserShouldBeAbleToRegisterSuccessfully(){
        //Click on register link
        homePage.clickOnRegisterLink();
        //enter user details
        registrationPage.checkUserIsInRegisterPage();
        registrationPage.fillUserDetails();
        registrationPage.clickOnRegisterButton();
        registrationSuccessPage.verifyUserHasSuccessfullyRegistered();
    }

    @Test
    public void verifyUserIsAbleToNavigateToTheDesktopPage(){
        homePage.clickOnComputersMenu();
        //check user is on the computers page
        computersPage.checkUserIsInTheComputersPage();
        //click on desktops heading
        computersPage.clickOnDesktopsHeading();
        desktopPage.checkUserIsInTheDesktopPage();


    }

    @Test
    public void verifyUserIsAbleToPostAComment(){
        homePage.clickOnDetailsButton();
        newReleasePage.checkUserIsInTheNewReleasePage();
        newReleasePage.fillCommentSection();
        newReleasePage.checkTheCommentIsPostedSuccessfully();
    }

    @Test
    public void verifyUserIsAbleToReferAProduct(){
        // user registration
        verifyUserShouldBeAbleToRegisterSuccessfully();
        // Click on a product
        verifyUserIsAbleToNavigateToTheDesktopPage();
        //Click on a product
        desktopPage.clickOnAProduct();
        //Check if the user is in build your own computer page
        buildYourOwnComputerPage.checkUserIsOnThisPage();
        //Click on email a friend button
        buildYourOwnComputerPage.clickOnEmailAFriendButton();
        //Check if the user is on product email a friend page
        productEmailAFriendPage.checkUserIsOnTheProductEmailAFriendPage();
        //Fill the form
        productEmailAFriendPage.fillEmailAFriendForm();
        //Verify email is sent successfully
        productEmailAFriendPage.checkEmailIsSentSuccessfully();


    }
}
