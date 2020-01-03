package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankGuru.pageObjects.BalanceEnquiryPO;
import bankGuru.pageObjects.DeleteAccountPO;
import bankGuru.pageObjects.HomePO;
import bankGuru.pageObjects.LoginPO;
import bankGuru.pageObjects.PageGeneratorManager;
import bankGuru.pageObjects.RegisterPO;
import commons.AbstractTest;


public class Bank_01_Payment_Process extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email, textboxID;
	String password, userID, loginPageurl;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private BalanceEnquiryPO balanceEnquiryPage;
	private DeleteAccountPO deleteAccountPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		email = "automationfc" + randomNumber() + "@gmail.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		
	}
	@Test
	public void Payment_01_RegisterAndLogin() {
		log.info("RegisterandLogin - Step-01: Open url");
		loginPageurl = loginPage.getLoginPageUrl();
		
		log.info("RegisterandLogin - Step-01: Click here link");
		registerPage = loginPage.clickToHereLink();
		
		log.info("RegisterandLogin - Step-03: Input email");
		registerPage.inputEmailIDTextbox(email);
		
		log.info("RegisterandLogin - Step-04: click btn submit");
		registerPage.clickButtonSubmit();
		
		log.info("RegisterandLogin - Step-05: Get userID");
		userID = registerPage.getUserIDValue();
		
		log.info("RegisterandLogin - Step-06: Get password");
		password = registerPage.getPasswordValue();
		
		log.info("RegisterandLogin - Step-07: Open again url");
		loginPage = registerPage.openLoginPage(loginPageurl);
		
		log.info("RegisterandLogin - Step-08: input userID");
		loginPage.inputuserIDtextbox(userID);
		
		log.info("RegisterandLogin - Step-09: input password");
		loginPage.inputpasswordtextbox(password);
		
		log.info("RegisterandLogin - Step-10: click btn:Submit");
		homePage = loginPage.clickToSubmitButton();
		
		log.info("RegisterandLogin - Step-11: verify message display");
		verifyTrue(homePage.isWelcomeMessageDisplay());
	}
	@Test
	public void Payment_02_NewCustomer() {

	}

	@Test
	public void Payment_03_EditCustomer()  {
		
	}
	@Test
	public void Payment_04_NewAccount()  {
		
	}
	@Test
	public void Payment_05_EditAccount()  {
		
	}
	@Test
	public void Payment_06_DepositToAccount()  {
		
	}
	@Test
	public void Payment_07_WithdrawalFromAccount()  {
		
	}
	
	@Test
	public void Payment_08_TranferToOtherAccount()  {
		
	}
	@Test
	public void Payment_09_CheckcurrentAmount()  {
		
	}
	@Test
	public void Payment_10_DeleteAllAccount()  {
		
	}
	
	public void Payment_11_DeleteCustomer()  {
		
	}
	
	public void Payment_12_LogoutToSystem()  {
		
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}



}
