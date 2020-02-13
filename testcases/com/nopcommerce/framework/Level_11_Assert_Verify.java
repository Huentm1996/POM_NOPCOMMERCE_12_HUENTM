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
import nopCommerce.pageOpjects.nopCommercePageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;
import nopCommerce.pageOpjects.SearchPO;
import nopCommerce.pageOpjects.Shipping_ReturnPO;
import nopCommerce.pageOpjects.SitemapPO;

public class Level_11_Assert_Verify extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email, password;
	private DriverManager driverManager;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	
	@Parameters("browser")
	@BeforeClass
 	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println("Driver at Class Test=" + driver.toString());
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";
		password = "AutomationTesting";
		homePage = nopCommercePageGeneratorManager.getHomePage(driver);
		
		log.info("Preconditon - Step 01: Click to Register link");
		log.info("Preconditon - Step 01: Click to Register link");
		log.info("Preconditon - Step 01: Click to Register link");
	}

	@Test
	public void TC_01_Register() {

		
		log.info("Register - Step 01: Click to Register link");
		registerPage = homePage.openRegisterPage(driver);
		
		log.info("Register - Step 02: Verify Register is displayed");
//		assertTrue(registerPage.isRegisterPageDisplayed());
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Register - Step 03: Input data to all required fields");
		registerPage.clickToGenderRadioButton();
		registerPage.inputToFirstnameTextbox("John");
		registerPage.inputToLastnameTextbox("Wick");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToComfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 04: Verify success messaga displayed-01");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 05: Verify success messaga displayed-02");
		verifyEquals(registerPage.getSuccessMessageText(),"Your registration completed");

		log.info("Register - Step 06: Click to Logout Link=>> chuyển về HomePage");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() throws Exception {
		log.info("Login - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		
		Thread.sleep(3000);
		log.info("Login - Step 02: Verify Login Page is displayed");
//		verifyFalse(loginPage.isLoginPageDisplayed());
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		log.info("Login - Step 03: Input to email and password textbox");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify My Account and Logout link displayed");
//		verifyFalse(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		verifyTrue(homePage.isLogoutLinkDisplay());
		
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
