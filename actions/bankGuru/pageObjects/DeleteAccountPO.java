package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.AbstractPageBankGuruUI;
import commons.AbstractPageObject;

public class DeleteAccountPO extends AbstractPageObject {
	WebDriver driver;
	public DeleteAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}
	public boolean isWarningAccountIDDisplay(String warningAccID) {
		waitToElementVisible(AbstractPageBankGuruUI.ACCOUNT_ID_WARNDISPLAY, warningAccID);
		return isElementDisplayed(AbstractPageBankGuruUI.ACCOUNT_ID_WARNDISPLAY, warningAccID);
	}
}
