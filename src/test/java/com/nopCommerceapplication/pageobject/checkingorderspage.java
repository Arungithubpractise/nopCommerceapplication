package com.nopCommerceapplication.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceapplication.utility.Reusemethods;

public class checkingorderspage {
	
	public WebDriver driver;
	public Reusemethods wait;

	public checkingorderspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath = "(//p)[13]")
	WebElement sales;

	@FindBy(xpath = "(//p)[14]")
	WebElement orders;

	@FindBy(xpath = "(//div[@role=\"listbox\"])[1]")
	public WebElement Orderstatus;
	
	@FindBy(xpath = "//ul[@id=\"OrderStatusIds_listbox\"]/li")
	public List<WebElement> Ordstadropdownvalues;

	@FindBy(xpath = "(//div[@role=\"listbox\"])[2]")
	public WebElement Paymentstatuses;

	@FindBy(xpath = "//ul[@id=\"PaymentStatusIds_listbox\"]/li")
	public List<WebElement> Paymentstatusesdropdownvalues;
	
	@FindBy(xpath = "(//div[@role=\"listbox\"])[3]")
	public WebElement Shippingstatuses;
	
	@FindBy(xpath = "//ul[@id=\"ShippingStatusIds_listbox\"]/li")
	public List<WebElement> Shippingstatuses1dropdownvalues;

	@FindBy(id = "BillingCountryId")
	public WebElement Billingcountry;

	@FindBy(id = "PaymentMethodSystemName")
	public WebElement Paymentmethod;

	@FindBy(id = "search-orders")
	WebElement search;

	@FindBy(xpath = "//tbody")
	WebElement table;
	
	@FindBy(xpath = "//tbody/tr")
	List<WebElement> tableRows;

	//@FindBy(xpath = "//table[@id='orders-grid']//tr/td]")
	//List<WebElement> tableRows;

	@FindBy(xpath = "//tbody/tr/td")
	List<WebElement> tableColumns;

	@FindBy(xpath = "//a[text()='victoria_victoria@nopCommerce.com']")
	WebElement ord;

	public  void sales() {
		
		wait = new Reusemethods(driver);
		wait.clickOnElement(sales, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void orders() {
		
		wait.clickOnElement(orders, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public void Billingcountry() {
		wait.clickOnElement(Billingcountry, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void Paymentmethod() {
		wait.clickOnElement(Paymentmethod, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void Orderstatus() {
		wait.clickOnElement(Orderstatus, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void Paymentstatuses() {
		
		wait.clickOnElement(Paymentstatuses, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void Shippingstatuses() {
		wait.clickOnElement(Shippingstatuses, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void selectdropdown1(WebElement ele, String value) {
	
		wait.selectdropdownwithselecttag(ele, value, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectdropdown2(List<WebElement> alloptions, String value) {
			
		wait.selectdropdownwithnoselecttag(alloptions, value, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void search() 
	{
		wait.clickOnElement(search, Reusemethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public int getnoofcolumns() {
		return tableColumns.size();
	}

	public boolean searchOrders(String email) {
		
		int rowscount = tableRows.size();
	
		boolean flag = false;

		for (int i = 1; i<= rowscount; i++) {

			String emailid = table.findElement(By.xpath("//a[text()='victoria_victoria@nopCommerce.com']")).getText();
			
			if (emailid.equals(email)) {
				flag = true;
			}
		}

		return flag;
	}
}



