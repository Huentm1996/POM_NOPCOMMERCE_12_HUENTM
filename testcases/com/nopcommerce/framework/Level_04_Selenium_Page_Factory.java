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
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;



public class Level_04_Selenium_Page_Factory {
	WebDriver driver;
	Select select;
	String email;
	
	private HomePageFactory homePage;
	private LoginPageFactory loginPage;
	private RegisterPageFactory registerPage;

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
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageFactory(driver);

	}

	@Test
	public void TC_01_Register() {
		System.out.println("HomePage - Click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageFactory(driver);
		
		System.out.println("Register Page - Click to Gender radio button");
		registerPage.clickToMaleRadioButton();
		
		System.out.println("Register Page - Input to Firstname textbox");
		registerPage.inputToFirstnameTextbox("John");
		
		System.out.println("Register Page - Input to Lastname textbox");
		registerPage.inputToLastnameTextbox("Wick");

		System.out.println("Register Page - Input to Email textbox");
		registerPage.inputToEmailTextbox(email);


		System.out.println("Register Page - Input to Password textbox");
		registerPage.inputToPasswordTextbox("123123");

		
		System.out.println("Register Page - Input to Comfirm Password textbox");
		registerPage.inputToComfirmPasswordTextbox("123123");

		System.out.println("Register Page - Input to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Verify success messaga displayed");
		assertTrue(registerPage.isSuccessMessageDisplayed());
		
		assertEquals(registerPage.getSuccessMessageText(),"Your registration completed");

		System.out.println("Register Page - Click to Logout Link=>> chuyển v�? HomePage");
		registerPage.clickToLogoutLink();
		homePage = new HomePageFactory(driver);
		
	}

	@Test
	public void TC_02_Login() {
		System.out.println("HomePage - Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageFactory(driver);
		
		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox(email);
		
		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputToPasswordTextbox("123123");
		
		System.out.println("Login Page - Click to Login button >> Navigate to HomePage");
		loginPage.clickToLoginButton();
		homePage = new HomePageFactory(driver);
		
		System.out.println("Home Page - Verify My Account and Logout link displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.LogoutLinkDisplay());

	}

	@AfterClass
	public void afterClass() {
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
