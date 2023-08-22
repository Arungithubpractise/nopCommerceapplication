package com.nopCommerceapplication.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addcustomerpage {
	
	public WebDriver driver;

	public Addcustomerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By lnkCustomers_menu = By.xpath("//i[@class='nav-icon far fa-user']");
	By lnkCustomers_menuitem = By.xpath("//p[text()=' Customers']");

	By btnAddnew = By.xpath("//i[@class='fas fa-plus-square']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtcustomerRoles = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By lstitemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	By lstitemGuests = By.xpath("//li[contains (text(), 'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(), 'Vendors')]");

	By drpmgrOfVendor = By.xpath("//* [@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");

	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDob = By.xpath("//input[@id= 'DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminContent = By.xpath("//textarea [@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");

	public void clickOnCustomersMenu() throws InterruptedException {
		
		Thread.sleep(10);
		driver.findElement(lnkCustomers_menu).click();
	}

	public void lnkCustomers_menuitem() {

		driver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		driver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {
		if (!role.equals("Registered")) {
			driver.findElement(By.xpath("//li//span[@aria-hidden='true']")).click();

		}
		Thread.sleep(3000);

		driver.findElement(txtcustomerRoles).click();

		WebElement listitem = null;

		if (role.equals("Administrators")) {
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

	public void setManagerOfVendor(String value) {
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
		driver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLasttname(String lname) {
		driver.findElement(txtLastName).sendKeys(lname);
	}

	public void setdob(String dob) {
		driver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String cname) {
		driver.findElement(txtCompanyName).sendKeys(cname);
	}

	public void setAdmincontent(String Acontent) {
		driver.findElement(txtAdminContent).sendKeys(Acontent);
	}

	public void clickonsave(String dob) {
		driver.findElement(btnSave).click();
	}

}



