package com.nopcommerce.framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPageObject;



public class Level_02_AbstractPage_01 {
	WebDriver driver;
	AbstractPageObject abstractPage  ;
	Select select;
	String email;

	@BeforeClass
	public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
//	  G:\auto onl 12\03_Java_pageObject
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");

		driver = new FirefoxDriver();
//		driver =ID
		System.out.println("Driver ID = " + driver.toString());
		
		abstractPage = new AbstractPageObject(driver);
		email = "jond_wick_" + randomNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register() {
//	  Click to Register
//		driver.findElement(By.xpath("//a[@class='ico-register' and text()='Register']")).click();
		abstractPage.ClickToElement("//a[@class='ico-register' and text()='Register']");
//	  Verify Register Page displayed
//		assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//div[@class='page registration-page']"));
		
//	  Click to gender radio button
//		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		abstractPage.ClickToElement("//input[@id='gender-female']");

//	  input to lastname textbox
//		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Jond");
		abstractPage.sendkeyToElement("//input[@id='FirstName']", "Jond");
		
//	  input to
//		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wisk");
		abstractPage.sendkeyToElement("//input[@id='LastName']", "Wisk");


//	  Selecr Date of birth Dropdown
//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
//		select.selectByVisibleText("10");
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "10");

//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
//		select.selectByVisibleText("October");
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "October");

//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
//		select.selectByVisibleText("1999");
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1999");

//	  input to email textbox
//		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		abstractPage.sendkeyToElement("//input[@id='Email']", email);

//	  input to company name
//		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Ninja Assassin");
		abstractPage.sendkeyToElement("//input[@id='Company']", "Ninja Assassin");

//	  input to passwork textbox
//		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
		abstractPage.sendkeyToElement("//input[@id='Password']", "123123");

//	  input to Confirm_passwork textbox
//		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");
		abstractPage.sendkeyToElement("//input[@id='ConfirmPassword']", "123123");

		
//	  Click to Register BTn
//		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		abstractPage.ClickToElement("//input[@id='register-button']");
		

//	  verify register success
//		assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']")).isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//div[@class='result' and text()='Your registration completed']"));

//	  Click to logout page
//		driver.findElement(By.xpath("//a[@class='ico-logout' and text()='Log out']")).click();
		abstractPage.ClickToElement("//a[@class='ico-logout' and text()='Log out']");

//	  Verify navigate to home page success
//		assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
		assertEquals(abstractPage.getPageCurrentUrl(), "https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_02_Login() {
// Click to Login page
//		driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log in']")).click();
		abstractPage.ClickToElement("//a[@class='ico-login' and text()='Log in']");


//	  verify login page ddc hiển thị
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed());
		abstractPage.isElementDisplayed("//div[@class='page login-page']");

//	  input to email textbox
//		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		abstractPage.sendkeyToElement("//input[@id='Email']", email);

//	  input to passwork textbox
//		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
		abstractPage.sendkeyToElement("//input[@id='Password']", "123123");

//	  Click login btn
//		driver.findElement(By.cssSelector(".login-button")).click();
		abstractPage.ClickToElement("//input[@class='button-1 login-button']");
		
//	  Verify login link displayed
//		assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account' and text()='My account']"));

	}

	@AfterClass
	public void afterClass() {
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
