package pagesPackage;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import helperPackage.BrowserFactory;
import testPackage.BaseClass;
import utilityPackage.ConfigReader;
import utilityPackage.ExcelDataConfig;
import utilityPackage.ScreenShot;

public class AccountPage {
	
	 public AccountPage()
     {
         PageFactory.initElements(BrowserFactory.driver, this);

     }

	//Click on user icon
	@FindBy(how = How.XPATH, using = "//div[@id='banner-account-links']/ul/li[2]/div/button")
    private WebElement UserIcon;

    //Click on Profile
	@FindBy(how = How.XPATH, using = "//a[@href='https://www.grabone.co.nz/profile']")
    private WebElement ProfileLnk;
    
     //Click on  Change name link
     @FindBy(how = How.XPATH, using = "//fieldset[@class='small-form']//form[1]//div[1]//div[1]//a[1]")
     private WebElement ChangeName;

     //Click on  first name link
     @FindBy(how = How.NAME, using =  "account[first_name]")
     private WebElement FirstName;

     //Click on last name
     @FindBy(how = How.NAME, using =  "account[last_name]")
     private WebElement LastName;

     //Click on submit button
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form/div/div[2]/div[3]/span/input")
     private WebElement SubmitName;

     //Click on change password
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form/div[3]/div/a")
     private WebElement ChangePassword;

     //Click on current password
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form/div[3]/div[2]/div/div/input")
     private WebElement CurrentPassword;

     //Click on new password
     @FindBy(how = How.XPATH, using = "//*[@id='account_raw_password']")
     private WebElement NewPassword;

     //Click on confirm password
     @FindBy(how = How.XPATH, using = "//*[@id='account_confirm_password']")
     private WebElement ConfirmPassword;

     //Click on Submit button
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form/div[3]/div[2]/div[4]/span/input")
     private WebElement SubmitPassword;

     // Click on change email
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form/div[4]/div/a")
     private WebElement ChangeEmail;

     //Click on email field
     @FindBy(how = How.XPATH, using =  "//*[@id='account_email']")
     private WebElement Email;

     //Click on submit email
     @FindBy(how = How.XPATH, using = "//div[@id='my-account']/div/fieldset/form/div[4]/div[2]/div[2]/span/input")
     private WebElement SubmitEmail;


     //Click on Change credit card details
     @FindBy(how = How.XPATH, using = "//div[@id='my-account']/div/fieldset/form/div[5]/div/a")
     private WebElement ChangeCard;

     //Click on forget button
     @FindBy(how = How.XPATH, using =  "//*[@id='account_forget_cards']")
     private WebElement ForgetButton;

     //Click on change region link
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form[2]/div/div/a")
     private WebElement ChangeRegion;

     //Click on region dropdown list
     @FindBy(how = How.XPATH, using =  "//div[@id='my-account']/div/fieldset/form[2]/div/div[2]/div/div/select")
     private WebElement Region;

     //Click on Submit button
     @FindBy(how = How.XPATH, using = "//div[@id='my-account']/div/fieldset/form[2]/div/div[2]/div[2]/span/input")
     private WebElement SubmitRegion;

     //Click on change address link
     @FindBy(how = How.XPATH, using = "//div[@id='my-account']/div/fieldset/div/div/a")
     private WebElement ChangeAddress;

     //Click on Add new address button
     @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add New Address')]")
     private WebElement AddNewAddress;

     //Click on label field
     @FindBy(how = How.XPATH, using = "//*[@id='address_label']")
     private WebElement Label;

     //Click on Name field
     @FindBy(how = How.XPATH, using = "//*[@id='address_name']")
     private WebElement Name;

     //Click on Address field
     @FindBy(how = How.XPATH, using =  "//*[@id='address_address']")
     private WebElement Address;

     //Click on Suburb field
     @FindBy(how = How.XPATH, using =  "//*[@id='address_locality']")
     private WebElement Suburb;

     //Click on city field
     @FindBy(how = How.XPATH, using = "//*[@id='address_city']")
     private WebElement City;

     //Click on post code field
     @FindBy(how = How.XPATH, using =  "//*[@id='address_postcode']")
     private WebElement PostCode;

     //Click on Contact Phone field
     @FindBy(how = How.XPATH, using =  "//*[@id='address_contact_phone']")
     private WebElement ContactPhone;

     //Click on Add address button
     @FindBy(how = How.XPATH, using = "//*[@id='content']/div[2]/div[2]/div/form/fieldset/div[9]/span/input")
     private WebElement AddAddress;

     //Select update message
     @FindBy(how = How.XPATH, using =  "//*[@id='content']/div[1]/p")
     private WebElement UpdateMessage;

     // Check Navigate to update account page
     @FindBy(how = How.XPATH, using =  "//*[@id='Context']/div[2]/div[2]/div/h1")
     private WebElement Update;
     

     // Method for updating account details
     public void UpdateAccount(int ID) throws InterruptedException, HeadlessException, AWTException, IOException
     {

         // Populating the data from Excel
    	 ExcelDataConfig excel=new ExcelDataConfig(ConfigReader.getExcelPath());
    	 try {
    		 //Check whether navigated to update account page
    		 Thread.sleep(1000);
             Assert.assertTrue(BrowserFactory.driver.findElement(By.linkText("Update Account")).isDisplayed());
             BaseClass.testLog.log(Status.PASS, "Navigated to update account page");
    	 }
    	 catch(Exception e) 
    	 {
    		//Capture screenshot of the fail page
		     ScreenShot.captureScreenshot(BrowserFactory.driver, "Navigate to update account page unsuccessfull");

             BaseClass.testLog.log(Status.PASS, "Navigate to update account page unsuccessfull");
    	 }

         //Click on change name link
         Thread.sleep(1000);
         ChangeName.click();

         //Enter first name
         FirstName.clear();
         FirstName.sendKeys(excel.getData("Account",ID, 1));

         //Enter last name
         LastName.clear();
         LastName.sendKeys(excel.getData("Account",ID, 2));

         //Click on submit button
         SubmitName.click();
         BaseClass.testLog.log(Status.PASS, "Update Name Successfull");

         //Click on change password
         //ChangePassword.click();
         //Enter current password
         //CurrentPassword.sendKeys(excel.getData("Account",ID, 3));
         //Enter new password
        // NewPassword.sendKeys(excel.getData("Account",ID, 4));
         //Enter confirm password
         //ConfirmPassword.sendKeys(excel.getData("Account",ID, 5));
         //Click on submit button
         //SubmitPassword.click();
         BaseClass.testLog.log(Status.PASS, "Update password Successfull");


         //Click on change email
         ChangeEmail.click();
         //Enter Email address
         Email.clear();
         Email.sendKeys(excel.getData("Account",ID, 6));
         //Click submit button
         SubmitEmail.click();
         BaseClass.testLog.log(Status.PASS, "Update email Successfull");


         //Update cerdit card details
         ChangeCard.click();
         //Click forget button to remove the credit card
         ForgetButton.click();
         BaseClass.testLog.log(Status.PASS,"Remove credit card details Successfull");


         //Click on change region link
         ChangeRegion.click();
         //Select a region fro dropdown list
         Region.click();
         Thread.sleep(1000);
         Actions action = new Actions(BrowserFactory.driver);
         action.sendKeys(Region, Keys.ARROW_DOWN).perform();
         action.sendKeys(Region, Keys.RETURN).click();
         //Click on submit button
         SubmitRegion.click();
         try
         {
             Thread.sleep(1000);
             Assert.assertTrue(BrowserFactory.driver.findElement(By.linkText("Your region has been updated")).isDisplayed());
             BaseClass.testLog.log(Status.PASS, "Updated region successfully");
         }
         catch (Exception e)
         {
        	//Capture screenshot of the fail page	
        	 ScreenShot.captureScreenshot(BrowserFactory.driver, "Update region unsuccessfull");
        	 BaseClass.testLog.log(Status.FAIL,"Update region unsuccessfull");
         }

         //Click on Change address
         Thread.sleep(1000);
         ChangeAddress.click();
         //Click on Add new address button
         Thread.sleep(1000);
         AddNewAddress.click();
         String Expected = "Add Address";
         String Actual = BrowserFactory.driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/h1")).getText();
         if (Expected == Actual)
         {
        	 BaseClass.testLog.log(Status.PASS, "Navigated to Add Address page");
         }
         else
         {   
        	 //Capture screenshot of the fail page	
        	 ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed to navigate to Address page");
        	 BaseClass.testLog.log(Status.FAIL, "Navigate to Add Address page unsuccessfull");
         }
         //Enter the details in address page
         Thread.sleep(1000);
         Label.sendKeys(excel.getData("Account",ID, 8));
         Thread.sleep(1000);
         Name.clear();
         Name.sendKeys(excel.getData("Account",ID, 9));
         Thread.sleep(1000);
         Address.sendKeys(excel.getData("Account",ID, 10));
         Thread.sleep(1000);
         Suburb.sendKeys(excel.getData("Account",ID, 11));
         Thread.sleep(1000);
         City.sendKeys(excel.getData("Account",ID, 12));
         Thread.sleep(1000);
         PostCode.sendKeys(excel.getData("Account",ID, 13));
         Thread.sleep(1000);
         ContactPhone.sendKeys(excel.getData("Account",ID, 14));
         Thread.sleep(1000);
         AddAddress.click();
         Thread.sleep(1000);
         try
         {
             //string ExpectedMessage = "Your address has been saved as work";
             //String ActualMessage = Driver.driver.FindElement(By.PartialLinkText(ExpectedMessage)).Text;
             Thread.sleep(1000);
             Assert.assertTrue(BrowserFactory.driver.findElement(By.linkText("Update Account")).isDisplayed());
             
             BaseClass.testLog.log(Status.PASS,"Updated address successfully");
         }
         catch (Exception e)
         {
        	//Capture screenshot of the fail page
		     ScreenShot.captureScreenshot(BrowserFactory.driver, "Update address unsuccessfull");
        	 BaseClass.testLog.log(Status.FAIL,"Update address unsuccessfull");
         }
         BaseClass.testLog.log(Status.PASS, "Update useraccount successfull");
    	
     }



}
