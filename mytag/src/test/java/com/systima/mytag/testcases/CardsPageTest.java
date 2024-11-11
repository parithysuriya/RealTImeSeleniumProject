package com.systima.mytag.testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.systima.mytag.base.TestBase;
import com.systima.mytag.pages.CardsPage;
import com.systima.mytag.pages.LoginPage;

public class CardsPageTest extends TestBase{
	CardsPage cardsPage;
	LoginPage loginPage;
	
	public CardsPageTest() {
		super();
	}	
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); // initializes WebDriver
		
		// Initialize LoginPage and SettingPage objects
		loginPage = new LoginPage();
		cardsPage = new CardsPage();

		// Perform login action using credentials from properties file
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
  @Test
  public void addcardTest() throws InterruptedException, AWTException {
	  cardsPage.addCard();
	  
  }
}
