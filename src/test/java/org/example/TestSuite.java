package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage  registrationSuccessPage = new RegistrationSuccessPage();

    //Computers page
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();


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
}
