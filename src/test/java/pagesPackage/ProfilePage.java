package pagesPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

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

public class ProfilePage
{
	
	public ProfilePage()
    {
        PageFactory.initElements(BrowserFactory.driver, this);
    }

   
    //Click on user icon
    @FindBy(how = How.XPATH, using = "//div[@id='banner-account-links']/ul/li[2]/div/button")
    private WebElement UserIcon;

    //Click on Profile
    @FindBy(how = How.XPATH, using = "//a[@href='/profile']")
    private WebElement ProfileLnk;
    
   @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[1]/div/ul/li[4]/a")
   private WebElement MyProfile;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[2]/div/select")
    private WebElement Gender;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//select[@id='profile_birthday_day']")
    private WebElement BirthDay;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[3]/div/div/select[2]")
    private WebElement BirthMonth;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[3]/div/div/select[3]")
    private WebElement BirthYear;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[4]/div/input")
    private WebElement Mobile;


    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[5]/div/input")
    private WebElement PostCode;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//select[@id='profile_area_id-3']")
    private WebElement Region;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//select[@id='profile_area_id-4']")
    private WebElement SubRegion;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[8]/ul/li[3]/input")
    private WebElement Deals1;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[8]/ul/li[9]/input")
    private WebElement Deals2;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[8]/ul/li[15]")
    private WebElement Deals3;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[10]/div/select")
    private WebElement Education;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//select[@id='profile_profile_employment_id']")
    private WebElement Employment;

    //Click on Gender
    @FindBy(how = How.XPATH, using ="//select[@id='profile_profile_income_id']")
    private WebElement Income;

    //Click on Gender
    @FindBy(how = How.XPATH, using = " //input[@id='profile_is_home_owner_0']")
    private WebElement OwnHome;

    //Click on Gender
    @FindBy(how = How.XPATH, using =" //input[@id='profile_is_car_owner_0']")
    private WebElement OwnCar;

    //Click on Gender
    @FindBy(how = How.XPATH, using = " //input[@id='profile_has_children_1']")
    private WebElement Children;



    //Click on Gender
    @FindBy(how = How.XPATH, using = "//select[@id='profile_profile_relationship_id']")
    private WebElement RelationStatus;

    //Click on Gender
    @FindBy(how = How.XPATH, using = "//div[@id='profile']/form/fieldset/div[17]/span/input")
    private WebElement UpdateProfile;

    //Click on Gender
    @FindBy(how = How.XPATH, using ="//*[@id=\"content\"]/div[1]/p")
    private WebElement UpdateMessage;
  

    public void ProfileUpdate(int ID) throws InterruptedException, HeadlessException, AWTException, IOException
    {

        //Populate profile data from excel file: "./TestData/TestData.xlsx". ID=rowNumber
		ExcelDataConfig excel=new ExcelDataConfig(ConfigReader.getExcelPath());
		
		 try
	        {
		      Thread.sleep(1000);
              String Expected  = "Update Account";
              String Actual = BrowserFactory.driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/h1")).getText();
              Assert.assertEquals(Expected, Actual);
              BaseClass.testLog.log(Status.INFO, "In update account page");

    	     // click on profile link
             Thread.sleep(2000);
             ProfileLnk.click();
        
           // check Navigate to update profile page
       
            Thread.sleep(1000);
            String Actual1 = "Update Profile";
            String Expected1 = BrowserFactory.driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/h1")).getText();
            Assert.assertEquals(Actual1,Expected1);
            BaseClass.testLog.log(Status.INFO, "Navigate to Profile update page successfull");

            //Select gender
            Thread.sleep(1000);
            Actions action = new Actions(BrowserFactory.driver);
            action.sendKeys(Gender, Keys.ARROW_DOWN).perform();
            action.sendKeys(Gender, Keys.RETURN).click();

            //Select Birthday details
            Thread.sleep(1000);
            action.moveToElement(BirthDay).build().perform();            
            List<WebElement> BirthDayOpt = BirthDay.findElements(By.tagName("option"));            			
			for (WebElement value : BirthDayOpt)
            {
                if (value.getText().equals(excel.getData("Profile",ID, 2)))
                value.click();
            }
			//select birth month
            Thread.sleep(1000);
            action.moveToElement(BirthMonth).build().perform();
            List<WebElement> MonthOpt = BirthMonth.findElements(By.tagName("option"));
            
            for (WebElement value : MonthOpt)
            {
                if (value.getText().equals(excel.getData("Profile",ID, 3)))
                    value.click();
            }

            //Select BirthYear details
            Thread.sleep(1000);
            action.moveToElement(BirthYear).build().perform();
            List<WebElement> BirthYearOpt = BirthYear.findElements(By.tagName("option"));
            for (WebElement value : BirthYearOpt)
            {
                if (value.getText().equals(excel.getData("Profile",ID, 4)))
                    value.click();
            }

            //Enter Mobile number
            Thread.sleep(1000);
            Mobile.clear();
            Mobile.sendKeys(excel.getData("Profile", ID,5));

            //Enter postcode
            Thread.sleep(1000);
            PostCode.clear();
            PostCode.sendKeys(excel.getData("Profile", ID,6));

            //Select region
            Thread.sleep(1000);
            action.moveToElement(Region).build().perform();
            List<WebElement> RegionOpt = Region.findElements(By.tagName("option"));
            for (WebElement value : RegionOpt)
            {
                if (value.getText().equals(excel.getData("Profile", ID,7)))
                    value.click();
            }

            //Select subregion
            Thread.sleep(1000);
            action.moveToElement(SubRegion).build().perform();
            List<WebElement> SubRegionOpt = SubRegion.findElements(By.tagName("option"));
            for (WebElement value : SubRegionOpt)
            {
                if (value.getText().equals(excel.getData("Profile", ID,8)))
                    value.click();
            }

            //Unselect deals
            Thread.sleep(1000);
            Deals1.click();
            Deals2.click();
            Deals3.click();


            //Select education
            Thread.sleep(1000);
            action.moveToElement(Education).build().perform();
            List<WebElement> EducationOpt = Education.findElements(By.tagName("option"));
            for (WebElement value : EducationOpt)
            {
                if (value.getText().equals(excel.getData("Profile", ID,9)))
                    value.click();
            }

            //Select Employment
            Thread.sleep(1000);
            action.moveToElement(Employment).build().perform();
            List<WebElement> EmploymentOpt = Education.findElements(By.tagName("option"));
            for (WebElement value : EmploymentOpt)
            {
                if (value.getText().equals(excel.getData("Profile", ID,10)))
                    value.click();
            }

            //Select Income
            Thread.sleep(1000);
            action.moveToElement(Income).build().perform();
            List<WebElement> IncomeOpt = Income.findElements(By.tagName("option"));
            for (WebElement value : IncomeOpt)
            {
                if (value.getText().equals(excel.getData("Profile", ID,11)))
                    value.click();
            }
            Thread.sleep(1000);
            OwnHome.click();
            Thread.sleep(1000);
            OwnCar.click();
            Thread.sleep(1000);
            Children.click();

            //Select relationship status

            Thread.sleep(1000);
            action.moveToElement(RelationStatus).build().perform();
            List<WebElement> RelationStatusOpt = RelationStatus.findElements(By.tagName("option"));
            for (WebElement value : RelationStatusOpt)
            {
                if (value.getText().equals(excel.getData("Profile", ID,12)))
                    value.click();
            }

            // Click Update profile button
            Thread.sleep(1000);
            UpdateProfile.click();

            // Check for profile update message

            Thread.sleep(1000);
            String ExpectedMessage  = "Your profile was saved.";
            String ActualMesage = UpdateMessage.getText();
            if(ExpectedMessage == ActualMesage)
            	 BaseClass.testLog.log(Status.INFO, "Profile update successfull");
            else
            {
            	 BaseClass.testLog.log(Status.INFO, "Profile update unsuccessfull");
            	 //Capture screenshot of the fail page
    		     ScreenShot.captureScreenshot(BrowserFactory.driver, "Profile update unsuccessfull");

            }

        }
        catch (Exception e)
        {
        	//Capture screenshot of the fail page
		     ScreenShot.captureScreenshot(BrowserFactory.driver, "Navigate to Profile update page unsuccessfull");

        	BaseClass.testLog.log(Status.INFO, " Navigate to Profile update page unsuccessfull");
        }


    }


	

}
