package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest  extends Utils{
    BrowserManager browserManager = new BrowserManager();

    @BeforeMethod
    public void setUpBrowser()  {
        browserManager.openBrowser();
    }

    @AfterMethod
    public void tearDownBrowser(ITestResult result){
        if(!result.isSuccess()){
            captureScreenshot(result.getName());
        }
        browserManager.closeBrowser();
    }
}
