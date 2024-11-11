package com.systima.mytag.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.systima.mytag.base.TestBase;
import com.systima.mytag.pages.LoginPage;
import com.systima.mytag.pages.SettingPage;

public class SettingPageTest extends TestBase {

	SettingPage settingPage;
	LoginPage loginPage;

	public SettingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); // initializes WebDriver
		
		// Initialize LoginPage and SettingPage objects
		loginPage = new LoginPage();
		settingPage = new SettingPage();

		// Perform login action using credentials from properties file
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void settingTest() throws InterruptedException {
		// Open the settings page
		settingPage.openSettings();

		// Fill out the settings form
		settingPage.fillOutSettingsForm("John", "Doe", "pandian@yopmail.com", "1234567123");

	}
}
