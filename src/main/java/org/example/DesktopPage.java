package org.example;

import org.testng.Assert;

public class DesktopPage extends Utils{

    public void checkUserIsInTheDesktopPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
    }
}
