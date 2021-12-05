package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage  registrationSuccessPage = new RegistrationSuccessPage();

    //Desktop page


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
        //click on
    }
}
