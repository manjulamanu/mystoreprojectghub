package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver remotedriver) {
		ldriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
		// Page Factory is a class provided by Selenium WebDriver to support Page Object
		// Design patterns.

	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addcustomer;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	@CacheLookup
	WebElement cusomtername;

	@FindBy(how = How.XPATH, using = "//*[@id=\"dob\"]")
	@CacheLookup
	WebElement dob;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
	@CacheLookup
	WebElement pin;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
	@CacheLookup
	WebElement telephone;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	@CacheLookup
	WebElement submit;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[2]")
	@CacheLookup
	WebElement reset;

	public void clickaddcustomerlink() {
		addcustomer.click();
	}

	public void addCustoomername(String cname) {
		cusomtername.sendKeys(cname);
	}

	public void dob(String mm, String dd, String yyyy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}

	public void address(String Caddress) {
		address.sendKeys(Caddress);
	}

	public void ccity(String ccity) {
		city.sendKeys(ccity);
	}
	
	public void cstate(String sstate) {
		state.sendKeys(sstate);
	}

	public void cpin(String pino) {
		pin.sendKeys(pino);
	}

	public void cphone(String phone) {
		telephone.sendKeys(phone);
	}

	public void email(String cemail) {
		email.sendKeys(cemail);
	}

	public void csubmit() {
		submit.click();
	}

}
