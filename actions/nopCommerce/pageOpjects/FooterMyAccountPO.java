package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Food;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.AbstractPageNopcommerceUI;
import nopCommerce.pageUIs.FooterMyAccountPageUI;
import nopCommerce.pageUIs.HomePageUI;
import nopCommerce.pageUIs.RegisterPageUI;

public class FooterMyAccountPO extends AbstractPageObject {
	WebDriver driver;

	public FooterMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

	
	public SearchPO opensearchPage(WebDriver driverLocal) {
		waitToElementVisible(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		ClickToElement(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		return nopCommercePageGeneratorManager.getSearchPage(driverLocal);
	}
	
	public HomePO openhomePage() {
		waitToElementVisible(AbstractPageNopcommerceUI.HEADER_HOME_PAGE_LINK);
		ClickToElement(AbstractPageNopcommerceUI.HEADER_HOME_PAGE_LINK);
		return nopCommercePageGeneratorManager.getHomePage(driver);
	}
	
	public void clickSubPageMyAcc(String valueText) {
		waitToElementVisible(FooterMyAccountPageUI.SubPage_MYACCOUNT);
 		clickToElement(FooterMyAccountPageUI.SubPage_MYACCOUNT, valueText);	
	}
	
	public Shipping_ReturnPO openShipping_ReturnPO(WebDriver driverLocal) {
		waitToElementVisible(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		ClickToElement(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		return nopCommercePageGeneratorManager.getShipping_ReturnPage(driverLocal);
	}

	public void clickToGenderRadioButton(String textGender, String value) {
		waitToElementVisible(RegisterPageUI.GENDER_RADIO, textGender);
		clickToElement(RegisterPageUI.GENDER_RADIO, value,textGender);
	}
	
	public void inputFieldRequired (String textinput, String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_INFO_REQUIRED_CUSTO, textinput);
		sendkeyToElement(AbstractPageNopcommerceUI.DYNAMIC_INFO_REQUIRED_CUSTO, value, textinput);
	}
	
	public void inputChangePass (String textinput, String value) {
		waitToElementVisible(FooterMyAccountPageUI.changePASSWORD, textinput);
		sendkeyToElement(FooterMyAccountPageUI.changePASSWORD, value, textinput);
	}
	
	public void clickbtnSaveINFO() {
		waitToElementVisible(AbstractPageNopcommerceUI.SAVE_INFOCUSTO);
		ClickToElement(AbstractPageNopcommerceUI.SAVE_INFOCUSTO);
	}
//	public void clickbtnSaveADD() {
//		waitToElementVisible("//input[@class='button-1 save-address-button']");
//		ClickToElement("//input[@class='button-1 save-address-button']");
//	}
	public void clickBtnDYNAMIC(String value) {
		waitToElementVisible(FooterMyAccountPageUI.BtnDYNAMIC, value);
		clickToElement(FooterMyAccountPageUI.BtnDYNAMIC, value);
	}
	
	
	public void selectDayBirthdayDropDown(String valueDay, String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.SELECT_DAY_BIRTHDAY,valueDay);
		selectItemInDropdown(AbstractPageNopcommerceUI.SELECT_DAY_BIRTHDAY,value,valueDay);
	}
	
	public void selectMonthBirthdayDropDown( String valueMonth, String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.SELECT_MONTH_BIRTHDAY,valueMonth);
		selectItemInDropdown(AbstractPageNopcommerceUI.SELECT_MONTH_BIRTHDAY,value,valueMonth);
	}
	
	public void selectYearBirthdayDropDown(String valueYear,String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.SELECT_YEAR_BIRTHDAY,valueYear);
		selectItemInDropdown(AbstractPageNopcommerceUI.SELECT_YEAR_BIRTHDAY,value,valueYear);
	}
	
	public void selectCountryDropdown(String value) {
		waitToElementVisible("//select[@id='Address_CountryId']");
		selectItemInDropdown("//select[@id='Address_CountryId']", value);
	}
	public boolean isPageTitlDisplay(String text) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_PAGE_TITLE, text);
		return isElementDisplayed(AbstractPageNopcommerceUI.DYNAMIC_PAGE_TITLE, text);
	}
	
//	public void clickBtnAddNew () {
//		waitToElementVisible(FooterMyAccountPageUI.BtnADDNEW);
//		ClickToElement(FooterMyAccountPageUI.BtnADDNEW);
//	}
	public boolean isNEWADDDisplay	() {
		waitToElementVisible("//ul[@class='info']");
		return isElementDisplayed("//ul[@class='info']");
	}
	
	public boolean isEditNEWAddDisplay() {
		waitToElementVisible("//input[@class='button-2 edit-address-button']");
		return isElementDisplayed("//input[@class='button-2 edit-address-button']");	
	}
	
	public boolean isDeleteNEWAddDisplay() {
		waitToElementVisible("//input[@class='button-2 delete-address-button']");
		return isElementDisplayed("//input[@class='button-2 delete-address-button']");
	}
	
	public boolean isMessageChangePass() {
		waitToElementVisible(FooterMyAccountPageUI.MessageCHANGEPASS);
		return isElementDisplayed(FooterMyAccountPageUI.MessageCHANGEPASS);
	}
	public boolean isbodyReviewMyacc() {
		waitToElementVisible(FooterMyAccountPageUI.BodyREVIEW);
		return isElementDisplayed(FooterMyAccountPageUI.BodyREVIEW);
	}
	}


