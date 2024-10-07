package pageObjectPackage;

import java.time.Duration;

import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage
{
	  // WebDriver driver;
	   public RegisterPage(WebDriver driver)
	   {
		   super(driver);
	   }
	   @FindBy(xpath = "//input[@id='input-firstname']") WebElement FirstName;
	   @FindBy(xpath = "//input[@id='input-lastname']") WebElement LastName;
	   @FindBy(xpath = "//input[@id='input-email']") WebElement Email;
	   @FindBy(xpath = "//input[@id='input-telephone']") WebElement Telephone;
	   @FindBy(xpath = "//input[@id='input-password']") WebElement Pwd1;
	   @FindBy(xpath = "//input[@id='input-confirm']") WebElement pwd2;
	   @FindBy(xpath = "//input[@name='agree']") WebElement Chkbox_agree;
	   @FindBy(xpath = "//input[@value='Continue']") WebElement btn_continue;
	   
	   //Actions Method
	   
	   public void FirstName(String FrtName)
	   {
		   FirstName.sendKeys(FrtName);
	   }
	   
	   public void LastName(String lstName)
	   {
		   LastName.sendKeys(lstName);
	   }
	   public void Email(String mail)
	   {
		   Email.sendKeys(mail);
	   }
	   public void Telephone(String phone)
	   {
		 Telephone.sendKeys(phone);
	   }
	   public void password(String pwd)
	   {
		   Pwd1.sendKeys(pwd);
	   }
	   public void confirmpwd(String pwd)
	   {
		  pwd2.sendKeys(pwd);
	   }
	   public void AgreeCheckbox()
	   {
		  Chkbox_agree.click();
	   }
	   public void continuebtn()
	   {
		  btn_continue.click();
		 //  WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 // mywait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
	   }
}
