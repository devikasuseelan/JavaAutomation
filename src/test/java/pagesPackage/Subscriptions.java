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

public class Subscriptions {

	
	public Subscriptions()
    {
        PageFactory.initElements(BrowserFactory.driver, this);
    }

    // Initialize Elements
    

    //Click on my subscriptions
    @FindBy(how = How.XPATH, using = "//a[@href='/my-stuff/my-subscriptions']")
    private WebElement LinkSubscription;

    //Check for page title present
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Email Subscriptions')]")
    private WebElement Element;


    //Select daily subscriptions
    @FindBy(how = How.XPATH, using = "//input[@id='site_subscription_manager_subscriptions_site_subscription_2']")
    private WebElement DailySub;
    @FindBy(how = How.XPATH, using =  "//input[@id='site_subscription_manager_subscriptions_site_subscription_9']")
    private WebElement DailySub1;
    @FindBy(how = How.XPATH, using = "//input[@id='site_subscription_manager_subscriptions_site_subscription_11']")
    private WebElement DailySub2;

    //Click bottle
    @FindBy(how = How.XPATH, using = "//input[@id='site_subscription_manager_subscriptions_site_subscription_15']")
    private WebElement Bottle;

    //Click Escapes
    @FindBy(how = How.XPATH, using =  "//div[@id='my-subscriptions']/div/form/fieldset/div/div/ul/li[3]/div/div/ul/li/input")
    private WebElement Escapes;

    //Click store
    @FindBy(how = How.XPATH, using = "//div[@id='my-subscriptions']/div/form/fieldset/div/div/ul/li[4]/div/div/ul/li/input")
    private WebElement Store;

    //Select book now
    @FindBy(how = How.XPATH, using = "//input[@id='site_subscription_manager_subscriptions_site_subscription_173']")
    private WebElement BookNow;

    @FindBy(how = How.XPATH, using = "//div[@id='my-subscriptions']/div/form/fieldset/div/div/ul/li[5]/div/div[2]/ul/li[13]/input")
    private WebElement BookNow1;

    //Click cart reminder
    @FindBy(how = How.XPATH, using = "//input[@id='site_subscription_manager_specials_cart_reminder']")
    private WebElement CartReminder;

    //Click SaveChanges 
    @FindBy(how = How.XPATH, using = "//div[@id='my-subscriptions']/div/form/fieldset/div[4]/span/input")
    private WebElement SaveChanges;

    //Read Save Message 
    @FindBy(how = How.XPATH, using = "//span[@class='notice-text']")
    private WebElement SaveMessage;

    //Click on my subscribe
    @FindBy(how = How.XPATH, using = "//a[@class='banner-account-links__subscribe']")
    private WebElement Subscribe;

    
    //Select My top deals subscription
    @FindBy(how = How.XPATH, using =  "//a[contains(text(),'My Top Deals Subscriptions')]")
    private WebElement TopDeals;

    //Check for navigation to Top deals subscriptions page
    @FindBy(how = How.XPATH, using = "//h1[@class='corner-label']")
    private WebElement TopElement;

    //Select region

    @FindBy(how = How.XPATH, using =  "//select[@id='my_top_deals_subscribe_site_subscription']")
    private WebElement SelectRegion;

    //Click next
    @FindBy(how = How.XPATH, using =  "//a[@id='button-step-2']")
    private WebElement NextBtn;

    //Select Type of deals
    @FindBy(how = How.XPATH, using =  "//input[@id='my_top_deals_subscribe_categories_1609']")
    private WebElement TypeDeal1;


    //Select save button
    @FindBy(how = How.XPATH, using =  "//span[@class='save-button']")
    private WebElement SaveBtn;

    //Select finish button
    @FindBy(how = How.XPATH, using = "//a[@id='button-finished']")
    private WebElement FinishBtn;

    public void DailySubscription(int ID) throws InterruptedException, HeadlessException, AWTException, IOException
    {
        // Driver.wait(2);
        // UserIcon.Click();
    	//Check whether in update account page
    	 try {
    		 
    		 Thread.sleep(1000);
             String Actual = "Update Account";
             String Expected = BrowserFactory.driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/h1")).getText();
             Assert.assertEquals(Actual,Expected);
             BaseClass.testLog.log(Status.PASS, "In update account page");
    	 }
    	 catch(Exception e) 
    	 {
    		//Capture screenshot of the fail page
		     ScreenShot.captureScreenshot(BrowserFactory.driver, "Not in update account page");

             BaseClass.testLog.log(Status.PASS, "Not in update account page");
    	 }

        Thread.sleep(1000);
        LinkSubscription.click();
        //Navigate to email Subscriptions page
        try

        {

        	Thread.sleep(1000);
            String Expected = "Email Subscriptions";
            String Actual = Element.getText();
            Assert.assertEquals(Expected, Actual);
            BaseClass.testLog.log(Status.INFO, "Navigate to Email subscriptions page");
            // Select daily subscription
            
            DailySub.click();
            DailySub1.click();
            DailySub2.click();
            //Select Bottle
            Thread.sleep(1000);
            Bottle.click();
            //Select escapes
            Escapes.click();
            //select store
            Store.click();

            //Select Book now options
            Thread.sleep(1000);
            BookNow.click();
            BookNow1.click();

            //Select special emails
            Thread.sleep(1000);
            CartReminder.click();

            //Click on save changes button
            Thread.sleep(1000);
            SaveChanges.submit();

            String ExpectedMessage = "Your changes have been saved";
            String ActualMessage = SaveMessage.getText();
            if ((ExpectedMessage).equals(ActualMessage))
            	BaseClass.testLog.log(Status.INFO, "Subscriptions  change successfull");
            else
            	BaseClass.testLog.log(Status.INFO, "Subscriptions change unsuccessfull");

        }
        catch(Exception e)
        {
        	//Capture screenshot of the fail page
		     ScreenShot.captureScreenshot(BrowserFactory.driver, "Email subscriptions unsuccessfull");

        	BaseClass.testLog.log(Status.INFO, "Email subscriptions unsuccessfull");
        }
    }

    public void DealsSubscription(int ID) throws InterruptedException, HeadlessException, AWTException, IOException
    {

        // Check if in Email subscription page
    	Thread.sleep(1000);
        String Expected = "Email Subscriptions";
        String Actual = Element.getText();
        if (Expected.equals(Actual))
        {
        	BaseClass.testLog.log(Status.INFO," In Email subscriptions page ");
        }
        else
        {
        	//Capture screenshot of the fail page
        	ScreenShot.captureScreenshot(BrowserFactory.driver, "Not in Email subscriptions page");

        	BaseClass.testLog.log(Status.INFO, "Not in Email subscriptions page ");
        }

        //Click on My Top Deals subscription link
        Thread.sleep(1000);
        TopDeals.click();


        // Check whether navigated to the Top Deals subscription page
        try
        {
        	Thread.sleep(1000);
            String ExpectedPage = "My Top Deals Email";
            String ActualPage = TopElement.getText();
            Assert.assertEquals(ExpectedPage, ActualPage);
            BaseClass.testLog.log(Status.INFO,"Navigate to My Top deals page successfull");
            //Select your region
            Thread.sleep(1000);
            Actions action = new Actions(BrowserFactory.driver);
            action.moveToElement(SelectRegion).build().perform();
            List<WebElement>SelectRegionOpt = SelectRegion.findElements(By.tagName("option"));
            for (WebElement value : SelectRegionOpt)
            {
                if (value.getText() == "Auckland")
                    value.click();
            }
            //Click on Next Button
            Thread.sleep(1000);
            NextBtn.click();
            //Select type of deals            
            TypeDeal1.click();
            
            //Click save button
            SaveBtn.click();
            //Click finish button
            Thread.sleep(1000);
            FinishBtn.click();
            //Check if subscribed for top subscriptions
            Thread.sleep(1000);
            String ExpectedMsg = "Email Subscriptions";
            String ActualMsg = Element.getText();
            if (ExpectedMsg.equals(ActualMsg))
            	BaseClass.testLog.log(Status.INFO, "Top deals Subscription successfull");
            else
            {
            	//Capture screenshot of the fail page
            	ScreenShot.captureScreenshot(BrowserFactory.driver, "Top deals Subscription unsuccessfull");

            	BaseClass.testLog.log(Status.INFO, "Top deals Subscription unsuccessfull");
            }
        }
        catch(Exception e)
        {
        	//Capture screenshot of the fail page
        	ScreenShot.captureScreenshot(BrowserFactory.driver, "Navigate to My Top deals emailpage unsuccessfull");

        	BaseClass.testLog.log(Status.INFO, "Navigate to My Top deals emailpage unsuccessfull");

        }
    }

}
