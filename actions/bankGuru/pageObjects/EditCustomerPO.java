package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.AbstractPageBankGuruUI;
import commons.AbstractPageObject;

public class EditCustomerPO extends AbstractPageObject {
	WebDriver driver;
	public EditCustomerPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}
	
	public boolean isWarningEnterCustomerID(String warnEnterCustomer) {
		waitToElementVisible(AbstractPageBankGuruUI.CUSTOMERID_WARNDISPLAY, warnEnterCustomer);
		return isElementDisplayed(AbstractPageBankGuruUI.CUSTOMERID_WARNDISPLAY, warnEnterCustomer);
	}
	
	public boolean isWarningMessageAddressDisplay(String warningAdd) {
		waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_ADD, warningAdd);
		return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_ADD, warningAdd);
	}
	
	public boolean isWarningMessageCityDisplay(String warningCity) {
		waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_CITY, warningCity);
		return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_CITY, warningCity);
	}
	
	public boolean isWarningMessageStateDisplay(String warningState) {
		waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_CITY, warningState);
		return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_CITY, warningState);
	}
	 public boolean isWarningMessagePinDisplay(String warningPin) {
		 waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_PIN, warningPin);
		 return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_PIN, warningPin);
	 }
	 
	 public boolean isWarningMessagePhoneDisplay(String warningPhone) {
		 waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_PHONE, warningPhone);
		 return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_PHONE, warningPhone);
	 }
	 
	 public boolean isWarningMessageEmailDisplay(String warningEmail) {
		 waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_EMAIL, warningEmail);
		 return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_EMAIL, warningEmail);
	 }

}