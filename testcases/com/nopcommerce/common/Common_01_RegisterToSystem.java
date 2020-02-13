package com.nopcommerce.common;

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
import org.testng.annotations.BeforeTest;
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
import nopCommerce.pageOpjects.nopCommercePageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;
import nopCommerce.pageOpjects.SearchPO;
import nopCommerce.pageOpjects.Shipping_ReturnPO;
import nopCommerce.pageOpjects.SitemapPO;

public class Common_01_RegisterToSystem extends AbstractTest {
	private WebDriver driver;
	Select select;
	public static String EMAIL, PASSWORD;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	
	@Parameters("browser")
	@BeforeTest
 	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		EMAIL = "jond_wick_" + randomNumber() + "@hotmail.com";
		PASSWORD = "Pass111@@@";
		homePage = nopCommercePageGeneratorManager.getHomePage(driver);
		
		log.info("Register - Step 01: Click to Register link");
		registerPage = homePage.openRegisterPage(driver);
		
		log.info("Register - Step 02: Verify Register is displayed");
//		assertTrue(registerPage.isRegisterPageDisplayed());
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Register - Step 03: Input data to all required fields");
		registerPage.clickToGenderRadioButton();
		registerPage.inputToFirstnameTextbox("John");
		registerPage.inputToLastnameTextbox("Wick");
		registerPage.inputToEmailTextbox(EMAIL);
		registerPage.inputToPasswordTextbox(PASSWORD);
		registerPage.inputToComfirmPasswordTextbox(PASSWORD);
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 04: Verify success messaga displayed-01");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 05: Verify success messaga displayed-02");
		verifyEquals(registerPage.getSuccessMessageText(),"Your registration completed");

		log.info("Register - Step 06: Click to Logout Link=>> chuyển về HomePage");
		homePage = registerPage.clickToLogoutLink();
		driver.quit();
	}

}