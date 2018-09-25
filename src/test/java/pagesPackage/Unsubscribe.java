package pagesPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import helperPackage.BrowserFactory;
import testPackage.BaseClass;
import utilityPackage.ScreenShot;

public class Unsubscribe {
	
	public Unsubscribe()
    {
        PageFactory.initElements(BrowserFactory.driver, this);
    }

   // Initialize Elements

    //Click on subscriptions link
    @FindBy(how = How.XPATH, using = "//a[@href='/my-stuff/my-subscriptions']")
    private WebElement Subscriptions;

    //Click on unsubscribe button
    @FindBy(how = How.XPATH, using = "//input[@id='quick-unsubscribe']")
    private WebElement UnSubscrib;

    //Check for image in frame
    @FindBy(how = How.XPATH, using = "//img[@src='https://main-cdn.grabone.co.nz/images/common/unsubscription-gimme.png']")
    private WebElement Image;

    //Click on comment box
    @FindBy(how = How.XPATH, using = " //select[@id='unsubscription_reason']")
    private WebElement CommentBox;

    //Click on submit
    @FindBy(how = How.XPATH, using = " //input[@id='unsubscription-submit']")
    private WebElement SubmitBtn;

    // Check for message
    @FindBy(how = How.XPATH, using = "//span[@class='notice-text']")
    private WebElement UnSubMessage;

    @FindBy(how = How.XPATH, using = " //p[contains(text(),'We have saved your comments. Thanks for letting us')]")
    private WebElement CommentMessage;
    
    public void UnSubscribeMails(int ID) throws InterruptedException, HeadlessException, AWTException, IOException
    {
    	//Check whether in update Account page
    	String Expected = "Update Account";
    	String Actual = BrowserFactory.driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/h1")).getText();
    	if(Expected.equals(Actual))
    		BaseClass.testLog.log(Status.INFO, "In update account page");
    	else
    		BaseClass.testLog.log(Status.INFO, "Not in update account page");

        // Click on subscriptions link
        Thread.sleep(1000);
        Subscriptions.click();
        try
        {
        	//Check whether in email subscriptions page
        	
        	Thread.sleep(1000);
            Assert.assertTrue(UnSubscrib.isEnabled());
            UnSubscrib.click();        
        
            //Check for image displayed
            Assert.assertTrue(Image.isDisplayed());
            BaseClass.testLog.log(Status.INFO, "Navigated to unsubscribe page");
            
            //Select from comment drop down
            Thread.sleep(1000);
            Actions action = new Actions(BrowserFactory.driver);
            action.moveToElement(CommentBox).build().perform();
            List<WebElement> CommentBoxOpt = CommentBox.findElements(By.tagName("option"));
            for (WebElement value : CommentBoxOpt)
            {
                if (value.getText().equals("Other"))
                    value.click();
            }
            //Click submit button
            SubmitBtn.click();
           try
           {
            Thread.sleep(1000);
            String ExpectedMsg = "You have been unsubscribed from all emails.";
            String ActualMsg = UnSubMessage.getText();
            Assert.assertEquals(ExpectedMsg, ActualMsg);
            BaseClass.testLog.log(Status.INFO,  " Unsubscribed success message");
            
            Thread.sleep(1000);   
            String ExpectedCommentMsg = "We have saved your comments. Thanks for letting us know.";
            String ActualCommentMsg = CommentMessage.getText();
            if(ExpectedCommentMsg.equals(ActualCommentMsg))
            {
            	 BaseClass.testLog.log(Status.INFO,  " Comment saved message displayed");
            }


           }
           catch(Exception e)
           {
        	 //Capture screenshot of the fail page
		      ScreenShot.captureScreenshot(BrowserFactory.driver, "Could not unsubscribe");

		      BaseClass.testLog.log(Status.INFO,  "Could not unsubscribe");
           }
        }
        catch(Exception e)
        {
        //Capture screenshot of the fail page
		 ScreenShot.captureScreenshot(BrowserFactory.driver, "Unsubscribed  button not enabled");

		 BaseClass.testLog.log(Status.INFO,  " Unsubscribed  button not enabled");
        }
    }

}
