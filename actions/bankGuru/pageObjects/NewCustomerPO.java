package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.AbstractPageBankGuruUI;
import bankGuru.pageUIs.NewCustomerPageUI;
import commons.AbstractPageObject;

public class NewCustomerPO extends AbstractPageObject {
	WebDriver driver;
	public NewCustomerPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

		
		public void inputDateofBirthTextbox() {
		// TODO Auto-generated method stub
		
	}
		public boolean isWarningMessageNameDisplay(String warningName) {
			waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_NAME, warningName);
			return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_NAME, warningName);
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
			waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_STATE, warningState);
			return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_STATE, warningState);		
		}
		
		public boolean isWarningMessagePINDisplay(String warningPIN) {
			waitToElementVisible(AbstractPageBankGuruUI.MESSAGE_WARN_PIN, warningPIN);
			return isElementDisplayed(AbstractPageBankGuruUI.MESSAGE_WARN_PIN, warningPIN);
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
