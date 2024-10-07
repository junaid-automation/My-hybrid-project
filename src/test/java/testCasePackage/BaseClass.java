package testCasePackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass 
{
    public WebDriver driver;
    
    public Logger logger; // declaration of the log4j
    public Properties pro; // declaration of the properties file
    
	@BeforeClass(groups = "Sanity")
	@Parameters({"browser"})

	public void Setup(String br) throws IOException
	{
		//logging config.properties file using the file Reader
		FileReader reader=new FileReader("./src//test//resources//config.properties");   // ./ represent the current project directory
	    pro=new Properties(); //creating the memory location instance for properties object
	    pro.load(reader); //loading the properties file
		
		logger=LogManager.getLogger(this.getClass());
		switch (br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		case "edge":driver=new EdgeDriver();break;

		default:System.out.println("Invalid Browser");
			return;
		}
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();		
	}

	/*
	 * @AfterClass public void teardown() throws InterruptedException {
	 * 
	 * driver.close(); }
	 */
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
  }
	
}
