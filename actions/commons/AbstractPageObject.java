package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankGuru.pageObjects.BankGuruPageGeneratorManager;
import bankGuru.pageObjects.LogOutPO;
import bankGuru.pageUIs.AbstractPageBankGuruUI;
import nopCommerce.pageOpjects.FooterMyAccountPO;
import nopCommerce.pageOpjects.HeaderMyAccountPO;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.nopCommercePageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;
import nopCommerce.pageOpjects.SearchPO;
import nopCommerce.pageOpjects.Shipping_ReturnPO;
import nopCommerce.pageOpjects.SitemapPO;
import nopCommerce.pageUIs.AbstractPageNopcommerceUI;

public class AbstractPageObject {
	By by;
	Select select;
	Actions action;
	WebElement element;
	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriver driver;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExecutor;

	public AbstractPageObject(WebDriver driverLocal) {
		driver = driverLocal;
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, longTimeout);
		action = new Actions(driver);

	}

	public void openUrl(String urlValue) {
		driver.get(urlValue);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void refreshToPage() {
		driver.navigate().refresh();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

//	Ch
	public void waitAlertPrecence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		waitAlertPrecence();
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		waitAlertPrecence();
		driver.switchTo().alert().dismiss();
	}

	public void sendkeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();

	}

// Web Browser:  Open page / getUrl / getTitle/ Window/ Alert.
//	Web Element: Click/ sendkey/ submit/ select/ getText/ getAttribuilt
	public void ClickToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		waitToElementVisible(locator);

		element.click();
	}

//// 1 tham số
//	public void ClickToElement(String locator, String value) {
//		locator = String.format(locator, value);
//		element = DriverGlobal.findElement(By.xpath(locator));
//		element.click();
//	}
////	2 tham số
//	public void ClickToElement(String locator, String firstvalue, String secondValue) {
//		locator = String.format(locator, firstvalue, secondValue);
//		element = DriverGlobal.findElement(By.xpath(locator));
//		element.click();
//	}
////	3 tham số
//	public void ClickToElement(String locator, String firstvalue, String secondValue, String thirdValue) {
//		locator = String.format(locator, firstvalue, secondValue,thirdValue);
//		element = DriverGlobal.findElement(By.xpath(locator));
//		element.click();
//	}
//	n tham số
	public void clickToElement(String locator, String... values) {
//		System.out.println();
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		waitToElementVisible(locator);
		element.click();
//		System.out.println("Locator after = " + locator);
	}

	public String castRestParamter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void sendkeyToElement(String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void sendkeyToElement(String locator, String valueToSendkey, String... values) {
		locator = castRestParamter(locator, values);
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(valueToSendkey);
	}

	public void selectItemInDropdown(String locator, String valueItem) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public void selectItemInDropdown(String locator, String valueItem, String... values) {
		locator = castRestParamter(locator, values);
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(valueItem);
//		driver.switchTo().frame(element);
	}

	public String getValueItemInDropdown(String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(String parentLocator, String allItemsLocator, String expectedItem) throws InterruptedException {
//		  Click vào dropdown để hiển thị các item
		element = driver.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].click();", element);

		sleepInSecond(1);
//		 Chờ các item cần hiển thị đc load thành công 
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));

//		  Define ra 1 list để store lại all items đc load ra
		elements = driver.findElements(By.xpath(allItemsLocator));

//		  Dùng vòng lặp duyệt qua từng item để loc ra được item mình cần:
//		  For-Each
		for (WebElement item : elements) {
			System.out.println(item.getText());
			if (item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(2);

				break;

			}
		}
	}

	public void sleepInSecond(long numberInSecond) {
		try {
			Thread.sleep(numberInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAttributeValue(String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckBox(String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected() == false) {
			element.click();
		}
	}

	public void UnCheckToCheckBox(String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected() == true) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator) {
		overideGlobalTimeout(shortTimeout);
		try {
		element = driver.findElement(By.xpath(locator));
		overideGlobalTimeout(longTimeout);
		return element.isDisplayed();
		} catch (NoSuchElementException e) {
			overideGlobalTimeout(longTimeout);
			return false;
		}
	}
	
	public void overideGlobalTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayed(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		overideGlobalTimeout(shortTimeout);
		try {
			element = driver.findElement(By.xpath(locator));
			overideGlobalTimeout(longTimeout);
			return element.isDisplayed();	
		}
			catch (Exception e){
			overideGlobalTimeout(longTimeout);
			return false;
		}
		
	}

	public boolean isElementSelected(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isElementEnabled(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowByID(String parent) {
//		  Get ra tất cả các ID
		Set<String> allWindows = driver.getWindowHandles();

//		  Dùng vòng lặp để duyệt qua các ID đã Get
		for (String runWindows : allWindows) {
//			  Nếu như ID nào mà khác vs parent ID thì switch qua
			if (!runWindows.equals(parent)) {
				driver.switchTo().window(runWindows);
//				  Sau khi Switch thành công thì break khỏi vòng lặp for
				break;
			}
		}
	}

	public void switchToWindowByTitle(String title) {
//		  Get ra tất cả các ID
		Set<String> allWindows = driver.getWindowHandles();
//		  Dùng vòng lặp để duyệt qua các ID đã Get
		for (String runWindows : allWindows) {
//			  Cho switch vao cac ID truoc
			driver.switchTo().window(runWindows);

//			  Get ra title cuả Page đó xem nó bằng cái gì
			String currentWin = driver.getTitle();
//			  Nếu như title bằng vs title mình mong muốn thì thoát khỏi vòng lặp
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
//		  Get ra tất cả các ID
		Set<String> allWindows = driver.getWindowHandles();

//		  Dùng vòng lặp để duyệt qua các ID đã Get
		for (String runWindows : allWindows) {
//			  Nếu cửa sổ nào mà khác với parent ID
			if (!runWindows.equals(parentWindow)) {
//				  Switch vào cửa sổ đó
				driver.switchTo().window(runWindows);
//				  Dùng hàm close để đóng cái cửa sổ đó lại
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);

//		  Để kiểm tra chỉ còn lại duy nhất 1 cửa sổ (parent)
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToFrameOrIframe(String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}

//	  hàm check image upload lên đã thành công chưa
	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		boolean status;
		element = driver.findElement(By.xpath(locator));
		status = (boolean) jsExecutor.executeScript("return arguments[0].complete && type of arguments[0],naturalWidth != \"undefined\"&& arguments[0].naturalWidth >0", element);
		if (status) {
			return true;
		} else {
			return false;
		}

	}

//	public void waitToElementVisible(String locator) {
//		by = By.xpath(locator);
//		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}
	public boolean waitToElementVisible(String locator) {
		overideGlobalTimeout(shortTimeout);
		try {
		element = driver.findElement(By.xpath(locator));
		overideGlobalTimeout(longTimeout);
		return element.isDisplayed();
		} catch (NoSuchElementException e) {
			overideGlobalTimeout(longTimeout);
			return false;
		}
	}

	public void waitToElementVisible(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	public void waitToElementPresence(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitToElementInvisible(String locator) {
		by = By.xpath(locator);
		overideGlobalTimeout(shortTimeout);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
		overideGlobalTimeout(longTimeout);
	}

	public void waitToElementClickable(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void removeElementAttribute(String locator, String attributeToRemove) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeToRemove + "');",element);
	}
	
	public void removeElementAttribute(String locator, String attributeToRemove, String... values) {
		locator = castRestParamter(locator, values);

		element = driver.findElement(By.xpath(locator));
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeToRemove + "');",element);
	}
	
//	28 ham de open 28 page
	public HeaderMyAccountPO openHeaderMyAccountPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.HEADER_MY_ACCOUNT_LINK);
		ClickToElement(AbstractPageNopcommerceUI.HEADER_MY_ACCOUNT_LINK);
		return nopCommercePageGeneratorManager.getHeaderMyAccountPO(DriverGlobal);
	}

	public HomePO openHomePage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.HEADER_MY_ACCOUNT_LINK);
		ClickToElement(AbstractPageNopcommerceUI.HEADER_MY_ACCOUNT_LINK);
		return nopCommercePageGeneratorManager.getHomePage(DriverGlobal);
	}

	public SearchPO opensearchPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.FOOTER_SEARCH_LINK);
		ClickToElement(AbstractPageNopcommerceUI.FOOTER_SEARCH_LINK);
		return nopCommercePageGeneratorManager.getSearchPage(DriverGlobal);
	}

	public FooterMyAccountPO openFooterMyAccountPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.FOOTER_MY_ACCOUNT_LINK);
		ClickToElement(AbstractPageNopcommerceUI.FOOTER_MY_ACCOUNT_LINK);
		return nopCommercePageGeneratorManager.getFooterMyAccountPage(DriverGlobal);
	}

	public Shipping_ReturnPO openShipping_ReturnPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.FOOTER_SHIPPING_AND_RETURN_LINK);
		ClickToElement(AbstractPageNopcommerceUI.FOOTER_SHIPPING_AND_RETURN_LINK);

		return nopCommercePageGeneratorManager.getShipping_ReturnPage(DriverGlobal);
	}

	public SitemapPO openSiteMapPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.FOOTER_SITEMAP_LINK);
		ClickToElement(AbstractPageNopcommerceUI.FOOTER_SITEMAP_LINK);
		return nopCommercePageGeneratorManager.getSitemapPage(DriverGlobal);
	}

	public RegisterPO openRegisterPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.HEADER_REGISTER_LINK);
		ClickToElement(AbstractPageNopcommerceUI.HEADER_REGISTER_LINK);
		return nopCommercePageGeneratorManager.getRegisterPage(DriverGlobal);
	}

	public LoginPO openLoginPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageNopcommerceUI.HEADER_LOGIN_LINK);
		ClickToElement(AbstractPageNopcommerceUI.HEADER_LOGIN_LINK);
		return nopCommercePageGeneratorManager.getLoginPage(DriverGlobal);
	}

// 1 ham de mo 28 page(n - page) - nopcommerce
	public AbstractPageObject openMultiplenNopCommercePage(String pageName) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		switch (pageName) {
		case "My account":
			return nopCommercePageGeneratorManager.getFooterMyAccountPage(driver);

		case "Sitemap":
			return nopCommercePageGeneratorManager.getSitemapPage(driver);

		case "Search":
			return nopCommercePageGeneratorManager.getSearchPage(driver);

		case "Shipping & returns":
			return nopCommercePageGeneratorManager.getShipping_ReturnPage(driver);

		default:
			return nopCommercePageGeneratorManager.getHomePage(driver);
		}
	}
	
	

//		Ko cần return vì(quá nhiều page)
	public AbstractPageObject openMultiplePages(String pageName) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_FOOTER_LINK, pageName);
		switch (pageName) {
		case "My account":
			return nopCommercePageGeneratorManager.getFooterMyAccountPage(driver);
		case "Search":
			return nopCommercePageGeneratorManager.getSearchPage(driver);
		
		default:
			return nopCommercePageGeneratorManager.getHomePage(driver);
		}
	}
//	Dynamic Element Component (NopCommerce)
	public boolean isDynamicPageTitleDisplay(String text) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_PAGE_TITLE, text);
		return isElementDisplayed(AbstractPageNopcommerceUI.DYNAMIC_PAGE_TITLE, text);
	}
	
	public void inputToDynamicTextbox(String textboxID, String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_TEXTBOX, textboxID);
		sendkeyToElement(AbstractPageNopcommerceUI.DYNAMIC_TEXTBOX, value,textboxID);
	}
	
	public void inputToDynamicTextArea(String textboxID, String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_TEXTAREA, textboxID);
		sendkeyToElement(AbstractPageNopcommerceUI.DYNAMIC_TEXTAREA, value,textboxID);
	}
	
	public void inputTextArea(String textboxID, String value) {
		waitToElementVisible(AbstractPageNopcommerceUI.TEXTAREA, textboxID);
		sendkeyToElement(AbstractPageNopcommerceUI.TEXTAREA, value, textboxID);
	}
	
	public void clickToDynamicButton(String buttonValue) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_BUTTON,buttonValue);
	}
	
	public void clickDynamicBtnSUBMIT(String valueText) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_Btn_SUBMIT, valueText);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_Btn_SUBMIT, valueText);
	}
	
	public void clickToDynamicCheckBox(String checkboxID) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_CHECKBOX, checkboxID);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_CHECKBOX, checkboxID);
	}
	
	public void clickToDynamicRadioButton(String radioButtonID) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
	}
	
	public void clickProduct(String valueText) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_Product_TITLE, valueText);
		clickToElement(AbstractPageNopcommerceUI.DYNAMIC_Product_TITLE, valueText);
	}
	
	public boolean isDynamicProductNameDisplay(String textName) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_Product_NAME, textName);
		return isElementDisplayed(AbstractPageNopcommerceUI.DYNAMIC_Product_NAME, textName);
	}
	
	public void clickAddYourReview() {
		waitToElementVisible("//a[contains(text(),'Add your review')]");
		ClickToElement("//a[contains(text(),'Add your review')]");
	}
	
	public boolean isResultReviewProduct(String valueText) {
		waitToElementVisible(AbstractPageNopcommerceUI.ADDREVIEWSUCCESS, valueText);
		return isElementDisplayed(AbstractPageNopcommerceUI.ADDREVIEWSUCCESS, valueText);
	}
//	public void selectToDynamicDropdown(String dropdownName, String itemValue) throws InterruptedException {
//		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_DROPDOWN_LIST, dropdownName);
//		selectItemInDropdown(AbstractPageNopcommerceUI.DYNAMIC_DROPDOWN_LIST,itemValue,dropdownName);
//	}
	
	
	
	
	
	public String getDynamicRequiredFieldErrorMessage(String fieldID ) {
		waitToElementVisible(AbstractPageNopcommerceUI.DYNAMIC_REQUIRED_FIELDS_ERROR_MSG, fieldID);
		return getTextElement(AbstractPageNopcommerceUI.DYNAMIC_REQUIRED_FIELDS_ERROR_MSG, fieldID);
	}
	
//	Dynamic element component (BankGuru)
//	bankguru
	public AbstractPageObject openMultipleBankGuruPage(String pageName) {
		waitToElementVisible(AbstractPageBankGuruUI.DYNAMIC_LINK, pageName);
		clickToElement(AbstractPageBankGuruUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "New Customer":
			return BankGuruPageGeneratorManager.getNewCustomerPage(driver);
		case "Edit Customer":
			return BankGuruPageGeneratorManager.getEditCustomerPage(driver);
		case "Delete Customer":
			return BankGuruPageGeneratorManager.getDeleteCustomerPage(driver);
		case "New Account":
			return BankGuruPageGeneratorManager.getNewAccountPage(driver);
		case "Edit Account":
			return BankGuruPageGeneratorManager.getEditAccountPage(driver);
		case "Delete Account":
			return BankGuruPageGeneratorManager.getDeleteAccountPage(driver);
		case "Deposit":
			return BankGuruPageGeneratorManager.getDepositPage(driver);
		case "Withdrawal":
			return BankGuruPageGeneratorManager.getWithdrawalPage(driver);
		case "Balance Enquiry":
			return BankGuruPageGeneratorManager.getBalanceEnquiryPage(driver);
		case "Customised Statement":
			return BankGuruPageGeneratorManager.getCustomisedStatementPage(driver);
		case "Fund Transfer":
			return BankGuruPageGeneratorManager.getFundTransferPage(driver);
		case "Change Password":
			return BankGuruPageGeneratorManager.getChangePasswordPage(driver);
		case "Log out":
			return BankGuruPageGeneratorManager.getLogOutPage(driver);
		default:
			return BankGuruPageGeneratorManager.getHomePage(driver);
		}
	}
	
	public boolean isDynamicHeaderOrMessageDisplay(String hearrtOrMessage) {
		waitToElementVisible(AbstractPageBankGuruUI.DYNAMIC_HEADER_MESSAGE_DISPLAYED, hearrtOrMessage);
		return isElementDisplayed(AbstractPageBankGuruUI.DYNAMIC_HEADER_MESSAGE_DISPLAYED, hearrtOrMessage);
	}
	
	public void inputToDynamicTextareaOrTextbox(String nameID, String value) {
		waitToElementVisible(AbstractPageBankGuruUI.DYNAMIC_TEXTBOX_TEXTARER, nameID);
		if(nameID.contains("dob")) {
			removeElementAttribute(AbstractPageBankGuruUI.DYNAMIC_TEXTBOX_TEXTARER, "type", nameID);
		}
		sendkeyToElement(AbstractPageBankGuruUI.DYNAMIC_TEXTBOX_TEXTARER, value, nameID);
	}
	
	public void clickToDynamicSubmitBtn(String buttonValue) {
		waitToElementVisible(AbstractPageBankGuruUI.DYNAMIC_SUBMIT_BUTTON, buttonValue);
		clickToElement(AbstractPageBankGuruUI.DYNAMIC_SUBMIT_BUTTON, buttonValue);
	}
	
	public String getToDynamicTextTable(String rowname) {
		waitToElementVisible(AbstractPageBankGuruUI.DYNAMIC_TEXT_TABLE, rowname);
		return getTextElement(AbstractPageBankGuruUI.DYNAMIC_TEXT_TABLE, rowname);
	}
	
	public void selectDynamicDropdown(String nameID, String value) {
		waitToElementVisible(AbstractPageBankGuruUI.DYNAMIC_DROPDOWN, nameID);
		selectItemInDropdown(AbstractPageBankGuruUI.DYNAMIC_DROPDOWN, value, nameID);
		
	}
	
//  Ham check Sort Ascending
  public boolean isDataSortedAscending(String locator) {
//	  Khai bao 1 array List
	  ArrayList<String>arrayList = new ArrayList<>();
	  
//	  Tim  tat ca cac element matching vs DK (Name, Price,..)
	  List<WebElement>elementList = driver.findElements(By.xpath(locator));
	  
	  for(WebElement element:elementList) {
		  arrayList.add(element.getText());
	  }
	  System.out.println("----Data on UI---");
	  for(String name:arrayList) {
		  System.out.println(name);
	  }
//	  Copy qua 1 array list moi de SORT trong code
	  ArrayList<String>sortedList=new ArrayList<>();
	  for(String child:arrayList) {
		  sortedList.add(child);
	  }
//	  Thuc hien SORT ASC
	  Collections.sort(arrayList);
	  System.out.println("---Data da SORT ASC trong code:---");
	  for(String name:arrayList) {
		  System.out.println(name);
	  }
//	  Verify 2 array bang nhau - neu data SORT on UI khong chinh xac thi result -> False
	  return sortedList.equals(arrayList);
  }

  //Ham check Sort Descending
public boolean isDataSortDescending(String locator) {
//	  Khai báo 1 array List
	  ArrayList<String>arrayList=new ArrayList<>();
	  
//	  Tim tat ca element matching vs DK (Name/Price....)
	  List<WebElement>elementList=driver.findElements(By.xpath(locator));
	  
//	  Lay text cua tung element add vao Array
	  for(WebElement element:elementList) {
		  arrayList.add(element.getText());
	  }
	  
	  System.out.println("----Data on UI----");
	  for(String name:arrayList) {
		  System.out.println(name);
	  }
//	  Copy qua 1 array list moi de SORT trong code
	  ArrayList<String>sortedList=new ArrayList<>();
	  for (String child:arrayList) {
		  sortedList.add(child);
	  }
//	  Thuc hien SORT ASC
	  Collections.sort(arrayList);
	  System.out.println("---Data da SORT ASC trong code:---");
	  for(String name:arrayList) {
		  System.out.println(name);
	  }
//	  Reverse data de SORT DESC(dung 1 trong 2 cach)
	  Collections.reverse(arrayList);
//	  Collections.sort(arrayList, Collections.reverseOrder());
	  System.out.println("---Data da SORT DESC trong code:---");
	  for(String name:arrayList) {
		  System.out.println(name);
	  }
	return sortedList.equals(arrayList);
}
//SORT (float)
public boolean isPriceSortedAscending(String locator) {
  ArrayList<Float>arrayList = new ArrayList<Float>();
  List<WebElement>elementList=driver.findElements(By.xpath(locator));
  for(WebElement element:elementList) {
	  arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
  }
  
  System.out.println("--Data on UI---");
  for(Float name:arrayList) {
	  System.out.println(name);
  }
  
  ArrayList<Float>sortedList=new ArrayList<Float>();
  for(Float child:arrayList) {
	  sortedList.add(child);
  }
  
  Collections.sort(arrayList);
  System.out.println("---Data da SORT ASC trong code---");
  for(Float name:arrayList) {
	  System.out.println(name);
  }
  return sortedList.equals(arrayList);
  
}
	
}

