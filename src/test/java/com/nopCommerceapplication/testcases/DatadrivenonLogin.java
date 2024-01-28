package com.nopCommerceapplication.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerceapplication.pageobject.Loginpage;
import com.nopCommerceapplication.utility.Readconfig;
import com.nopCommerceapplication.utility.Xlreader;

public class DatadrivenonLogin extends Baseclass {
	
	Readconfig read = new Readconfig();
	
		@Test(dataProvider = "abc",groups = {"smoke"})
		public static void DdLogintest (String email, String password) throws InterruptedException {
			
			Loginpage lp = new Loginpage(driver);

			lp.setusername(email);

			log.info("username is passed");

			lp.setpassword(password);

			log.info("password is passed");																										
			
			lp.clicklogin();
			
			String str = driver.getCurrentUrl();
			
			Assert.assertEquals(str, "https://admin-demo.nopcommerce.com/admin/");

			log.info("home page is displayed");
				
		}
		
		@DataProvider(name = "abc")
		public  static Object [][] supplydata() throws IOException, InterruptedException 
		{	
			Object [][] data = Xlreader.Readdatafromexcel("LoginDDT");
			return data;
			
		}		
		
	}
