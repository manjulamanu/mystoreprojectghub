package com.inetbanking.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readfile = new ReadConfig();
	
	public  Properties prop;
	public FileInputStream ip;
	public String browsr;
	public String url = readfile.url();
	public String uname = readfile.username();
	public String upwd =readfile. password();
	public static WebDriver wb;
	public static Logger logger ;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws IOException {

		logger = Logger.getLogger(TC_LoginTest_01.class);
	PropertyConfigurator.configure("Log4j.properties");
	
	
	
	if(br.equals("chrome")) {
		
		System.setProperty("webdriver.chromedriver.exe", readfile.chrome());
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		wb=new ChromeDriver(co);
		
		wb.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		
//	WebDriverManager.chromedriver().setup();
//	ChromeOptions co =new ChromeOptions();
//	co.addArguments("--remote-allow-origins=*");
//	 wb = new ChromeDriver(co);
	}
	
	else if (br.equals("firefox")) {
		System.setProperty("webdriver.geckodriver", readfile.geckodriver());
		wb=new FirefoxDriver();
		}
	wb.get(url);
	}
	
	public String generatrandomstring() {
		String geneartedstring = RandomStringUtils.randomAlphabetic(5);
		return geneartedstring;
	}
	
	@AfterClass
	public void tearDown(){
		wb.quit();
	}
	}
