package testCasePackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectPackage.HomePage;
import pageObjectPackage.LoginPage;
import pageObjectPackage.MyAccountPageObject;
import utilities.Data_Provider;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/
@Listeners(utilities.Extend_report.class)
public class TC_003_Login_data_driven_test extends BaseClass
{

	private Object logger;

	@Test(dataProvider="LoginData",dataProviderClass=Data_Provider.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		try {
	
		//Home page
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin(); //Login link under MyAccount
				
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.set_email(email);
			lp.set_pwd(password);
			lp.Click_login(); //Login button
				
			//My Account Page
			MyAccountPageObject macc=new MyAccountPageObject(driver);
			boolean targetPage=macc.validateMyAccount();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
}
