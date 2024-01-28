package com.nopCommerceapplication.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.nopCommerceapplication.pageobject.Addcustomerpage;
import com.nopCommerceapplication.pageobject.Loginpage;
import com.nopCommerceapplication.utility.Readconfig;

public class Addcustomertest extends Baseclass{
	
	Readconfig read = new Readconfig();
	
	@Test
	public void Addcustomer() throws IOException, InterruptedException {
		
		Loginpage lp = new Loginpage(driver);
		Addcustomerpage addcust = new Addcustomerpage(driver);

		lp.setusername(read.getusername());
		log.info("User name is entered");
		
        lp.setpassword(read.getpassword());		
        log.info("password  is entered");

		lp.clicklogin();		
		log.info("clicked on Login");
		
		addcust.clickOnCustomersMenu();

		addcust.lnkCustomers_menuitem();

		addcust.clickOnAddnew();

		String email = randomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setCustomerRoles("Guests");
		
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setGender("Male");
		addcust.setFirstname("Arun");
		addcust.setLasttname("kumar");
		addcust.setdob("7/05/1985");
		addcust.setCompanyName("busyQA");
		addcust.setAdmincontent("This is for Testing.....");

		addcust.clickonsave(null);
		Thread.sleep(10);

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
		
		

	}


}



