package com.systima.mytag.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.systima.mytag.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory 
//	@FindBy(linkText = "Login")
//	WebElement loginlink;

	@FindBy(css = ".p-inputgroup > .p-inputtext")
	WebElement username;

	@FindBy(css = ".p-password-input")
	WebElement password;

	@FindBy(css = ".bg-primary")
	WebElement loginBtn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage login(String un, String pwd) throws InterruptedException {
//		loginlink.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
//        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		Thread.sleep(3000);

		return new LoginPage();

	}
}
