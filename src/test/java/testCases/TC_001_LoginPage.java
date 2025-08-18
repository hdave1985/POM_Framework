package testCases;

import org.testng.annotations.Test;

import pageObjects.loginPage;
import testBase.baseClass;

public class TC_001_LoginPage extends baseClass
{

	@Test(groups = "master")
	public void performLogin() throws InterruptedException 
	{
		logger.info("+++Starting of TC_001_Login ++++");
		loginPage lp = new loginPage(driver);
//		lp.addemail("ce.hardikdave@gmail.com");
		lp.addemail(prop.getProperty("email"));
		Thread.sleep(1000);
		lp.addPassword(prop.getProperty("password"));
//		lp.addPassword("Kiatest@17");
		Thread.sleep(1000);
		lp.clickLogin();
		logger.info("+++Ending of TC_001_Login ++++");
	}
	
}
