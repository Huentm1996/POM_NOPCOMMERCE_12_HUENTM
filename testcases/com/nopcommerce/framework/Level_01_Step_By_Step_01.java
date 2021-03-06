package com.nopcommerce.framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Step_By_Step_01 {
	WebDriver driver;
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
		email = "jond_wick_" + randomNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register() {
//	  Click to Register
		driver.findElement(By.xpath("//a[@class='ico-register' and text()='Register']")).click();

//	  Verify Register Page displayed
		assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());

//	  Click to gender radio button
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();

//	  input to lastname textbox
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Jond");
//	  input to
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wisk");

//	  Selecr Date of birth Dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("10");

		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("October");

		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1999");

//	  input to email textbox
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

//	  input to company name
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Ninja Assassin");

//	  input to passwork textbox
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");

//	  input to Confirm_passwork textbox
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");
//	  Click to Register BTn
		driver.findElement(By.xpath("//input[@id='register-button']")).click();

//	  verify register success
		assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']")).isDisplayed());

//	  Click to logout page
		driver.findElement(By.xpath("//a[@class='ico-logout' and text()='Log out']")).click();

//	  Verify navigate to home page success
		assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_02_Login() {
// Click to Login page
		driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log in']")).click();

//	  verify login page ddc hiển thị
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed());

//	  input to email textbox
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

//	  input to passwork textbox
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");

//	  Click login btn
		driver.findElement(By.cssSelector(".login-button")).click();
//	  Verify login link displayed
		assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());

	}

	@AfterClass
	public void afterClass() {
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
