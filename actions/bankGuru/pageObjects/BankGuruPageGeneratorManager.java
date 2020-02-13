package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class BankGuruPageGeneratorManager {
	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static BalanceEnquiryPO getBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPO(driver);
	}
	
	public static DeleteAccountPO getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPO(driver);
	}
	
	public static DeleteCustomerPO getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPO(driver);
	}
	
	public static DepositPO getDepositPage(WebDriver driver) {
		return new DepositPO(driver);
	}
	
	public static EditCustomerPO getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPO(driver);
	}
	
	public static NewAccountPO getNewAccountPage(WebDriver driver) {
		return new NewAccountPO(driver);
	}
	
	public static NewCustomerPO getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPO(driver);
	}
	
	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	
	public static WithdrawalPO getWithdrawalPage(WebDriver driver) {
		return new WithdrawalPO(driver);
	}

	public static EditAccountPO getEditAccountPage(WebDriver driver) {
		return new EditAccountPO(driver);
	}

	public static AbstractPageObject getCustomisedStatementPage(WebDriver driver) {
		return new CustomisedStatementPO(driver);
	}

	public static AbstractPageObject getFundTransferPage(WebDriver driver) {
		return new FundTransferPO(driver);
	}

	public static AbstractPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPO(driver);
	}

	public static AbstractPageObject getLogOutPage(WebDriver driver) {
		return new LogOutPO(driver);
	}

	
	

}
