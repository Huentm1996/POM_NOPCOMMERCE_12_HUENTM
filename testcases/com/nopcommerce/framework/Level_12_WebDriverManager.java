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

public class Level_12_WebDriverManager extends AbstractTest {
//	private static final boolean true = false;
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
//		driver = getBrowserDriver(browserName);
		System.out.println("Driver at Class Test=" + driver.toString());
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";
		password = "AutomationTesting";
		homePage = nopCommercePageGeneratorManager.getHomePage(driver);
		
		Assert.assertTrue(false);
	}

	@Test
	public void TC_01_Register() {
		
	}
	@Test
	public void TC_02_Login() throws Exception {
			
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() 
	{
		closeBrowserAndDriver(driver);

}
}
