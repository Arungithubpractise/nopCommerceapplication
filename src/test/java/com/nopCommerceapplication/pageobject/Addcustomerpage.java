package com.nopCommerceapplication.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nopCommerceapplication.utility.Webdrivewaitutils;

public class Addcustomerpage {
	
	public WebDriver driver;
	public Webdrivewaitutils wait;

	public Addcustomerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='nav-icon far fa-user']")
	WebElement lnkCustomers_menu;
	
	//By lnkCustomers_menu = By.xpath("//i[@class='nav-icon far fa-user']");
	
	@FindBy(xpath = "//p[text()=' Customers']")
	WebElement lnkCustomers_menuitem;
	
	//By lnkCustomers_menuitem = By.xpath("//p[text()=' Customers']");
	
	@FindBy(xpath = "//i[@class='fas fa-plus-square']")
	WebElement btnAddnew;

	//By btnAddnew = By.xpath("//i[@class='fas fa-plus-square']");
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;

	//By txtEmail = By.xpath("//input[@id='Email']");
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;
	
	//By txtPassword = By.xpath("//input[@id='Password']");
	
	@FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']")
	WebElement txtcustomerRoles;

	//By txtcustomerRoles = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	
	By lstitemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	
	By lstitemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	
	By lstitemGuests = By.xpath("//li[contains (text(), 'Guests')]");
	
	By lstitemVendors = By.xpath("//li[contains(text(), 'Vendors')]");
	
    By drpmgrOfVendor = By.xpath("//* [@id='VendorId']");
	
	By rdMaleGender = By.id("Gender_Male");
	
	By rdFeMaleGender = By.id("Gender_Female");
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;
	
	//By txtFirstName = By.xpath("//input[@id='FirstName']");
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;
	
	
	//By txtLastName = By.xpath("//input[@id='LastName']");
	
	@FindBy(xpath = "//input[@id= 'DateOfBirth']")
	WebElement txtDob;
	
	
	//By txtDob = By.xpath("//input[@id= 'DateOfBirth']");
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;
	
	//By txtCompanyName = By.xpath("//input[@id='Company']");
	
	@FindBy(xpath = "//textarea [@id='AdminComment']")
	WebElement txtAdminContent;
	
	//By txtAdminContent = By.xpath("//textarea [@id='AdminComment']");
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;
	
	//By btnSave = By.xpath("//button[@name='save']");

	public void clickOnCustomersMenu() throws InterruptedException
	{
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(lnkCustomers_menu, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void lnkCustomers_menuitem() {

		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(lnkCustomers_menuitem, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnAddnew() 
     {
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(btnAddnew, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void setEmail(String email) {
		
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(txtEmail, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void setPassword(String password) 
	{
		txtPassword.sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {
		if (!role.equals("Registered")) {
			driver.findElement(By.xpath("//li//span[@aria-hidden='true']")).click();

		}
		txtcustomerRoles.click();

		WebElement listitem = null;

		if (role.equals("Administrators")) 
		{
			listitem = driver.findElement(lstitemAdministrators);
		}

		else if (role.equals("Registered")) {
			listitem = driver.findElement(lstitemRegistered);
		}

		else if (role.equals("Guests")) {
			listitem = driver.findElement(lstitemGuests);

		} else if (role.equals("Vendors")) {
			listitem = driver.findElement(lstitemVendors);
		}

		listitem.click();
		Thread.sleep(1000);

	}

	public void setManagerOfVendor(String value) 
	{
		Select drp = new Select(driver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			driver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			driver.findElement(rdFeMaleGender).click();
		} else {
			driver.findElement(rdMaleGender).click();
		}
	}

	public void setFirstname(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLasttname(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setdob(String dob) {
		txtDob.sendKeys(dob);
	}

	public void setCompanyName(String cname) {
		txtCompanyName.sendKeys(cname);
	}

	public void setAdmincontent(String Acontent) {
		txtAdminContent.sendKeys(Acontent);
	}

	public void clickonsave(String dob) {
		wait = new Webdrivewaitutils(driver);
		wait.clickOnElement(btnSave, Webdrivewaitutils.EXPLICIT_WAIT_BASIC_TIME);
	
	}

}



