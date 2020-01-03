package com.nopcommerce.search;

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

import com.nopcommerce.common.Common_01_RegisterToSystem;

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

public class Search_01 extends AbstractTest {
	private WebDriver driver;

	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	
	@Parameters("browser")
	@BeforeClass
 	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
//		Login
		log.info("Precondition - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		
		log.info("Precondition - Step 02: Verify Login Page is displayed");
//		verifyFalse(loginPage.isLoginPageDisplayed());
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		log.info("Precondition - Step 03: Input to email and password textbox");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.EMAIL);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);
		
		log.info("Precondition - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_SearchWithName() {
		System.out.println("TC_01_SearchWithName");
	}
	@Test
	public void TC_02_SearchCategory() {
		System.out.println("TC_02_SearchCategor");
		
	}
	@Test
	public void TC_03_Manufactory() {
		System.out.println("TC_03_Manufactory");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
