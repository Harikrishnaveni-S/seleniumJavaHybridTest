package com.demoBanking.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoBanking.pageObjects.LoginPage;
import com.demoBanking.utilities.ExcelUtil;

public class TC002 extends BaseTest{
	
	@Test(dataProvider="LoginTestData")
	public void login(String userName,String password) throws IOException{
		driver.get(url);
		logger.info("Launched WebPage Url");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered userName");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickLogin();
		logger.info("Clicked login button");
		
		String Title = driver.getTitle();
		//Assertion
		if(Title.equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Asserting actual title with the expected title of the webpage");

		}
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Asserting actual title with the expected title of the webpage - failed");

		}
	}
	
	
	@DataProvider(name="LoginTestData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\demoBanking\\testData\\loginData.xlsx";
		int rowcnt = ExcelUtil.getRowCount(path, "login");
		int colcnt = ExcelUtil.getColCount(path, "login", 0);
		String loginData[][] = new String[rowcnt][colcnt];
		
		for(int i =1 ; i<=rowcnt;i++)
		{
			for(int j = 0; j<colcnt ;j++)
			{
				loginData[i-1][j] = ExcelUtil.getCellData(path, "login", i, j);

			}
		}
		
		return loginData;
	}
	


}
