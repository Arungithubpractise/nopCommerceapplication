package com.nopCommerceapplication.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceapplication.utility.Reusemethods;

public class Loginpage {
	
	public WebDriver driver;
	public Reusemethods wait;
	
	public Loginpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="Email")
	WebElement emailfield;
	
	@FindBy(name="Password")
	WebElement passwordfirld;
	
	@FindBy(xpath="//button")
	WebElement loginbutton;
	
	@FindBy(xpath="//form/div[1]")
	WebElement errormssage;
	
	@FindBy(xpath="//li[text()='The credentials provided are incorrect']")
	WebElement credentialserrormessage;
	
	@FindBy(id = "Email-error")
	WebElement Emailemailerror;
	
	
public  void setusername(String user)
{
	emailfield.clear();
	emailfield.sendKeys(user);
}

public void setpassword(String pass)
{
	passwordfirld.clear();
	passwordfirld.sendKeys(pass);

}
public void clicklogin()
{
	wait = new Reusemethods(driver);
	wait.clickOnElement(loginbutton, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
}

public String credentialserrormessage()
{
	String errmess = credentialserrormessage.getText();
	return errmess;
}

public String Emailemailerror()
{
	String email = Emailemailerror.getText();
	return email;
}


}