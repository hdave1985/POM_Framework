package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.basePage;

public class dashboardPage extends basePage 
{

	public dashboardPage(WebDriver driver)
	{
		super(driver);
	}
	
	
//	Page elements 
	
	@FindBy(xpath="//p[contains(text(), 'Log out')]")
	WebElement btnlogout;
	
	@FindBy(xpath = "//p[normalize-space()='Tickets']")
	WebElement labelTickets;
//	
//	@FindBy(id="signin")
//	WebElement btnLogin;
//	
//	@FindBy(id="")
//	WebElement linkforgotpassword;
	
	
//	Action methods 
	
	public void clickLogut() 
	{
		btnlogout.click();
		
	}
	
	public boolean isMyadminPageExists()
	{
		try 
		{
			return (labelTickets.isDisplayed());	
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			return false;
		}
		
	}
	
	
//	public void addPassword(String pass) 
//	{
//		txtpassword.clear();
//		txtpassword.sendKeys(pass);
//	}
//	
//	public void clickLogin() 
//	{
//		btnLogin.click();
//	}
	
	
}
