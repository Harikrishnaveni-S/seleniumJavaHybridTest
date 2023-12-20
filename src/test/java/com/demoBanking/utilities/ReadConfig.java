package com.demoBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		File file = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getWebApplicationUrl()
	{
		String url = prop.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName()
	{
		String userName = prop.getProperty("userName");
		return userName;
	}

	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
}
