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

public class Level_09_Dynamic_Rest_Parameter extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email;
	private DriverManager driverManager;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private SitemapPO sitemapPage;
	private Shipping_ReturnPO shippingreturnPage;
	private HeaderMyAccountPO headerMyAccountPage;
	private FooterMyAccountPO footerMyAccountPage;
	private SearchPO searchPage;	
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
	public void TC_01_Register() {
		System.out.println("Open Url - Navigate den trang Home Page");
		homePage = nopCommercePageGeneratorManager.getHomePage(driver);
		
		System.out.println("HomePage - Click to Register link");
		registerPage = homePage.openRegisterPage(driver);
		
		System.out.println("Register Page - Click to Gender radio button");
		registerPage.clickToGenderRadioButton();
		
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
		loginPage = homePage.openLoginPage(driver);
		
		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox("johnwick_111222@gmail.com");
		
		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputToPasswordTextbox("123123");
		
		System.out.println("Login Page - Click to Login button >> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();
		
		System.out.println("Home Page - Verify My Account and Logout link displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.isLogoutLinkDisplay());

	}
	@Test
	public void TC_03_LessPage_Dynamic_Locator() {
//		HomePage ->> Footer My Account (Customer info)
		footerMyAccountPage = (FooterMyAccountPO) homePage.openMultiplenNopCommercePage("My account");
		
//		Footer My Account -> Site Map
		sitemapPage = (SitemapPO) footerMyAccountPage.openMultiplenNopCommercePage("Sitemap");
		
//		Site map -> Shipping & returns
		shippingreturnPage = (Shipping_ReturnPO) sitemapPage.openMultiplenNopCommercePage("Shipping & returns");
		
//		Shipping & return ->> Footer My Account
		footerMyAccountPage = (FooterMyAccountPO) shippingreturnPage.openMultiplenNopCommercePage("My account");
		
//		Footer My Account ->> Search
		searchPage = (SearchPO) footerMyAccountPage.openMultiplenNopCommercePage("Search");
		
//		Search ->> Shipping & returns
		shippingreturnPage = (Shipping_ReturnPO) searchPage.openMultiplenNopCommercePage("Shipping & returns");
		
//		Shipping & return ->> Footer My Account
		footerMyAccountPage = (FooterMyAccountPO) shippingreturnPage.openMultiplenNopCommercePage("My account");
	}
	
	@Test
	public void TC_04_ManyPage_Dynamic_Locator() {
//		HomePage ->> Footer My Account (Customer info)
		homePage.openMultiplePages("My account");
		footerMyAccountPage = nopCommercePageGeneratorManager.getFooterMyAccountPage(driver);
//		Assert.assertTrue(footerMyAccountPage.isfooterMyAccountPageDisplayed());
		
//		Footer My Account -> Site Map
		footerMyAccountPage.openMultiplePages("Sitemap");
//		Tính đóng gói (Encapsolution)
		sitemapPage = nopCommercePageGeneratorManager.getSitemapPage(driver);
		
//		Site map -> Shipping & returns
		sitemapPage.openMultiplePages("Shipping & returns");
		shippingreturnPage = nopCommercePageGeneratorManager.getShipping_ReturnPage(driver);
			
//		Shipping & return ->> Footer My Account
		shippingreturnPage.openMultiplePages("My account");
		footerMyAccountPage = nopCommercePageGeneratorManager.getFooterMyAccountPage(driver);
		
//		Footer My Account ->> Search
		footerMyAccountPage.openMultiplePages("Search");
		searchPage = nopCommercePageGeneratorManager.getSearchPage(driver);
		
//		Search ->> Shipping & returns
		searchPage.openMultiplePages("Shipping & returns");
		shippingreturnPage = nopCommercePageGeneratorManager.getShipping_ReturnPage(driver);

//		Shipping & return ->> Footer My Account
		shippingreturnPage.openMultiplePages("My account");
		footerMyAccountPage = nopCommercePageGeneratorManager.getFooterMyAccountPage(driver);
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
