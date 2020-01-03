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

public class Level_13_Dynamic_Page_Element extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email, textboxID;
	String password;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser Name=" + browserName);
		
		driver = getBrowserDriver(browserName);
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";
		password = "AutomationTesting";
		homePage = PageGeneratorManager.getHomePage(driver);

	}
	@Test
	public void TC_01_Validate_Register_Form() {
		log.info("Validate - Step_01: Click to register link");
		registerPage = homePage.openRegisterPage(driver);
		
		log.info("Validate - Step_02: Click to register button");
		registerPage.clickToDynamicButton("Register");

		log.info("Validate - Step_03: Verify error message displayed at required fields");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("FirstName"), "First name is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("LastName"), "Last name is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("Email"), "Email is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("Password"), "Password is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("ConfirmPassword"), "ConfirmPassword-error");
	}
	@Test
	public void TC_02_Register() {

		
		log.info("Register - Step 01: Click to Register link");
		registerPage.openRegisterPage(driver);
		
		log.info("Register - Step 02: Verify Register is displayed");
//		assertTrue(registerPage.isRegisterPageDisplayed());
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Register - Step 03: Input data to all required fields");
//		registerPage.clickToMaleRadioButton();
		registerPage.clickToDynamicRadioButton("gender-male");
		
//		registerPage.inputToFirstnameTextbox("John");
		registerPage.inputToDynamicTextbox("FirstName", "John");
		
//		registerPage.inputToLastnameTextbox("Wick");
		registerPage.inputToDynamicTextbox("LastName", "Wick");
		
//		registerPage.inputToEmailTextbox(email);
		registerPage.inputToDynamicTextbox("Email", email);
		
//		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToDynamicTextbox("Password", password);
		registerPage.inputToDynamicTextbox("Company", "John Wick Assassin");
		
		registerPage.inputToDynamicTextbox("ConfirmPassword", password);
		
//		registerPage.clickToRegisterButton();
		registerPage.clickToDynamicButton("Register");
		
		log.info("Register - Step 04: Verify success messaga displayed-01");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 05: Verify success messaga displayed-02");
		verifyEquals(registerPage.getSuccessMessageText(),"Your registration completed");

		log.info("Register - Step 06: Click to Logout Link=>> chuyển về HomePage");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_03_Login() throws Exception {
		log.info("Login - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		
		Thread.sleep(3000);
		log.info("Login - Step 02: Verify Login Page is displayed");
//		verifyFalse(loginPage.isLoginPageDisplayed());
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		log.info("Login - Step 03: Input to email and password textbox");
//		loginPage.inputToEmailTextbox(email);
		loginPage.inputToDynamicTextbox("Email", email);
		
//		loginPage.inputToPasswordTextbox(password);
		loginPage.inputToDynamicTextbox("Password", "password");
		
		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToDynamicButton("Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Login - Step 05: Verify My Account and Logout link displayed");
//		verifyFalse(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		verifyTrue(homePage.isLogoutLinkDisplay());
		
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}



}
