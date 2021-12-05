package org.example;

import org.testng.Assert;

public class ComputersPage extends Utils{

    public void checkUserIsInTheComputersPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("computers"));
    }

}
