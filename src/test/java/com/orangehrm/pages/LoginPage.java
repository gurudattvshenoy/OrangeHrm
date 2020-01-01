package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utils.UiHelper;

public class LoginPage {

	UiHelper _uihelper = new UiHelper();
	WebDriver _driver = _uihelper.getDriver();
	public static By _txtUsername = By.id("txtUsername");
	public static By _txtPassword = By.id("txtPassword");
	public static By _btnLogin = By.id("btnLogin");
	
	public LoginPage(){
		System.out.println("----"+_uihelper.getOrangeHrmUrl());
		_uihelper.get(_uihelper.getOrangeHrmUrl());
	}
	
	//Action in the Login Page of OrangeHrm
	public String validateLoginPageTitle(){
		return _driver.getTitle();
	}
	
	public String getTitle(){
		return _uihelper.getTitle();
	}
	
	public HomePage login(String username,String password)
	{
		_uihelper.sendKeys(_txtUsername, username);
		_uihelper.sendKeys(_txtPassword, password);
		_uihelper.clickWaitUntilElementClickable(_btnLogin);
		return new HomePage();
		
	}
	
	public void closeOrangeHrm(){
		_uihelper.quitDriver();
	}
}
