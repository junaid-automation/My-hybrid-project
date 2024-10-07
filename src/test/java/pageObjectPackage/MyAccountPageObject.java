package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageObject extends BasePage
{
	public MyAccountPageObject(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myacc;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;
	
	//Action method
	public boolean validateMyAccount()
	{
		try
		{
			return (myacc.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
				
	}
	
	public void clicklogout()
	{
		logout.click();
	}
}
