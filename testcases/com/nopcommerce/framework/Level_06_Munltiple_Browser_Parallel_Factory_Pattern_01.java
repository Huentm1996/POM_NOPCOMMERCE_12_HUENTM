package com.nopcommerce.framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageObject;
import commons.AbstractTest;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.PageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;

public class Level_06_Munltiple_Browser_Parallel_Factory_Pattern_01 extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser Name=" + browserName);
		
		driver = getBrowserDriver(browserName);
		System.out.println("Driver at Class Test=" + driver.toString());
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		System.out.println("Open Url - Navigate den trang Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		System.out.println("HomePage - Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
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
		homePage = registerPage.clickToLogoutLink();
		
	}

	@Test
	public void TC_02_Login() {
		System.out.println("HomePage - Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox(email);
		
		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputToPasswordTextbox("123123");
		
		System.out.println("Login Page - Click to Login button >> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();
		
		System.out.println("Home Page - Verify My Account and Logout link displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.isLogoutLinkDisplay());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
