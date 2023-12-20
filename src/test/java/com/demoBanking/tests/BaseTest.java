package com.demoBanking.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demoBanking.utilities.ReadConfig;

public class BaseTest {
	
	WebDriver driver;
	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getWebApplicationUrl();
	String uName =readConfig.getUserName();
	String pwd =readConfig.getPassword();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browserType)
	{
		 
		 logger =Logger.getLogger("demoBanking");
		 PropertyConfigurator.configure("log4j.properties");
		 
		 if(browserType.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }
		 
		 if(browserType.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 
		 if(browserType.equalsIgnoreCase("edge"))
		 {
			 driver = new EdgeDriver();
		 }
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String testCaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File trt = new File(System.getProperty("user.dir")+"/screenshots/"+testCaseName+".png");
		FileUtils.copyFile(src, trt);
		System.out.println("Screenshot Taken");
	}
	

}
