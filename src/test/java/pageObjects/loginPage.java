package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.basePage;

public class loginPage extends basePage 
{

	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
//	Page elements 
	
	@FindBy(id="username")
	WebElement txtemail;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(id="signin")
	WebElement btnLogin;
	
	@FindBy(id="")
	WebElement linkforgotpassword;
	
	
//	Action methods 
	
	public void addemail(String email) 
	{
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void addPassword(String pass) 
	{
		txtpassword.clear();
		txtpassword.sendKeys(pass);
	}
	
	public void clickLogin() 
	{
		btnLogin.click();
	}
	
	public void clearEmail()
	{
		txtemail.clear();
		
	}
	
	public void clearPassword()
	{
		txtpassword.clear();
		
	}
	
}
