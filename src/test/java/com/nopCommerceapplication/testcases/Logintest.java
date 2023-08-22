package com.nopCommerceapplication.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceapplication.pageobject.Loginpage;
import com.nopCommerceapplication.utility.Readconfig;

public class Logintest extends Baseclass {
	
	Readconfig read = new Readconfig();
	
	@Test
	public void logintest() throws InterruptedException {
		
		Loginpage lp = new Loginpage(driver);

		lp.setusername(read.getusername());

		log.info("username is passed");

		lp.setpassword(read.getpassword());

		log.info("password is passed");

		lp.clicklogin();
		
		log.info("clicked on login");

		String str = driver.getCurrentUrl();
		
		Assert.assertEquals(str, "https://admin-demo.nopcommerce.com/admin/");

		log.info("home page is displayed");
	}
	
}
