package com.nopCommerceapplication.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceapplication.pageobject.Loginpage;
import com.nopCommerceapplication.pageobject.checkingorderspage;
import com.nopCommerceapplication.utility.Readconfig;

public class checkingorderstest extends Baseclass{
	
	Readconfig read = new Readconfig();
   	
@Test(groups = {"sanity"})
	
	
	public void checkingorders() throws IOException, InterruptedException {
	
		Loginpage lp = new Loginpage(driver);
		checkingorderspage check = new checkingorderspage(driver);
	
		lp.setusername(read.getusername());

		log.info("User name is entered");
		
        lp.setpassword(read.getpassword());
		
    	log.info("password is passed");

		lp.clicklogin();
		
		log.info("clicked on login");
				
		check.sales();
				
		check.orders();
		
		log.info("clicked on orders");

		check.Billingcountry();
		check.selectdropdown1(check.Billingcountry, "Canada");

		check.Paymentmethod();
		check.selectdropdown1(check.Paymentmethod, "Check / Money Order");

		check.Orderstatus();
		check.selectdropdown2(check.Ordstadropdownvalues, "Complete");

		check.Paymentstatuses();
		check.selectdropdown2(check.Paymentstatusesdropdownvalues, "Paid");

		check.Shippingstatuses();
		check.selectdropdown2(check.Shippingstatuses1dropdownvalues, "Delivered");

		//check.datepicker();
		
		Thread.sleep(3000);
		
		check.search();
	
		 boolean status = check.searchOrders("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		
		log.info("all details are entered");
			
		
	}

	
}



