package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.AbstractPageBankGuruUI;
import commons.AbstractPageObject;

public class DeleteCustomerPO extends AbstractPageObject {
	WebDriver driver;
	public DeleteCustomerPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}
	public boolean isWarningEnterCustomerID(String warnEnterCustomer) {
		waitToElementVisible(AbstractPageBankGuruUI.CUSTOMERID_WARNDISPLAY, warnEnterCustomer);
		return isElementDisplayed(AbstractPageBankGuruUI.CUSTOMERID_WARNDISPLAY, warnEnterCustomer);
	}

}
