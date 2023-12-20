package com.demoBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@name=\"uid\"]")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement password;
	
	@FindBy(xpath="//*[@name=\"btnLogin\"]")
	private WebElement loginBtn;
	
	
	public void setUserName(String uName)
	{
		userName.sendKeys(uName);
	}
	
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void clickLogin()
	{
		loginBtn.click();
	}
}
