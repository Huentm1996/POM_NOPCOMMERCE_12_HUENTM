package com.nopcommerce.frontend;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.PageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;

public class FE_02_Login extends AbstractTest{
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
	  
  }
  @Test
  public void TC_01_Login_with_EmptyData() {
	  log.info("Login - Step 01: Login Link");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Verify Login is displayed");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("Login - Step 03: Input data to all required fields");
	  loginPage.inputToEmailTextbox("");
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();  
	  
	  log.info("Login - Step 04: Click to login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify My Account and Logout link displayed");
	  verifyFalse(homePage.isMyAccountLinkDisplayed());
	  verifyFalse(homePage.isLogoutLinkDisplay());
  }
  
  @Test
  public void TC_02_Login_with_InvalidEmail() {
	  log.info("Login - Step 01: Login Link");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Verify Login is displayed");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("Login - Step 03: Input data to all required fields");
	  loginPage.inputToEmailTextbox("");
	  loginPage.inputToPasswordTextbox(password);
	  loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 04: Click to login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify My Account and Logout link displayed");
	  verifyFalse(homePage.isMyAccountLinkDisplayed());
	  verifyFalse(homePage.isLogoutLinkDisplay());
  }
  
  @Test
  public void TC_03_Login_with_UnRegisteredEmail() {
	  log.info("Login - Step 01: Login Link");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Verify Login is displayed");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("Login - Step 03: Input data to all required fields");
	  loginPage.inputToEmailTextbox("NguyenHue@gmail.com");
	  loginPage.inputToPasswordTextbox("123123");
	  loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 04: Click to login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify My Account and Logout link displayed");
	  verifyFalse(homePage.isMyAccountLinkDisplayed());
	  verifyFalse(homePage.isLogoutLinkDisplay());  
  }
  @Test
  public void TC_04_Login_with_RegisteredEmail_emptyPassword() {
	  log.info("Login - Step 01: Login Link");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Verify Login is displayed");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("Login - Step 03: Input data to all required fields");
	  loginPage.inputToEmailTextbox("huetest@gmail.com");
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 04: Click to login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify My Account and Logout link displayed");
	  verifyFalse(homePage.isMyAccountLinkDisplayed());
	  verifyFalse(homePage.isLogoutLinkDisplay());  
  }
  @Test
  public void TC_05_Login_with_RegisteredEmail_WrongPassword() {
	  log.info("Login - Step 01: Login Link");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Verify Login is displayed");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("Login - Step 03: Input data to all required fields");
	  loginPage.inputToEmailTextbox("huetest@gmail.com");
	  loginPage.inputToPasswordTextbox("1111");
	  loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 04: Click to login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify My Account and Logout link displayed");
	  verifyFalse(homePage.isMyAccountLinkDisplayed());
	  verifyFalse(homePage.isLogoutLinkDisplay());  
  }
  @Test
  public void TC_06_Login_with_Valid() {
	  log.info("Login - Step 01: Login Link");
	  loginPage = homePage.openLoginPage();
	  
	  log.info("Login - Step 02: Verify Login is displayed");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("Login - Step 03: Input data to all required fields");
	  loginPage.inputToEmailTextbox("huetest@gmail.com");
	  loginPage.inputToPasswordTextbox("123123");
	  loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 04: Click to login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify My Account and Logout link displayed");
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
