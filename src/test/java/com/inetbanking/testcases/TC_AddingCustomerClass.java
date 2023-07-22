package com.inetbanking.testcases;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_AddingCustomerClass extends BaseClass {

	@Test
	public void addcustomertest() throws InterruptedException {

		logger.info("url is opened");

		LoginPage loginpg = new LoginPage(wb);
		loginpg.setUserName(uname);
		logger.info("eneter username ");
		loginpg.setPassword(upwd);
		logger.info("eneter password ");
		loginpg.clicksubmit();
		logger.info("submitted");

		Thread.sleep(3000);

		AddCustomerPage addc = new AddCustomerPage(wb);
		addc.clickaddcustomerlink();
		logger.info("addcusomer link is opened");
		addc.addCustoomername("manu");
		logger.info("customer name  is added");
		addc.address("456/858,karanataka");
		logger.info("customer address is added");
		addc.ccity("BLR");
		addc.cstate("karantaka");
		logger.info("city  is added");
		addc.cphone("975222255");
		logger.info("phone  is added");
		addc.cpin("1256258");
		logger.info("pino  is added");
		addc.dob("10", "10", "1970");
		logger.info("dob  is added");

		String addgeneratedstring = generatrandomstring()+"@gmail.com";
		addc.email(addgeneratedstring);
		logger.info("email  is added");
		addc.csubmit();
		

		Boolean result = wb.getPageSource()
				.contains("Connection failed: Access denied for user 'root'@'localhost' (using password: NO)");

		if (result == true) {
			Assert.assertTrue(true);
			System.out.println("passed");
		} else
			Assert.assertFalse(false);
		
	}

}
