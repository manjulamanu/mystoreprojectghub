package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testcases.BaseClass;

public class LoginPage extends BaseClass {
	
	WebDriver ldriver;
   
	public LoginPage(WebDriver remotedriver){
		ldriver = remotedriver; 
		PageFactory.initElements(remotedriver, this);
		//Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns.
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String upwdd) {
		password.sendKeys(upwdd);
	}
	
	public void clicksubmit() {
		btnlogin.click();
	}
	
	
}
