package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.RegisterPageUI;

public class RegisterPO extends AbstractPageObject {
	WebDriver driver;
	PageGeneratorManager pageGenerate;

	public RegisterPO(WebDriver driverLocal) {
//		G�?i đến constructor của class cha
		super(driverLocal);
		driver = driverLocal;
		pageGenerate = new PageGeneratorManager();
	}


	public void clickToMaleRadioButton() {
//		wait
		waitToElementVisible(RegisterPageUI.GENDER_MALE_RADIO);
//		click
		ClickToElement(RegisterPageUI.GENDER_MALE_RADIO);
			
	}

	public void inputToFirstnameTextbox(String firstNameValue) {
		waitToElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
		
	}

	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
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
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getTextElement(RegisterPageUI.REGISTER_SUCCESS_TEXT);
	}
	public HomePO clickToLogoutLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		ClickToElement(RegisterPageUI.LOGOUT_LINK);		
		return PageGeneratorManager.getHomePage(driver);

	}


	public boolean isRegisterPageDisplayed() {
		waitToElementVisible(RegisterPageUI.REGISTER_FORM);
		return isElementDisplayed(RegisterPageUI.REGISTER_FORM);
	}


	


	
}
 