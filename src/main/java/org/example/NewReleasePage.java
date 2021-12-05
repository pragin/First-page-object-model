package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NewReleasePage extends Utils {

    By _titleTextField = By.id("AddNewComment_CommentTitle");
    By _commentTextTextArea = By.id("AddNewComment_CommentText");
    By _addCommentButton = By.name("add-comment");

    public void checkUserIsInTheNewReleasePage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce-new-release"));
    }

    public void checkTheCommentIsPostedSuccessfully(){
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"result\"]")) ;
        String expectedResult = "News comment is successfully added.";

        Assert.assertEquals(actualResult,expectedResult, "Comment error: error in posting the comment");
    }

    public void fillCommentSection(){
        //Enter title
        typeText(_titleTextField, "New Comment");
        //Enter comment
        typeText(_commentTextTextArea, "Comment Text");
        //Click on add comment button
        clickOnElement(_addCommentButton);
    }
}
