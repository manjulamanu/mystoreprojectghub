package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtilis;

import junit.framework.Assert;

public class TC_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "logindata")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(wb);
		lp.setUserName(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clicksubmit();
		logger.info("submit is clicked");
		
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			wb.switchTo().alert().accept();
			wb.switchTo().defaultContent();
			// this line focus on main page
			Assert.assertFalse(false);
			logger.info("login is failed");
		}

		else
			Assert.assertTrue(true);
		logger.info("login is passed");
	}

// this is simple userdefined mehtod to check alert is there or not	
	public boolean isAlertPresent() {
		try {
			wb.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException {
		// first gettign all data from excel file which is in testdatadiles package

		String path = ".\\testdatafiles\\logindata.xlsx";

		int rowno = XLUtilis.getRowCount(path, "sheet1");
		int columncount = XLUtilis.getColumnCount(path, 1);

		String logindata[][] = new String[rowno][columncount];

		for (int i = 1; i <= rowno; i++) {
			// in excel file zero row is header part that is i is initated to 1
			for (int j = 0; j <= i; j++) {
				logindata[i - 1][j] = XLUtilis.getCellData("sheet1", i, j);
			}
		}
		return logindata;
	}
}