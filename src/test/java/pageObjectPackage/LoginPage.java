package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	// pavanol123@gmail.com   test@123
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	@FindBy(xpath="//input[@id='input-email']") WebElement Email_txtbox;
	@FindBy(xpath="//input[@id='input-password']") WebElement password_txtbox;
	
	
	// Action method
	
	public void set_email(String email)
	{
		Email_txtbox.sendKeys(email);
	}
	public void set_pwd(String pwd)
	{
		password_txtbox.sendKeys(pwd);
	}
	public void Click_login()
	{
		loginbtn.click();
	}
	
}
