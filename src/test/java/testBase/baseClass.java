package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass 
{

	public static WebDriver driver;
	public Logger logger;  // org.apache.logging.log4j.Logger
	public Properties prop;
	
	@Parameters({"browser","os"})
	@BeforeClass(groups = "master")
	public void testSetup(String browser, String os) throws IOException 
	{
		System.out.println("From test setup");
		
		logger = LogManager.getLogger(this.getClass());
		logger.info("From test setup logger");
		
// Do not forget to add .// as first  
		FileReader fr = new FileReader(".//src/test/resources/config.properties");
		prop = new Properties();
		prop.load(fr);
		
//		FileReader fr2 = new FileReader("");
		
		switch (browser.toLowerCase()) 
		{
			case "chrome": driver = new ChromeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			case "edge": driver = new EdgeDriver(); break;

			default:logger.info("No default browser found from testng xml parameter field");
			break;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		driver.get("https://login.aiana.io/signin");
		driver.get(prop.getProperty("appurl"));
		logger.info("Launched");
		System.out.println("Web browser launched successfully");
	}
	
	
	@AfterClass(groups = "master")
	public void testTearDown() 
	{
//		System.out.println("From test tear down method");
		logger.info("From test tear down method");
		driver.quit();
	}
	
	
	public void generatealphanumeric()
	{
		
	}
	
	public String captureScreen(String tname) 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try 
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		
		return destination;
		
	}
}
