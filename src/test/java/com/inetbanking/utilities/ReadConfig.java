package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public  ReadConfig() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\manjula\\selenium\\MyStoreProject\\Configuration\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String url() {
		return prop.getProperty("url");
	}
	
	public String username() {
		return prop.getProperty("username");
	}
	
	public String password() {

		return prop.getProperty("password");
		
	}
	
	public String chrome() {
		return prop.getProperty("chromepath");
		
	}
	
	public String geckodriver() {
		return prop.getProperty("geckodriver");
		
	}
}