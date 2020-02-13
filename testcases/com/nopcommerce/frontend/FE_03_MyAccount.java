package com.nopcommerce.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import nopCommerce.pageOpjects.FooterMyAccountPO;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.MyAccountPO;
import nopCommerce.pageOpjects.RegisterPO;
import nopCommerce.pageOpjects.nopCommercePageGeneratorManager;

public class FE_03_MyAccount extends AbstractTest{
	WebDriver driver;
	Select select;
	String email,password;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private FooterMyAccountPO myAccountPage;
	
	@Parameters("browser")
	  @BeforeClass
		public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	    log.info("Driver at class test = " + driver.toString());
		
		email = "jond_wick_" + randomNumber() + "@hotmail.com";
		password = "AutomationTesting";
		
		homePage = nopCommercePageGeneratorManager.getHomePage(driver);
		  log.info("Register - Step 01: Click to Register link");
		  registerPage = homePage.openRegisterPage(driver);
		  
		  log.info("Register - Step 02: Verify Register is displayed");
		  verifyTrue(registerPage.isRegisterPageDisplayed());
		    
		  log.info("Register - Step 03: Input data to all required fields");
		  registerPage.clickToGenderRadioButton();
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
			
			log.info("Login");
			loginPage = homePage.openLoginPage();
			verifyTrue(loginPage.isLoginPageDisplayed());
			loginPage.inputToEmailTextbox(email);
			loginPage.inputToPasswordTextbox("123123");
			loginPage.clickToLoginButton();
			verifyTrue(homePage.isLogoutLinkDisplay());
			verifyTrue(homePage.isMyAccountLinkDisplayed());  
			
//			myAccountPage = (FooterMyAccountPO) homePage.openMultiplenNopCommercePage("My account");
			myAccountPage = homePage.openFooterMyAccountPage(driver);
//			verifyTrue(myAccountPage.isDynamicPageTitleDisplay("My account - Customer info"));
  }
	@Test
	public void TC_01_Customer_info() {
//		myAccountPage.clickToGenderRadioButton("Gender:","gender-female");
		
		myAccountPage.inputFieldRequired("FirstName", "Automation");
		myAccountPage.inputFieldRequired("LastName", "FC");
		myAccountPage.inputFieldRequired("Email", "automationfc.vn@gmail.com");
		myAccountPage.inputFieldRequired("Company", "Automation FC");
		myAccountPage.selectDayBirthdayDropDown("DateOfBirthDay", "1");
		myAccountPage.selectMonthBirthdayDropDown("DateOfBirthMonth", "January");
		myAccountPage.selectYearBirthdayDropDown("DateOfBirthYear", "1999");
		
		myAccountPage.clickbtnSaveINFO();
	}
	
	@Test
	public void TC_02_Address() {
		myAccountPage.clickSubPageMyAcc("Addresses");
		verifyTrue(myAccountPage.isDynamicPageTitleDisplay("My account - Addresses"));
		myAccountPage.clickBtnDYNAMIC("button-1 add-address-button");
		verifyTrue(myAccountPage.isDynamicPageTitleDisplay("My account - Add new address"));
		myAccountPage.inputFieldRequired("Address_FirstName", "Automation");
		myAccountPage.inputFieldRequired("Address_LastName", "FC");
		myAccountPage.inputFieldRequired("Address_Email", "automationfc.vn@gmail.com");
		myAccountPage.inputFieldRequired("Address_Company", "Automation FC");
		myAccountPage.selectItemInDropdown("//select[@id='Address_CountryId']", "Viet Nam");
		myAccountPage.inputFieldRequired("Address_City", "Da Nang");
		myAccountPage.inputFieldRequired("Address_Address1", "123/04 Le Lai");
		myAccountPage.inputFieldRequired("Address_Address2", "234/05 Hai Phong");
		myAccountPage.inputFieldRequired("Address_ZipPostalCode", "550000");
		myAccountPage.inputFieldRequired("Address_PhoneNumber", "0123456789");
		myAccountPage.inputFieldRequired("Address_FaxNumber", "0987654321");
		myAccountPage.clickBtnDYNAMIC("button-1 save-address-button");
		verifyTrue(myAccountPage.isNEWADDDisplay());
		verifyTrue(myAccountPage.isEditNEWAddDisplay());
		verifyTrue(myAccountPage.isDeleteNEWAddDisplay());
	
	}
	
	@Test
	public void TC_03_ChangePassWord() {
		myAccountPage.clickSubPageMyAcc("Change password");
		verifyTrue(myAccountPage.isDynamicPageTitleDisplay("My account - Change password"));
		myAccountPage.inputChangePass("OldPassword", "123123");
		myAccountPage.inputChangePass("NewPassword", "111111");
		myAccountPage.inputChangePass("ConfirmNewPassword", "111111");
		myAccountPage.clickBtnDYNAMIC("button-1 change-password-button");
//		myAccountPage.acceptAlert();
		verifyTrue(myAccountPage.isMessageChangePass());
		
	}
	@Test
	public void TC_04_MyProduct_review() {
		homePage = myAccountPage.openhomePage();
		homePage.clickProduct("Apple MacBook Pro 13-inch");
		verifyTrue(homePage.isDynamicProductNameDisplay("Apple MacBook Pro 13-inch"));
		homePage.clickAddYourReview();
//		verifyTrue(homePage.isDynamicPageTitleDisplay("Product reviews for"));
		homePage.inputToDynamicTextbox("AddProductReview_Title", "okila");
		homePage.inputTextArea("AddProductReview_ReviewText", "okila");
		homePage.clickToDynamicCheckBox("addproductrating_4");
		homePage.clickDynamicBtnSUBMIT("add-review");
		verifyTrue(homePage.isResultReviewProduct("Product review is successfully added."));
		myAccountPage = homePage.openFooterMyAccountPage(driver);
		myAccountPage.clickSubPageMyAcc("My product reviews");
		verifyTrue(myAccountPage.isDynamicPageTitleDisplay("My account - My product reviews"));
		verifyTrue(myAccountPage.isbodyReviewMyacc());
	}
	@AfterClass
	  public void afterClass() {
		 driver.quit();
	  }
}
