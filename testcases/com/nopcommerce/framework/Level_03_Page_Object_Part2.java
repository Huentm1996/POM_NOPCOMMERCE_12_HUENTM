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
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.RegisterPO;



public class Level_03_Page_Object_Part2 {
	WebDriver driver;
	Select select;
	String email;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;

	@BeforeClass
	public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");

		driver = new FirefoxDriver();
//		driver =ID
		System.out.println("Driver ID = " + driver.toString());
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePO(driver);

	}

	@Test
	public void TC_01_LoginWithEmailAndPasswordEmpty() {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
//		Verify
	}

	@Test
	public void TC_02_LoginWithEmailEmpty() {


		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
//		Verify

	}
	
	@Test
	public void TC_03_LoginWithEmailAndPasswordEmpty() {
		loginPage.inputToEmailTextbox("auto@gmail");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
//		Verify
	}
	@Test
	public void TC_04_LoginWithEmailNotExistingInSystem() {
		loginPage.inputToEmailTextbox("auto@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

//		Verify
	}
	
	@Test
	public void TC_05_LoginWithEmailInvalid() {
		loginPage.inputToEmailTextbox("auto@gmail@hotmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

//		Verify
	}
	
	@Test
	public void TC_06_LoginWithPasswordLessThan6Chars() {
		loginPage.inputToEmailTextbox("auto@gmail@hotmail.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

//		Verify
	}
	
	@Test
	public void TC_07_LoginWithPasswordIncorrect() {
		loginPage.inputToEmailTextbox("auto@gmail.com");
		loginPage.inputToPasswordTextbox("123123123");
		loginPage.clickToLoginButton();

//		Verify
	}
	
	@Test
	public void TC_08_LoginWithEmailAndPasswordValid() {
		loginPage.inputToEmailTextbox("auto@gmail.com");
		loginPage.inputToPasswordTextbox("11111");
		loginPage.clickToLoginButton();

//		Homepage
	}
	@AfterClass
	public void afterClass() {
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
