package com.nopcommerce.framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

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
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import nopCommerce.pageOpjects.FooterMyAccountPO;
import nopCommerce.pageOpjects.HeaderMyAccountPO;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.PageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;
import nopCommerce.pageOpjects.SearchPO;
import nopCommerce.pageOpjects.Shipping_ReturnPO;
import nopCommerce.pageOpjects.SitemapPO;

public class Level_10_Check_Element_Undisplayed extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email;
	private DriverManager driverManager;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
		
	@Parameters("browser")
	@BeforeClass
 	public void beforeClass(String browserName) {
		System.out.println("Browser Name=" + browserName);
//		Get ra browser server
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
//		Init browser driver
		driver = driverManager.getDriver();
		driver = getBrowserDriver(browserName);
		System.out.println("Driver at Class Test=" + driver.toString());
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	
	@Test
	public void TC_02_Login() {
		System.out.println("HomePage - Click to Login link");
		loginPage = homePage.openLoginPage();
		
		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox("johnwick_111222@gmail.com");
		
		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputToPasswordTextbox("123123");
		
		System.out.println("Login Page - Click to Login button >> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();
		
		System.out.println("Home Page - Verify My Account and Logout link displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.isLogoutLinkDisplay());
		
//		Not in DOM
		System.out.println("Home Page - Verify 'Register' and 'Login' link are un-displayed");
		assertFalse(homePage.isRegisterLinkUndisplayed());
		assertFalse(homePage.isLoginLinkUndisplayed());

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
