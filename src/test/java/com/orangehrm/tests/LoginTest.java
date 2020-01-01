package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.HomePage;

public class LoginTest extends LoginTestBase {

	HomePage homepage;
	@Test
	public void testcase1(){
		homepage = loginpage.login("admin", "admin123");
		Assert.assertEquals(loginpage.getTitle(), "OrangeHRM");
	}
}
