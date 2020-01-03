package com.nopcommerce.frontend;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class FE_01_Register extends AbstractTest{
	private WebDriver driver;
	Select select;
	String email, password;
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
  public void TC_01_Register_with_emptydata() {
	  log.info("Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage(driver);
	  
	  log.info("Register - Step 02: Verify Register is displayed");
	  verifyTrue(registerPage.isRegisterPageDisplayed());
	    
	  log.info("Register - Step 03: Input data to all required fields");
	  registerPage.inputToFirstnameTextbox("");
	  registerPage.inputToLastnameTextbox("");
	  registerPage.inputToEmailTextbox("");
	  registerPage.inputToPasswordTextbox("");
	  registerPage.inputToComfirmPasswordTextbox("");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 04: Verify success message displayed-01");
	  verifyFalse(registerPage.isSuccessMessageDisplayed());
	  
	  log.info("Register - Step 05: Verify success massage displayed-02");
//	  verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
	  
	  log.info("Register - Step 06: Click to Logout Link");
	  homePage = registerPage.clickToLogoutLink();
	  }
  
  @Test
  public void TC_02_Register_with_InvalidEmail(){
	  log.info("Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage(driver);
	  
	  log.info("Register - Step 02: Verify Register is displayed");
	  verifyTrue(registerPage.isRegisterPageDisplayed());
	    
	  log.info("Register - Step 03: Input data to all required fields");
	  registerPage.clickToMaleRadioButton();
	  registerPage.inputToFirstnameTextbox("John");
	  registerPage.inputToLastnameTextbox("Wick");
	  registerPage.inputToEmailTextbox("");
	  registerPage.inputToPasswordTextbox("123123");
	  registerPage.inputToComfirmPasswordTextbox("123123");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 04: Verify success message displayed-01");
	  verifyFalse(registerPage.isSuccessMessageDisplayed());
	  
	  log.info("Register - Step 05: Verify success massage displayed-02");
//	  verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
	  
	  log.info("Register - Step 06: Click to Logout Link");
	  homePage = registerPage.clickToLogoutLink();
  }
  @Test
  public void TC_03_Register_with_EmailAlreadyExists() {
	  log.info("Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage(driver);
	  
	  log.info("Register - Step 02: Verify Register is displayed");
	  verifyTrue(registerPage.isRegisterPageDisplayed());
	    
	  log.info("Register - Step 03: Input data to all required fields");
	  registerPage.clickToMaleRadioButton();
	  registerPage.inputToFirstnameTextbox("John");
	  registerPage.inputToLastnameTextbox("Wick");
	  registerPage.inputToEmailTextbox("John_Wick_11111@gmail.com");
	  registerPage.inputToPasswordTextbox("123123");
	  registerPage.inputToComfirmPasswordTextbox("123123");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 04: Verify success message displayed-01");
	  verifyFalse(registerPage.isSuccessMessageDisplayed());
	  
	  log.info("Register - Step 05: Verify success massage displayed-02");
//	  verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
	  
	  log.info("Register - Step 06: Click to Logout Link");
	  homePage = registerPage.clickToLogoutLink();
  }
  @Test
  public void TC_04_Register_with_PasswordLessThan6Chars() {
	  log.info("Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage(driver);
	  
	  log.info("Register - Step 02: Verify Register is displayed");
	  verifyTrue(registerPage.isRegisterPageDisplayed());
	    
	  log.info("Register - Step 03: Input data to all required fields");
	  registerPage.clickToMaleRadioButton();
	  registerPage.inputToFirstnameTextbox("John");
	  registerPage.inputToLastnameTextbox("Wick");
	  registerPage.inputToEmailTextbox(email);
	  registerPage.inputToPasswordTextbox("1231");
	  registerPage.inputToComfirmPasswordTextbox("1231");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 04: Verify success message displayed-01");
	  verifyFalse(registerPage.isSuccessMessageDisplayed());
	  
	  log.info("Register - Step 05: Verify success massage displayed-02");
//	  verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
	  
	  log.info("Register - Step 06: Click to Logout Link");
	  homePage = registerPage.clickToLogoutLink();
  }
  @Test
  public void TC_05_Register_with_ConfirmPassword_notMatch_Password() {
	  log.info("Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage(driver);
	  
	  log.info("Register - Step 02: Verify Register is displayed");
	  verifyTrue(registerPage.isRegisterPageDisplayed());
	    
	  log.info("Register - Step 03: Input data to all required fields");
	  registerPage.clickToMaleRadioButton();
	  registerPage.inputToFirstnameTextbox("John");
	  registerPage.inputToLastnameTextbox("Wick");
	  registerPage.inputToEmailTextbox(email);
	  registerPage.inputToPasswordTextbox("123123");
	  registerPage.inputToComfirmPasswordTextbox("123333");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 04: Verify success message displayed-01");
	  verifyFalse(registerPage.isSuccessMessageDisplayed());
	  
	  log.info("Register - Step 05: Verify success massage displayed-02");
//	  verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
	  
	  log.info("Register - Step 06: Click to Logout Link");
	  homePage = registerPage.clickToLogoutLink();
  }
  @Test
  public void TC_06_Register_Valid() {
	  log.info("Register - Step 01: Click to Register link");
	  registerPage = homePage.openRegisterPage(driver);
	  
	  log.info("Register - Step 02: Verify Register is displayed");
	  verifyTrue(registerPage.isRegisterPageDisplayed());
	    
	  log.info("Register - Step 03: Input data to all required fields");
	  registerPage.clickToMaleRadioButton();
	  registerPage.inputToFirstnameTextbox("John");
	  registerPage.inputToLastnameTextbox("Wick");
	  registerPage.inputToEmailTextbox(email);
	  registerPage.inputToPasswordTextbox("123123");
	  registerPage.inputToComfirmPasswordTextbox("123123");
	  registerPage.clickToRegisterButton();
	  
	  log.info("Register - Step 04: Verify success message displayed-01");
	  verifyTrue(registerPage.isSuccessMessageDisplayed());
	  
	  log.info("Register - Step 05: Verify success massage displayed-02");
	  verifyEquals(registerPage.getSuccessMessageText(), "Your registration completed");
	  
	  log.info("Register - Step 06: Click to Logout Link");
	  homePage = registerPage.clickToLogoutLink();
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
