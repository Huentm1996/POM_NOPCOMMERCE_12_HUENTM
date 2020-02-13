package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.AbstractPageNopcommerceUI;
import nopCommerce.pageUIs.RegisterPageUI;

public class RegisterPO extends AbstractPageObject {
	WebDriver driver;
	nopCommercePageGeneratorManager pageGenerate;

	public RegisterPO(WebDriver driverLocal) {
//		G�?i đến constructor của class cha
		super(driverLocal);
		driver = driverLocal;
		pageGenerate = new nopCommercePageGeneratorManager();
	}


	public void clickToGenderRadioButton() {
//		wait
		waitToElementVisible(RegisterPageUI.GENDER_MELE_RADIO);
//		click
		ClickToElement(RegisterPageUI.GENDER_MELE_RADIO);
			
	}
	
	public void clickToGenderRadioButton(String textGender) {
		waitToElementVisible(RegisterPageUI.GENDER_RADIO, textGender);
		clickToElement(RegisterPageUI.GENDER_RADIO, textGender);
		
		
	}

	public void inputToFirstnameTextbox(String firstNameValue) {
		waitToElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
		sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
		
	}

	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
		sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX, email);
		sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
		sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);				
	}

	public void inputToComfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);					
	}

	public void clickToRegisterButton() {
		waitToElementVisible(RegisterPageUI.REGISTER_BUTTON);
		ClickToElement(RegisterPageUI.REGISTER_BUTTON);			
	}

	public boolean isSuccessMessageDisplayed() {
		waitToElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);	
		return isElementDisplayed(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getSuccessMessageText() {
		waitToElementVisible(RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getTextElement(RegisterPageUI.REGISTER_SUCCESS_TEXT);
	}
	public HomePO clickToLogoutLink() {
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		ClickToElement(RegisterPageUI.LOGOUT_LINK);		
		return nopCommercePageGeneratorManager.getHomePage(driver);

	}


	public boolean isRegisterPageDisplayed() {
		waitToElementVisible(RegisterPageUI.REGISTER_FORM);
		return isElementDisplayed(RegisterPageUI.REGISTER_FORM);
	}
	
	public boolean isWarningREG (String warning) {
		waitToElementVisible(AbstractPageNopcommerceUI.WARNING_REG, warning);
		return isElementDisplayed(AbstractPageNopcommerceUI.WARNING_REG, warning);
	}
	
}
 