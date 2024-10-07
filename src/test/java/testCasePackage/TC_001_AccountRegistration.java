package testCasePackage;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjectPackage.HomePage;
import pageObjectPackage.RegisterPage;

public class TC_001_AccountRegistration extends BaseClass
{
	//WebDriver driver; 
	
	@Test(priority = 1, groups = "Sanity")	
	public void Verify_acc_registration() 
	{
		logger.info("*Starting the Test Case*");
		HomePage hp=new HomePage(driver);
	    hp.clickMyaccount();
	    hp.clickRegister();
	    logger.info("Clicked My account");
	    
	    RegisterPage rp=new RegisterPage(driver);
	    rp.FirstName(randomeString().toUpperCase());
	    rp.LastName(randomeString().toUpperCase());
	    rp.Email(randomeString()+"@gmail.com");
	    rp.Telephone(randomeNumber());
	    String tem_pass=randomeString()+randomeNumber();
	    rp.password(tem_pass);
	    rp.confirmpwd(tem_pass);
	    rp.AgreeCheckbox();
	    rp.continuebtn();  
	   // Assert.assertEquals(driver.getTitle(), "Register Account");
	    //System.out.println("Title "+driver.getTitle());
	    logger.info("Clicked Register");
	       	
	}
	public String randomeString()
	{
		String randome_Alphabet=RandomStringUtils.randomAlphabetic(5);
		return randome_Alphabet;
		
	}
	public String randomeNumber()
	{
		String randome_num=RandomStringUtils.randomAscii(10);
		return randome_num;
	}
	
	
}
