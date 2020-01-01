package com.orangehrm.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orangehrm.pages.LoginPage;

public class LoginTestBase {
	LoginPage loginpage;
	
	@BeforeClass
	public void setUp(){
		loginpage = new LoginPage();
	}
	
	@AfterClass
	public void tearDown(){
		loginpage.closeOrangeHrm();
	}
}
