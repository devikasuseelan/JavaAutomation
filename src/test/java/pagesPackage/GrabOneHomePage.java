package pagesPackage;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import helperPackage.BrowserFactory;
import testPackage.BaseClass;
import utilityPackage.ConfigReader;
import utilityPackage.CustomWait;
import utilityPackage.ExcelDataConfig;
import utilityPackage.ScreenShot;

public class GrabOneHomePage extends BaseClass{
	//POM constructor
	public GrabOneHomePage()
	{
		PageFactory.initElements(BrowserFactory.driver, this);
	}
	
	//Initialize WeElements in  login page
		// Click on User Icon
		@FindBy(how = How.XPATH, using = "//div[@id='banner-account-links']/ul/li[2]/div/button")
		private WebElement UserBanner;
	    
	    //Click on My Account
	    @FindBy(how = How.XPATH, using = "//ul[@id='user-nav-account']/li/a")
	    private WebElement MyAccount;
	    
	    // Finding the Email Field
	    @FindBy(how = How.XPATH, using = "//*[@id='login_email']")
	    private WebElement Email;    

	    // Finding the Password Field
	    @FindBy(how = How.XPATH, using = "//*[@id='login_password']")
	    private WebElement PassWord;    

	    // Finding rememberme check box
	    @FindBy(how = How.XPATH, using = "//*[@id='login_remember_me']")
	    private WebElement RememberMe;   
	    
	    // Finding the Login Button
	    @FindBy(how = How.XPATH, using = "//*[@id='login']/fieldset/div[4]/input")
	    private WebElement loginButton;

		
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
				testLog.log(Status.PASS, "GrabOne home page is launched successfully");
			}
			else
			{
				//Capture screenshot of the fail page
				ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed home page");
				//Get the failure log
				testLog.log(Status.FAIL, "GrabOne home page isn't launched successfully");
				//Set an assertion of failure
				Assert.fail("Failed to launch GrabOne home page");
			}		
	}
	
	
	//method to Login 
	public void Login(int ID ) throws HeadlessException, InterruptedException, AWTException, IOException
	{
			
			 //Click on UserIcon
		     Thread.sleep(1000);
		     UserBanner.click();
		    //Select MyAccount from dropdown
		     Thread.sleep(1000);
		     MyAccount.click();

			//verify if login page is launched.
			assertEquals(BrowserFactory.driver.getTitle(),"Login To GrabOne","Login page isn't launched properly");
			
			//populate login data from excel file: "./TestData/TestData.xlsx". ID=rowNumber		
			ExcelDataConfig excel=new ExcelDataConfig(ConfigReader.getExcelPath());	
			
			Email.sendKeys(excel.getData("Login", ID, 1));
			PassWord.sendKeys(excel.getData("Login", ID, 2));
			
			//un-check the "Remember Me" box
			RememberMe.click();
			
			//click on Login button
			loginButton.click();
			
			//Check login successfull
			 try {
	    		 //Check whether navigated to update account page
				 Thread.sleep(1000);
	             String Actual = "Update Account";
	             String Expected = BrowserFactory.driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/h1")).getText();
	             Assert.assertEquals(Actual,Expected);
	             BaseClass.testLog.log(Status.PASS, "Login successfull : Navigated to update account page");
	    	 }
	    	 catch(Exception e) 
	    	 {
	    		//Capture screenshot of the fail page
			     ScreenShot.captureScreenshot(BrowserFactory.driver, "Navigate to update account page unsuccessfull");

	             BaseClass.testLog.log(Status.PASS, "Login unsuccessfull :Navigate to update account page unsuccessfull");
	    	 }

			
			
	}
			


}
