package com.systima.mytag.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.systima.mytag.base.TestBase;

public class SettingPage extends TestBase {

	// Page Factory
	@FindBy(css = ".hover\\3A cursor-pointer:nth-child(3) .pl-4")
	WebElement Setting;

	@FindBy(id = "firstname")
	WebElement Firstname;

	@FindBy(id = "lastname")
	WebElement Lastname;

	@FindBy(id = "email")
	WebElement Email;

	@FindBy(id = "phone")
	WebElement Phone;

	@FindBy(css = ".bg-primary")
	WebElement Save;

	// Initializing the Page Objects:
	public SettingPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to perform settings page actions
	public void openSettings() throws InterruptedException {
		Setting.click();
		// Add more interactions if needed
	}

	public void fillOutSettingsForm(String fname, String lname, String email, String phone) throws InterruptedException {
		// Wait for the elements to be visible before interacting
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Firstname));

		Thread.sleep(3000);
		// Clear fields before entering new values
		Firstname.clear();
		Firstname.sendKeys(fname);

		Lastname.clear();
		Lastname.sendKeys(lname);

		Email.clear();
		Email.sendKeys(email);

		Phone.clear();
		Phone.sendKeys(phone);

		// Click save button
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		Save.click();
	}
}
