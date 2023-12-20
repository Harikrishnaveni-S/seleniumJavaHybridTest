package com.demoBanking.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoBanking.pageObjects.LoginPage;

public class TC_001 extends BaseTest{
	
	@Test
	public void LoginTest() throws IOException
	{
		driver.get(url);
		logger.info("Launched WebPage Url");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uName);
		logger.info("Entered userName");
		lp.setPassword(pwd);
		logger.info("Entered password");
		lp.clickLogin();
		logger.info("Clicked login button");
		
		String Title = driver.getTitle();
		//Assertion
		if(Title.equals("GTPL Bank Mnager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Asserting actual title with the expected title of the webpage");

		}
//		Assert.assertEquals(Title, "GTPL Bank Mnager HomePage");
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Asserting actual title with the expected title of the webpage - failed");

		}
//		logger.info("Asserting actual title with the expected title of the webpage");
	}

}
