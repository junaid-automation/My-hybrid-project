package testCasePackage;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectPackage.HomePage;
import pageObjectPackage.LoginPage;
import pageObjectPackage.MyAccountPageObject;

public class TC_002_LoginTest extends BaseClass
{
	@Test(priority=1, groups = "Sanity")
	public void logintoaccount()
	{
		logger.info("****Starting the login in to the account****");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			LoginPage lp=new LoginPage(driver);
			
			lp.set_email(pro.getProperty("email"));
			lp.set_pwd(pro.getProperty("password"));
			lp.Click_login();
			MyAccountPageObject ma=new MyAccountPageObject(driver);
			boolean myaccdisplayed=ma.validateMyAccount();
			Assert.assertEquals(myaccdisplayed, true , "Login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
}
