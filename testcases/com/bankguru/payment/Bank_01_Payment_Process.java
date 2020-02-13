package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankGuru.pageObjects.BalanceEnquiryPO;
import bankGuru.pageObjects.BankGuruPageGeneratorManager;
import bankGuru.pageObjects.DeleteAccountPO;
import bankGuru.pageObjects.DepositPO;
import bankGuru.pageObjects.EditAccountPO;
import bankGuru.pageObjects.EditCustomerPO;
import bankGuru.pageObjects.FundTransferPO;
import bankGuru.pageObjects.HomePO;
import bankGuru.pageObjects.LoginPO;
import bankGuru.pageObjects.NewAccountPO;
import bankGuru.pageObjects.NewCustomerPO;
import bankGuru.pageObjects.RegisterPO;
import bankGuru.pageObjects.WithdrawalPO;
import commons.AbstractTest;

public class Bank_01_Payment_Process extends AbstractTest {
	private WebDriver driver;
	Select select;
	String email, textboxID;
	private String accountTypeSaving, accountTypeCurrent;
	private String customerID,transactionID, firstAccountID,secondAccountID, password, userID, loginPageurl, name, gender, dateOfBirth, address, city, state, pin, phone;
	private String editname, editaddress, editcity, editstate, editphone, editpin, editemail;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private BalanceEnquiryPO balanceEnquiryPage;
	private DeleteAccountPO deleteAccountPage;
	private NewCustomerPO newCustomerPage;
	private EditCustomerPO editCustomerPage;
	private NewAccountPO newAccountPage;
	private EditAccountPO editaccountPage;
	private DepositPO depositPage;
	private WithdrawalPO withdrawalPage;
	private FundTransferPO fundtransferPage;
//	private CheckcurrentAmountPO checkcurrentAmountPage;

	@Parameters({ "browser", "urL" })
	@BeforeClass
 	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		email = "Automationfc" + randomNumber() + "@gmail.com";

//		New Customer
		name = "Automation";
		gender = "male";
		dateOfBirth = "2019-12-25";
		address = "259 PO Box";
		city = "Ha Noi";
		state = "Cau Giay";
		pin = "365265";
		phone = "0918913123";
		
		accountTypeSaving = "Savings";
		accountTypeCurrent = "Current";

		editaddress = "456 HuHu";
		editcity = "Ho Chi Minh";
		editstate = "Quan 1";
		editpin = "666666";
		editphone = "0923123123";
		editemail = "auto" + randomNumber() + "@hotmail.com";
		loginPage = BankGuruPageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void Payment_01_RegisterAndLogin() {
		log.info("RegisterandLogin - Step-01: Open url");
		loginPageurl = loginPage.getLoginPageUrl();

		log.info("RegisterandLogin - Step-02: Click here link");
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
		
		newCustomerPage = (NewCustomerPO) homePage.openMultipleBankGuruPage("New Customer");
		System.out.println(newCustomerPage instanceof NewCustomerPO);

		verifyTrue(newCustomerPage.isDynamicHeaderOrMessageDisplay("Add New Customer"));

		newCustomerPage.inputToDynamicTextareaOrTextbox("name", name);
		newCustomerPage.inputToDynamicTextareaOrTextbox("dob", dateOfBirth);
		newCustomerPage.inputToDynamicTextareaOrTextbox("addr", address);
		newCustomerPage.inputToDynamicTextareaOrTextbox("city", city);
		newCustomerPage.inputToDynamicTextareaOrTextbox("state", state);
		newCustomerPage.inputToDynamicTextareaOrTextbox("pinno", pin);
		newCustomerPage.inputToDynamicTextareaOrTextbox("telephoneno", phone);
		newCustomerPage.inputToDynamicTextareaOrTextbox("emailid", email);
		newCustomerPage.inputToDynamicTextareaOrTextbox("password", password);

		newCustomerPage.clickToDynamicSubmitBtn("Submit");
		verifyTrue(newCustomerPage.isDynamicHeaderOrMessageDisplay("Customer Registered Successfully!!!"));

		verifyEquals(newCustomerPage.getToDynamicTextTable("Customer Name"), name);
		verifyEquals(newCustomerPage.getToDynamicTextTable("Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getToDynamicTextTable("Address"), address);
		verifyEquals(newCustomerPage.getToDynamicTextTable("City"), city);
		verifyEquals(newCustomerPage.getToDynamicTextTable("State"), state);
		verifyEquals(newCustomerPage.getToDynamicTextTable("Pin"), pin);
		verifyEquals(newCustomerPage.getToDynamicTextTable("Mobile No."), phone);
		verifyEquals(newCustomerPage.getToDynamicTextTable("Email"), email);

		customerID = newCustomerPage.getToDynamicTextTable("Customer ID");
	}

	@Test
	public void Payment_03_EditCustomer() {
		editCustomerPage = (EditCustomerPO) newCustomerPage.openMultipleBankGuruPage("Edit Customer");
		System.out.println(editCustomerPage instanceof EditCustomerPO);
		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplay("Edit Customer Form"));
		
		editCustomerPage.inputToDynamicTextareaOrTextbox("cusid", customerID);
		editCustomerPage.clickToDynamicSubmitBtn("Submit");
		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplay("Edit Customer"));
		
		editCustomerPage.inputToDynamicTextareaOrTextbox("addr", editaddress);
		editCustomerPage.inputToDynamicTextareaOrTextbox("city", editcity);
		editCustomerPage.inputToDynamicTextareaOrTextbox("state", editstate);
		editCustomerPage.inputToDynamicTextareaOrTextbox("pinno", editpin);
		editCustomerPage.inputToDynamicTextareaOrTextbox("telephoneno", editphone);
		editCustomerPage.inputToDynamicTextareaOrTextbox("emailid", editemail);
		editCustomerPage.clickToDynamicSubmitBtn("Submit");
		
		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplay("Customer details updated Successfully!!!"));
		verifyEquals(editCustomerPage.getToDynamicTextTable("Customer Name"), name);
		verifyEquals(editCustomerPage.getToDynamicTextTable("Birthdate"), dateOfBirth);
		verifyEquals(editCustomerPage.getToDynamicTextTable("Address"), editaddress);
		verifyEquals(editCustomerPage.getToDynamicTextTable("City"), editcity);
		verifyEquals(editCustomerPage.getToDynamicTextTable("State"), editstate);
		verifyEquals(editCustomerPage.getToDynamicTextTable("Pin"), editpin);
		verifyEquals(editCustomerPage.getToDynamicTextTable("Mobile No."), editphone);
		verifyEquals(editCustomerPage.getToDynamicTextTable("Email"), editemail);

	}

	@Test
	public void Payment_04_NewAccount() {
//		Create fisrt new account - PAYERS
		newAccountPage = (NewAccountPO) editCustomerPage.openMultipleBankGuruPage("New Account");
		System.out.println(newAccountPage instanceof NewAccountPO);
		
		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplay("Add new account form"));
		newAccountPage.inputToDynamicTextareaOrTextbox("cusid", customerID);
		newAccountPage.selectDynamicDropdown("selaccount", accountTypeSaving);
		newAccountPage.inputToDynamicTextareaOrTextbox("inideposit", "5000");
		newAccountPage.clickToDynamicSubmitBtn("submit");
		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplay("Account Generated Successfully!!!"));
		verifyEquals(newAccountPage.getToDynamicTextTable("Customer ID"), customerID);
		verifyEquals(newAccountPage.getToDynamicTextTable("Customer Name"), name);
		verifyEquals(newAccountPage.getToDynamicTextTable("Email"), editemail);
		verifyEquals(newAccountPage.getToDynamicTextTable("Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getToDynamicTextTable("Date of Opening"), getToday());
		verifyEquals(newAccountPage.getToDynamicTextTable("Current Amount"), "5000");
		
		firstAccountID = newAccountPage.getToDynamicTextTable("Account ID");
		
//		Create second new account - Payees
		newAccountPage = (NewAccountPO) newAccountPage.openMultipleBankGuruPage("New Account");
		System.out.println(newAccountPage instanceof NewAccountPO);
		
		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplay("Add new account form"));
		newAccountPage.inputToDynamicTextareaOrTextbox("cusid", customerID);
		newAccountPage.selectDynamicDropdown("selaccount", accountTypeSaving);
		newAccountPage.inputToDynamicTextareaOrTextbox("inideposit", "1000");
		newAccountPage.clickToDynamicSubmitBtn("submit");
		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplay("Account Generated Successfully!!!"));
		verifyEquals(newAccountPage.getToDynamicTextTable("Customer ID"), customerID);
		verifyEquals(newAccountPage.getToDynamicTextTable("Customer Name"), name);
		verifyEquals(newAccountPage.getToDynamicTextTable("Email"), editemail);
		verifyEquals(newAccountPage.getToDynamicTextTable("Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getToDynamicTextTable("Date of Opening"), getToday());
		verifyEquals(newAccountPage.getToDynamicTextTable("Current Amount"), "1000");
		
		secondAccountID = newAccountPage.getToDynamicTextTable("Account ID");
	}

//	@Test
	public void Payment_05_EditAccount() {
		editaccountPage = (EditAccountPO) newAccountPage.openMultipleBankGuruPage("Edit Account");
		System.out.println(editaccountPage instanceof EditAccountPO);
		verifyTrue(editaccountPage.isDynamicHeaderOrMessageDisplay("Edit Account Form"));
		editaccountPage.inputToDynamicTextareaOrTextbox("accountno", firstAccountID);
		editaccountPage.clickToDynamicSubmitBtn("Submit");
		
		verifyTrue(editaccountPage.isDynamicHeaderOrMessageDisplay("Edit Account Entry Form"));
		editaccountPage.selectDynamicDropdown("a_type", accountTypeCurrent);
		editaccountPage.clickToDynamicSubmitBtn("Submit");
		verifyTrue(editaccountPage.isDynamicHeaderOrMessageDisplay("Account details updated Successfully!!!"));
		
		verifyEquals(editaccountPage.getToDynamicTextTable("Account ID"), firstAccountID);
		verifyEquals(editaccountPage.getToDynamicTextTable("Customer ID"), customerID);
		verifyEquals(editaccountPage.getToDynamicTextTable("Customer Name"), name);
		verifyEquals(editaccountPage.getToDynamicTextTable("Email"), editemail);
		verifyEquals(editaccountPage.getToDynamicTextTable("Account Type"), accountTypeCurrent);
		verifyEquals(editaccountPage.getToDynamicTextTable("Date of Opening"), getToday());
		verifyEquals(editaccountPage.getToDynamicTextTable("Current Amount"), "5000");
	}

	@Test
	public void Payment_06_DepositToAccount() {
		depositPage = (DepositPO) newAccountPage.openMultipleBankGuruPage("Deposit");
		
		verifyTrue(depositPage.isDynamicHeaderOrMessageDisplay("Amount Deposit Form"));
		depositPage.inputToDynamicTextArea("accountno", firstAccountID);
		depositPage.inputToDynamicTextArea("ammount", "3000");
		depositPage.inputToDynamicTextArea("desc", "nop tien");
		depositPage.clickToDynamicSubmitBtn("Submit");
		verifyTrue(depositPage.isDynamicHeaderOrMessageDisplay("Transaction details of Deposit for Account" + firstAccountID));
		
		transactionID = depositPage.getToDynamicTextTable("Transaction ID");
		verifyEquals(depositPage.getToDynamicTextTable("Transaction ID"), transactionID);
		verifyEquals(depositPage.getToDynamicTextTable("Account No"), firstAccountID);
		verifyEquals(depositPage.getToDynamicTextTable("Amount Credited"), "3000");
		verifyEquals(depositPage.getToDynamicTextTable("Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getToDynamicTextTable("Description"), "nop tien");
		verifyEquals(depositPage.getToDynamicTextTable("Current Balance"), "8000");

	}

	@Test
	public void Payment_07_WithdrawalFromAccount() {
		withdrawalPage = (WithdrawalPO) depositPage.openMultipleBankGuruPage("Withdrawal");
		verifyTrue(withdrawalPage.isDynamicHeaderOrMessageDisplay("Amount Withdrawal Form"));
		withdrawalPage.inputToDynamicTextareaOrTextbox("accountno", firstAccountID);
		withdrawalPage.inputToDynamicTextareaOrTextbox("ammount", "1000");
		withdrawalPage.inputToDynamicTextareaOrTextbox("desc", "tru tien");
		withdrawalPage.clickToDynamicSubmitBtn("Submit");
		verifyTrue(withdrawalPage.isDynamicHeaderOrMessageDisplay("Transaction details of Withdrawal for Account" + firstAccountID));
		verifyEquals(withdrawalPage.getToDynamicTextTable("Account No"), firstAccountID);
		verifyEquals(withdrawalPage.getToDynamicTextTable("Amount Debited"), "1000");
		verifyEquals(withdrawalPage.getToDynamicTextTable("Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getToDynamicTextTable("Description"), "tru tien");
		verifyEquals(withdrawalPage.getToDynamicTextTable("Current Balance"), "7000");

	}

	@Test
	public void Payment_08_TranferToOtherAccount() {
		fundtransferPage = (FundTransferPO) withdrawalPage.openMultipleBankGuruPage("Fund Transfer");
		verifyTrue(fundtransferPage.isDynamicHeaderOrMessageDisplay("Fund Transfer"));
		
		fundtransferPage.inputToDynamicTextareaOrTextbox("payersaccount", firstAccountID);
		fundtransferPage.inputToDynamicTextareaOrTextbox("payeeaccount", secondAccountID);
		fundtransferPage.inputToDynamicTextArea("ammount", "1000");
		fundtransferPage.inputToDynamicTextareaOrTextbox("desc", "transfer");
		fundtransferPage.clickToDynamicSubmitBtn("Submit");
		
		verifyTrue(fundtransferPage.isDynamicHeaderOrMessageDisplay("Fund Transfer Details"));
		verifyEquals(fundtransferPage.isDynamicHeaderOrMessageDisplay("From Account Number"), firstAccountID);
		verifyEquals(fundtransferPage.isDynamicHeaderOrMessageDisplay("To Account Number"), secondAccountID);
		verifyEquals(fundtransferPage.isDynamicHeaderOrMessageDisplay("Amount"), "1000");
		verifyEquals(fundtransferPage.isDynamicHeaderOrMessageDisplay("Description"), "transfer");
		

	}

	@Test
	public void Payment_09_CheckcurrentAmount() {

	}

	@Test
	public void Payment_10_DeleteAllAccount() {

	}


//	@Test
	public void Payment_3_1_DeleteCustomer() {
		deleteAccountPage = (DeleteAccountPO) homePage.openMultipleBankGuruPage("Delete Customer");
		System.out.println(deleteAccountPage instanceof DeleteAccountPO);
		verifyTrue(deleteAccountPage.isDynamicHeaderOrMessageDisplay("Delete Customer Form"));
		
		deleteAccountPage.inputToDynamicTextareaOrTextbox("cusid", customerID);
		deleteAccountPage.clickToDynamicSubmitBtn("");
	}
	
	public void Payment_12_LogoutToSystem() {
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
