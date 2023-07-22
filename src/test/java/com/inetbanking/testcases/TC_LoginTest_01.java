package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;



public class TC_LoginTest_01 extends BaseClass{
    
	
	@Test
	public void loginTest() {
		
		
		
		logger.info("url is opened"); 
		
		
		LoginPage loginpg =new LoginPage(wb);
		loginpg.setUserName(uname);
		logger.info("eneter username ");
		loginpg.setPassword(upwd);
		logger.info("eneter password ");
		loginpg.clicksubmit();
		logger.info("submitted");
		
		if(wb.getTitle().equals("Demo Site")) {
			Assert.assertTrue(true);
			logger.info("sucessfully tc passed ");
		}
		else {
			Assert.assertFalse(false);
			logger.info(" tc failed ");
		}
		
	}
}
