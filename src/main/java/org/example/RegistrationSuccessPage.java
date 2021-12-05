package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils{

    public void verifyUserIsOnRegisterSuccessPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains(""));
    }

    public void verifyUserHasSuccessfullyRegistered(){
        //Check if the test case passed
        String expectedResult = "Your registration completed";
        //waitForVisible(By.xpath("//div[@class=\"result\"]"),20);
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualResult, expectedResult, "Registration Error: Registration failed!!!");

    }
}
