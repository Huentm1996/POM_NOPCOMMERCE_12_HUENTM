package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.PageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;

public class FE_03_MyAccount extends AbstractTest{
	WebDriver driver;
	Select select;
	String email,password;
	public HomePO homePage;
	public LoginPO loginPage;
	public RegisterPO registerPage;
	
	@Parameters("browser")
	  @BeforeClass
		public void beforeClass(String browserName) {
		    driver = getBrowserDriver(browserName);
		    log.info("Driver at class test = " + driver.toString());
			
			email = "jond_wick_" + randomNumber() + "@hotmail.com";
			password = "AutomationTesting";
			homePage = PageGeneratorManager.getHomePage(driver);
			
			log.info("Login");
			loginPage = homePage.openLoginPage();
			verifyTrue(loginPage.isLoginPageDisplayed());
			loginPage.inputToEmailTextbox("huetest@gmail.com");
			loginPage.inputToPasswordTextbox("123123");
			loginPage.clickToLoginButton();
			verifyTrue(homePage.isLogoutLinkDisplay());
			verifyTrue(homePage.isMyAccountLinkDisplayed());  
  }
	@Test
	public void TC_01_Customer_info() {
		
		
		
	}
}
