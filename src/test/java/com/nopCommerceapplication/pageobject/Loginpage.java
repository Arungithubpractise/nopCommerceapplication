package com.nopCommerceapplication.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
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
	
public void setusername(String user)
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
	loginbutton.click();

}

}