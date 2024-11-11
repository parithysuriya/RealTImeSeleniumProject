package com.systima.mytag.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.systima.mytag.base.TestBase;

public class CardsPage extends TestBase {

	// Page Factory
	@FindBy(xpath = "//span[text()=' Add Card ']")
	WebElement addcard;

	@FindBy(css = "select[formcontrolname='selectedCardNo']")
	WebElement selectCardNo;

	@FindBy(xpath = "//button[text()=' Ok ']")
	WebElement okButton;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//p[text()='Edit']")
	WebElement edit;

	@FindBy(xpath = "//p-fileupload/div/span")
	WebElement profilephoto;

//	@FindBy(css = "button.bg-primary.text-white:first-of-type")
//	WebElement Headsavebutton;

	@FindBy(className = "ngx-ic-square")
	WebElement crop;

	@FindBy(css = "button.bg-primary.text-white.font-semibold.hover\\:text-white.py-1.px-8.border.border-primary.hover\\:border-primary.rounded")
	WebElement savebutton;

	@FindBy(css = ".bg-gray-200:nth-child(2) .p-button-icon")
	WebElement companylogo;

	@FindBy(css = "button[class='bg-primary text-white font-semibold hover:text-white py-1 px-8 border border-primary hover:border-primary rounded']")
	WebElement savebutton1;

	@FindBy(css = "button[style*='background-color: rgb(217, 38, 50)']")
	WebElement choosecolor;

	@FindBy(id = "tag")
	WebElement checkavai;

	@FindBy(css = "button.mt-2.border.border-primary.text-primary")
	WebElement checkAvailabilityButton;

	@FindBy(id = "first-name")
	WebElement firstname;

	@FindBy(id = "last-name")
	WebElement lastname;

	@FindBy(id = "job-title")
	WebElement jobtitle;

	@FindBy(id = "department")
	WebElement department;

	@FindBy(xpath = "(//input[@id='last-name'])[2]")
	WebElement company;

	@FindBy(id = "headline")
	WebElement headline;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement next1;

	// STEP2

	@FindBy(xpath = "//select[@id='type']")
	WebElement contacttype;

	@FindBy(css = "select#type[formcontrolname='label']")
	WebElement label;

	@FindBy(id = "mobile")
	WebElement mobile;

	@FindBy(xpath = "(//select[@id='type'])[3]")
	WebElement emaillabel;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "website")
	WebElement website;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "zip")
	WebElement zip;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement next2;

	// STEP 3
	@FindBy(id = "link")
	WebElement fb;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement next3;

	// STEP 4
	@FindBy(id = "desc")
	WebElement title;

	@FindBy(id = "label")
	WebElement label1;

	@FindBy(id = "link")
	WebElement url;

	@FindBy(id = "title")
	WebElement Ytitle;

	@FindBy(xpath = "(//input[@id='link'])[2]")
	WebElement Ylink;

	@FindBy(id = "imgtitle")
	WebElement htitle;

	@FindBy(css = "span.p-fileupload-choose")
	WebElement himage;

	@FindBy(xpath = "(//input[@id='imgtitle'])[3]")
	WebElement ftitle;

	@FindBy(css = "span.p-fileupload-choose")
	WebElement fimage;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;

	@FindBy(css = ".flex.items-center.justify-between.ltr.px-3.py-2.w-full")
	WebElement bcolor;

	// Delete Card Functionality
	@FindBy(className = "pl-4")
	WebElement Cards;

	@FindBy(id = "default-search")
	WebElement search;

	@FindBy(xpath = "//img[@alt='photo']")
	WebElement selectCard;

	@FindBy(className = "pl-1")
	WebElement delete;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Dyes;

	// Logout Functionality
	@FindBy(xpath = "//span[text()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement Lyes;

	// Initializing the Page Objects:
	public CardsPage() {
		PageFactory.initElements(driver, this);
	}

	private void uploadFile(String filePath) throws AWTException, InterruptedException {
		Robot rb = new Robot();
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public void addCard() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(addcard)).click();

		Select select = new Select(selectCardNo);
		select.selectByIndex(1);
		wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
		js.executeScript("arguments[0].click();", continueButton);
		js.executeScript("arguments[0].click();", edit);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(profilephoto)).click();
		uploadFile("/home/systimanx/surya.jpg");

		Thread.sleep(2000);
		// crop the picture
		Actions actions = new Actions(driver);
		// Click and hold the cropper handle, move it, and then release
		actions.clickAndHold(crop).moveByOffset(5, 5).release().perform();

		Thread.sleep(2000);

		js.executeScript("arguments[0].click();", savebutton);

		// click the company logo
		wait.until(ExpectedConditions.elementToBeClickable(companylogo)).click();
		Thread.sleep(2000);
		uploadFile("/home/systimanx/no.png");

		js.executeScript("arguments[0].click();", savebutton1);

		wait.until(ExpectedConditions.elementToBeClickable(choosecolor)).click();

		checkavai.sendKeys("suriyanntester");
		js.executeScript("arguments[0].click();", checkAvailabilityButton);

		firstname.sendKeys("suriyan test");
		lastname.sendKeys("last");
		jobtitle.sendKeys("Automation");
		department.sendKeys("TEST DEPT");
		company.sendKeys("suriyasys");
		headline.sendKeys("Headline");
		wait.until(ExpectedConditions.elementToBeClickable(next1)).click();

		// STEP 2

		wait.until(ExpectedConditions.elementToBeClickable(contacttype)).click();

		Select select2 = new Select(contacttype);
		select2.selectByVisibleText("Mobile");

		Select select3 = new Select(label);
		select3.selectByVisibleText("Mobile");

		mobile.sendKeys("8344412907");

		Select select4 = new Select(emaillabel);
		select4.selectByVisibleText("Personal");

		email.sendKeys("tesgt@yopmail.com");

		website.sendKeys("https://suriyaparithy.blogspot.com");

		address1.sendKeys("south street");
		address2.sendKeys("94");
		city.sendKeys("Madurai");
		state.sendKeys("TN");
//		js.executeScript("arguments[0].click();", country);
//		country.sendKeys("India");
		zip.sendKeys("625703");

		next2.click();

		// STEP 3
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", fb);
		fb.sendKeys("https://suriyaparithy.blogspot.com");
		next3.click();

		// STEP 4
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(title)).click();
		title.sendKeys("My BLOG");
		label1.sendKeys("Blog");
		url.sendKeys("https://suriyaparithy.blogspot.com");
		Ytitle.sendKeys("Learning");
		Ylink.sendKeys("https://youtu.be/QvTo1_-n0UE?si=a15mEcnCMYHivyRC");
		htitle.sendKeys("Header title");

		himage.click();
		Thread.sleep(2000);
		uploadFile("/home/systimanx/header.png");
		js.executeScript("arguments[0].click();", savebutton);

		wait.until(ExpectedConditions.elementToBeClickable(ftitle)).click();
		ftitle.sendKeys("Footer title");
		fimage.click();
		Thread.sleep(2000);
		uploadFile("/home/systimanx/footer.png");

		wait.until(ExpectedConditions.elementToBeClickable(save)).click();

		Thread.sleep(3000);

		// Get the background color using CSS value
		String backgroundColor = bcolor.getCssValue("background-color");
		// Print the background color
		System.out.println("Background color: " + backgroundColor);

		// Verify if the background color matches the expected color
		String expectedColor = "rgba(217, 38, 50, 1)"; // RGBA for #D92632
		if (backgroundColor.equals(expectedColor)) {
			System.out.println("Background color verification passed - Red #D92632 .");
		} else {
			System.out.println("Background color verification failed. Expected: " + expectedColor + " but found: "
					+ backgroundColor);
		}

		// Card Delete Functionality
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", Cards);

		Thread.sleep(2000);
		search.clear();
		search.sendKeys("00155");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(selectCard)).click();

		js.executeScript("arguments[0].click();", delete);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Dyes);

		// Logout Functionality
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", logout);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", Lyes);

		// CODE WORKING FINE

	}
}
