package pagesPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import helperPackage.BrowserFactory;
import testPackage.BaseClass;
import utilityPackage.ConfigReader;
import utilityPackage.CustomWait;
import utilityPackage.ExcelDataConfig;
import utilityPackage.ScreenShot;

public class RegisterPage {
	
	public RegisterPage()
    {
        PageFactory.initElements(BrowserFactory.driver, this);

    }
    // Click on User Icon
    @FindBy(how = How.XPATH, using = "//div[@id='banner-account-links']/ul/li[2]/div/button")
    private WebElement UserBanner;

    //Click on My Account
    @FindBy(how = How.XPATH, using ="//ul[@id='user-nav-account']/li/a")
    private WebElement MyAccount;

    //Click on Register Here Link
    @FindBy(how = How.XPATH, using = "//span[@id='dialog-register']/a")
    private WebElement RegisterLink;

    //Enter FirstName
    @FindBy(how = How.XPATH, using = "//input[@id='register_first_name']")
    private WebElement FirstName;

    //Enter LastName
    @FindBy(how = How.XPATH, using = "//input[@id='register_last_name']")
    private WebElement LastName;

    //click on Email
    @FindBy(how = How.XPATH, using = "//input[@id='register_email']")
    private WebElement Email;

    //Click on Password
    @FindBy(how = How.XPATH, using = "//input[@id='register_raw_password']")
    private WebElement Password;

    //Click on Retype password
    @FindBy(how = How.XPATH, using = "//input[@id='register_reenter_password']")
    private WebElement RePassword;

    //Accept terms and conditions
    @FindBy(how = How.XPATH, using = "//input[@id='register_terms_and_conditions']")
    private WebElement Terms;

    //Click on Register Button
    @FindBy(how = How.XPATH, using =  "//input[@value='Register']")
    private WebElement Registerbutton;

    
  //Method to check if GrabOne home page is launched
  	public void VerifyHomePage() throws HeadlessException, AWTException, IOException
  	{
  			
  		
  		String title=null;
  		
  			//wait until the title is displayed
  			CustomWait.wait("//button[@data-toggle-target='#user-nav-account']",30,1);
  				
  			//get the title of the current page
  			title=BrowserFactory.driver.getTitle();	
  			
  			//check if the title contains "GrabOne"
  			if(title.contains("GrabOne NZ"))
  			{
  				BaseClass.testLog.log(Status.PASS, "GrabOne home page is launched successfully");
  			}
  			else
  			{
  				//Capture screenshot of the fail page
  				ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed home page");
  				//Get the failure log
  				BaseClass.testLog.log(Status.FAIL, "GrabOne home page isn't launched successfully");
  				//Set an assertion of failure
  				Assert.fail("Failed to launch GrabOne home page");
  			}		
  	}
    public void Navigateregister(int ID) throws InterruptedException
    {
    	//Populate profile data from excel file: "./TestData/TestData.xlsx". ID=rowNumber
         ExcelDataConfig excel=new ExcelDataConfig(ConfigReader.getExcelPath());
    			
        
        //Click on UserIcon
      Thread.sleep(1000);
       UserBanner.click();


        //Select MyAccount from dropdown
       Thread.sleep(1000);
       MyAccount.click();

        //Click on the Register link
       Thread.sleep(1000);
        RegisterLink.click();
       //Read FirstName
        FirstName.sendKeys(excel.getData("Register", ID, 1));

        //Read LastName
        LastName.sendKeys(excel.getData("Register", ID, 2));

        //Read Email
        Email.sendKeys(excel.getData("Register", ID, 3));
        //Read Password
        Password.sendKeys(excel.getData("Register", ID, 4));
        Thread.sleep(1000);
        //Read RetypePassword
        RePassword.sendKeys(excel.getData("Register", ID, 5));


        //Click on Terms and Conditions
        Thread.sleep(1000);
        Terms.click();

        //Click on Signup
        Thread.sleep(1000);
        Registerbutton.click();
        

    }

}
