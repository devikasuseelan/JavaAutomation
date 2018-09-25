package testPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagesPackage.AccountPage;
import pagesPackage.GrabOneHomePage;
import pagesPackage.ProfilePage;
import pagesPackage.Subscriptions;
import pagesPackage.Unsubscribe;


public class TestClass extends BaseClass{
	
	
	
	@Test(description = "Test to login", priority=0)
	public void Login() throws HeadlessException, AWTException, IOException, InterruptedException
	{
		testLog.log(Status.INFO, "Login test started");
		
		//Launch and validate GrabOne home page
		GrabOneHomePage GO_HomePage=new GrabOneHomePage();
		GO_HomePage.VerifyHomePage();
		
		int ID=1;//Tester can choose which set of data in "Login" sheet in the TestData excel file to test by providing ID
		GO_HomePage.Login(ID);	
		
	}
	
	@Test(description = "Test Account page", priority=1)
	public void Account_Page() throws HeadlessException, AWTException, IOException, InterruptedException
	{
		//Tester can choose which set of data in the TestData excel file to test by providing ID
		int ID=1;
		
		testLog.log(Status.INFO, "Test for account update started");
		
		//Login to GrabOne website
      	GrabOneHomePage GO_HomePage=new GrabOneHomePage();	
      	GO_HomePage.Login(ID);
		
		//Update profile details
		AccountPage Accountobj = new AccountPage();
		Accountobj.UpdateAccount(ID);	
		
	}
	
	
	@Test(description = "Test profile page", priority=2)
	public void Profile_Page() throws HeadlessException, AWTException, IOException, InterruptedException
	{
		//Tester can choose which set of data in  the TestData excel file to test by providing ID
		
		int ID=1;
		testLog.log(Status.INFO, "Test for profile update started");
		
		//Login to GrabOne website
      	GrabOneHomePage GO_HomePage=new GrabOneHomePage();	
      	GO_HomePage.Login(ID);	
      	
		//Update profile details
		ProfilePage Profileobj = new ProfilePage();		
		Profileobj.ProfileUpdate(ID);	
		
	}
	
	@Test(description = "Test profile page", priority=3)
	public void Subscriptions_Page() throws HeadlessException, AWTException, IOException, InterruptedException
	{
		//Tester can choose which set of data in  the TestData excel file to test by providing ID
		
		int ID=1;
		testLog.log(Status.INFO, "Test for subscriptions started");
		
		//Login to GrabOne website
      	GrabOneHomePage GO_HomePage=new GrabOneHomePage();	
      	GO_HomePage.Login(ID);	
      	
		//Update profile details
		Subscriptions Subobj = new Subscriptions();		
		Subobj.DailySubscription(ID);	
		Subobj.DealsSubscription(ID);
		
	}
	
	@Test(description = "Test profile page", priority=5)
	public void UnSubscribe_Page() throws HeadlessException, AWTException, IOException, InterruptedException
	{
		//Tester can choose which set of data in  the TestData excel file to test by providing ID
		
		int ID=1;
		testLog.log(Status.INFO, "Test for Unsubscriptions started");
		
		//Login to GrabOne website
      	GrabOneHomePage GO_HomePage=new GrabOneHomePage();	
      	GO_HomePage.Login(ID);	
      	
		//Update profile details
		Unsubscribe UnSubobj = new Unsubscribe();		
		UnSubobj.UnSubscribeMails(ID);	
		
		
	}
	
}
