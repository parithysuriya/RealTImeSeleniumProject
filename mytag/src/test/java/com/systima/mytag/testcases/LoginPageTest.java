package com.systima.mytag.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.systima.mytag.base.TestBase;
import com.systima.mytag.pages.LoginPage;



public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
    
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	
	@Test
	public void loginTest() throws InterruptedException{
		loginPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
