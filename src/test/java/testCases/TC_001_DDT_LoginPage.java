package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.dashboardPage;
import pageObjects.loginPage;
import testBase.baseClass;
import utilities.DataProviders;

public class TC_001_DDT_LoginPage extends baseClass
{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void performLogin(String email, String pwd, String exp) throws InterruptedException 
	{
		logger.info("+++Starting of TC_001_DDT_LoginPage ++++");
		
		loginPage lp = new loginPage(driver);
//		lp.addemail("ce.hardikdave@gmail.com");
		lp.addemail(email); // email is from param of method from excel
		Thread.sleep(1000);
		lp.addPassword(pwd); // pwd is from param of method from excel
//		lp.addPassword("Kiatest@17");
		Thread.sleep(1000);
		lp.clickLogin();
		Thread.sleep(8000);
		
		dashboardPage dp = new dashboardPage(driver);
		boolean success = dp.isMyadminPageExists();
		
//		dashboardPage dp = new dashboardPage(driver);
//		boolean success = dp.isMyadminPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(success==true)
			{
		
				dp.clickLogut();
				logger.info("clicked on logout");
				Thread.sleep(4000);
				
				Assert.assertTrue(true);
				logger.info("login is successful");
			
			}
			else
			{
				lp.clearEmail();
				Thread.sleep(2000);
				lp.clearPassword();
				Thread.sleep(4000);
				Assert.assertTrue(false);
				logger.info("login is failed");
			}
		}
		else
		{
			logger.info("From else loop where response is invalid ");
			
			if(success==true)
			{
				dp.clickLogut();
				Assert.assertTrue(false);
			}
			else
			{
				Thread.sleep(5000);
				
				lp.clearEmail();
				Thread.sleep(4000);
				
				lp.clearPassword();
				Thread.sleep(4000);
				
				Assert.assertTrue(true);
			}
		}
			
		logger.info("+++Ending of TC_001_DDT_LoginPage ++++");
	
	}
	
}
