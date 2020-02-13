package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.AbstractPageBankGuruUI;
import bankGuru.pageUIs.NewCustomerPageUI;
import commons.AbstractPageObject;

public class NewAccountPO extends AbstractPageObject {
	WebDriver driver;
	public NewAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}
	public boolean isWarningEnterCustomerID(String warningCustomerID) {
		waitToElementVisible(AbstractPageBankGuruUI.CUSTOMERID_WARNDISPLAY, warningCustomerID);
		return isElementDisplayed(AbstractPageBankGuruUI.CUSTOMERID_WARNDISPLAY, warningCustomerID);
	}
	
	public boolean isWarningEnterInitialDeposit(String warningInitialDeposit) {
		waitToElementVisible(AbstractPageBankGuruUI.INITINAL_DEPOSIT_WARNDISPLAY, warningInitialDeposit);
		return isElementDisplayed(AbstractPageBankGuruUI.INITINAL_DEPOSIT_WARNDISPLAY, warningInitialDeposit);
		
	}
}
