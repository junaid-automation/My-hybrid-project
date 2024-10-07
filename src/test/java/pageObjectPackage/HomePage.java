package pageObjectPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{
	//WebDriver driver;
   public HomePage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath = "//span[text()='My Account']") WebElement myaccount;
   @FindBy(xpath = "//a[normalize-space()='Register']") WebElement Register;
   @FindBy(xpath = "//a[normalize-space()='Login']") WebElement loginbtn;
   
   //Actions Method
   public void clickMyaccount()
   {
	   myaccount.click();
   }
   public void clickRegister()
   {
	   Register.click();
   }
   public void clickLogin()
   {
	   loginbtn.click();
   }

}
