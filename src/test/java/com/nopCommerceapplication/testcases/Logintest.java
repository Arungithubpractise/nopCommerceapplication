package com.nopCommerceapplication.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceapplication.pageobject.Loginpage;
import com.nopCommerceapplication.utility.Readconfig;

public class Logintest extends Baseclass {
	
	Readconfig read = new Readconfig();
	String credentialstext = "The credentials provided are incorrect";
	String emailtext = "Please enter your email";
	
	@Test(priority =1,groups = {"smoke,Regression"})
	public void logintestwithvalidcredentials() throws InterruptedException {
		
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
	


@Test(priority =2,groups = {"smoke"})
public void logintestwithinvalidcredentials() throws InterruptedException {
	
	Loginpage lp = new Loginpage(driver);

	lp.setusername("admin@yourstore.com");

	log.info("username is passed");

	lp.setpassword("123456");

	log.info("password is passed");

	lp.clicklogin();
	
	log.info("clicked on login");
	

	
	Assert.assertEquals(lp.credentialserrormessage(), credentialstext);
	
	log.info("error meeasge is displayed");
		
}

@Test(priority =3,groups = {"sanity"})
public void logintestwithonlyusernameispassed() throws InterruptedException {
	
	Loginpage lp = new Loginpage(driver);

	lp.setusername("admin@yourstore.com");

	log.info("username is passed");

	lp.setpassword(" ");

	log.info("password is passed");

	lp.clicklogin();
	
	log.info("clicked on login");
	
	Assert.assertEquals(lp.credentialserrormessage(), credentialstext);
	
	log.info("error meeasge is displayed");
	
}


@Test(priority =4)
public void logintestwithonlyusernamepassed() throws InterruptedException {
	
	Loginpage lp = new Loginpage(driver);

	lp.setusername("");

	log.info("username is passed");

	lp.setpassword("admin");

	log.info("password is passed");

	lp.clicklogin();
	
	Assert.assertEquals(lp.Emailemailerror(), emailtext);
	log.info("error meeasge is displayed");
		
}


}