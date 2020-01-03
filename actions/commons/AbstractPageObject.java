package commons;

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

import nopCommerce.pageOpjects.FooterMyAccountPO;
import nopCommerce.pageOpjects.HeaderMyAccountPO;
import nopCommerce.pageOpjects.HomePO;
import nopCommerce.pageOpjects.LoginPO;
import nopCommerce.pageOpjects.PageGeneratorManager;
import nopCommerce.pageOpjects.RegisterPO;
import nopCommerce.pageOpjects.SearchPO;
import nopCommerce.pageOpjects.Shipping_ReturnPO;
import nopCommerce.pageOpjects.SitemapPO;
import nopCommerce.pageUIs.AbstractPageUI;

public class AbstractPageObject {
	By by;
	Select select;
	Actions action;
	WebElement element;
	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriver DriverGlobal, driver;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExecutor;

	public AbstractPageObject(WebDriver driverLocal) {
		DriverGlobal = driverLocal;
		jsExecutor = (JavascriptExecutor) DriverGlobal;
		waitExplicit = new WebDriverWait(DriverGlobal, longTimeout);
		action = new Actions(DriverGlobal);

	}

	public void openUrl(String urlValue) {
		DriverGlobal.get(urlValue);
	}

	public String getPageTitle() {
		return DriverGlobal.getTitle();
	}

	public String getPageCurrentUrl() {
		return DriverGlobal.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return DriverGlobal.getPageSource();
	}

	public void backToPage() {
		DriverGlobal.navigate().back();
	}

	public void refreshToPage() {
		DriverGlobal.navigate().refresh();
	}

	public void forwardToPage() {
		DriverGlobal.navigate().forward();
	}

//	Ch
	public void waitAlertPrecence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		DriverGlobal.switchTo().alert().accept();
	}

	public void cancelAlert() {
		DriverGlobal.switchTo().alert().dismiss();
	}

	public void sendkeyToAlert(String value) {
		DriverGlobal.switchTo().alert().sendKeys(value);
	}

	public String getTextAlert() {
		return DriverGlobal.switchTo().alert().getText();

	}

// Web Browser:  Open page / getUrl / getTitle/ Window/ Alert.
//	Web Element: Click/ sendkey/ submit/ select/ getText/ getAttribuilt
	public void ClickToElement(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
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
		System.out.println();
		locator = String.format(locator, (Object[]) values);
		System.out.println("Locator after = " + locator);
	}

	public String castRestParamter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void sendkeyToElement(String locator, String value) {
		element = DriverGlobal.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void sendkeyToElement(String locator, String valueToSendkey, String... values) {
		locator = castRestParamter(locator, values);
		element = DriverGlobal.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(valueToSendkey);
	}

	public void selectItemInDropdown(String locator, String valueItem) {
		element = DriverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	public void selectItemInDropdown(String locator, String valueItem, String... values) {
		locator = castRestParamter(locator, values);
		element = DriverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(valueItem);
		driver.switchTo().frame(element);
	}

	public String getValueItemInDropdown(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInDropdown(String parentLocator, String allItemsLocator, String expectedItem) throws InterruptedException {
//		  Click vào dropdown để hiển thị các item
		element = DriverGlobal.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].click();", element);

		sleepInSecond(1);
//		 Chờ các item cần hiển thị đc load thành công 
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));

//		  Define ra 1 list để store lại all items đc load ra
		elements = DriverGlobal.findElements(By.xpath(allItemsLocator));

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
		element = DriverGlobal.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = DriverGlobal.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(String locator) {
		elements = DriverGlobal.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckBox(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		if (element.isSelected() == false) {
			element.click();
		}
	}

	public void UnCheckToCheckBox(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		if (element.isSelected() == true) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator) {
		overideGlobalTimeout(shortTimeout);
		try {
		element = DriverGlobal.findElement(By.xpath(locator));
		overideGlobalTimeout(longTimeout);
		return element.isDisplayed();
		} catch (NoSuchElementException e) {
			overideGlobalTimeout(longTimeout);
			return false;
		}
	}
	
	public void overideGlobalTimeout(long timeout) {
		DriverGlobal.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayed(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		overideGlobalTimeout(shortTimeout);
		try {
			element = DriverGlobal.findElement(By.xpath(locator));
			overideGlobalTimeout(longTimeout);
			return element.isDisplayed();	
		}
			catch (Exception e){
			overideGlobalTimeout(longTimeout);
			return false;
		}
		
	}

	public boolean isElementSelected(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isElementEnabled(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowByID(String parent) {
//		  Get ra tất cả các ID
		Set<String> allWindows = DriverGlobal.getWindowHandles();

//		  Dùng vòng lặp để duyệt qua các ID đã Get
		for (String runWindows : allWindows) {
//			  Nếu như ID nào mà khác vs parent ID thì switch qua
			if (!runWindows.equals(parent)) {
				DriverGlobal.switchTo().window(runWindows);
//				  Sau khi Switch thành công thì break khỏi vòng lặp for
				break;
			}
		}
	}

	public void switchToWindowByTitle(String title) {
//		  Get ra tất cả các ID
		Set<String> allWindows = DriverGlobal.getWindowHandles();
//		  Dùng vòng lặp để duyệt qua các ID đã Get
		for (String runWindows : allWindows) {
//			  Cho switch vao cac ID truoc
			DriverGlobal.switchTo().window(runWindows);

//			  Get ra title cuả Page đó xem nó bằng cái gì
			String currentWin = DriverGlobal.getTitle();
//			  Nếu như title bằng vs title mình mong muốn thì thoát khỏi vòng lặp
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
//		  Get ra tất cả các ID
		Set<String> allWindows = DriverGlobal.getWindowHandles();

//		  Dùng vòng lặp để duyệt qua các ID đã Get
		for (String runWindows : allWindows) {
//			  Nếu cửa sổ nào mà khác với parent ID
			if (!runWindows.equals(parentWindow)) {
//				  Switch vào cửa sổ đó
				DriverGlobal.switchTo().window(runWindows);
//				  Dùng hàm close để đóng cái cửa sổ đó lại
				DriverGlobal.close();
			}
		}
		DriverGlobal.switchTo().window(parentWindow);

//		  Để kiểm tra chỉ còn lại duy nhất 1 cửa sổ (parent)
		if (DriverGlobal.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToFrameOrIframe(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		DriverGlobal.switchTo().frame(element);
	}

	public void switchToParentPage() {
		DriverGlobal.switchTo().defaultContent();
	}

	public void hoverToElement(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(String locator) {
		element = DriverGlobal.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key) {
		element = DriverGlobal.findElement(By.xpath(locator));
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
		element = DriverGlobal.findElement(By.xpath(locator));
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

//	28 ham de open 28 page
	public HeaderMyAccountPO openHeaderMyAccountPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		ClickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHeaderMyAccountPO(DriverGlobal);
	}

	public HomePO openHomePage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		ClickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHomePage(DriverGlobal);
	}

	public SearchPO opensearchPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.FOOTER_SEARCH_LINK);
		ClickToElement(AbstractPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(DriverGlobal);
	}

	public FooterMyAccountPO openFooterMyAccountPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		ClickToElement(AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(DriverGlobal);
	}

	public Shipping_ReturnPO openShipping_ReturnPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
		ClickToElement(AbstractPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);

		return PageGeneratorManager.getShipping_ReturnPage(DriverGlobal);
	}

	public SitemapPO openSiteMapPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.FOOTER_SITEMAP_LINK);
		ClickToElement(AbstractPageUI.FOOTER_SITEMAP_LINK);
		return PageGeneratorManager.getSitemapPage(DriverGlobal);
	}

	public RegisterPO openRegisterPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.HEADER_REGISTER_LINK);
		ClickToElement(AbstractPageUI.HEADER_REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(DriverGlobal);
	}

	public LoginPO openLoginPage(WebDriver DriverGlobal) {
		waitToElementVisible(AbstractPageUI.HEADER_LOGIN_LINK);
		ClickToElement(AbstractPageUI.HEADER_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(DriverGlobal);
	}

// 1 ham de mo 28 page(n - page)
	public AbstractPageObject openMultiplePage(String pageName) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		switch (pageName) {
		case "My account":
			return PageGeneratorManager.getFooterMyAccountPage(DriverGlobal);

		case "Sitemap":
			return PageGeneratorManager.getSitemapPage(DriverGlobal);

		case "Search":
			return PageGeneratorManager.getSearchPage(DriverGlobal);

		case "Shipping & returns":
			return PageGeneratorManager.getShipping_ReturnPage(DriverGlobal);

		default:
			return PageGeneratorManager.getHomePage(DriverGlobal);
		}
	}

//		Ko cần return vì(quá nhiều page)
	public void openMultiplePages(String pageName) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
	}
//	Dynamic Element Component
	public void inputToDynamicTextbox(String textboxID, String value) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_TEXTBOX, textboxID);
		sendkeyToElement(AbstractPageUI.DYNAMIC_TEXTBOX, value,textboxID);
	}
	
	public void inputToDynamicTextArea(String textboxID, String value) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_TEXTAREA, textboxID);
		sendkeyToElement(AbstractPageUI.DYNAMIC_TEXTAREA, value,textboxID);
	}
	
	public void clickToDynamicButton(String buttonValue) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(AbstractPageUI.DYNAMIC_BUTTON,buttonValue);
	}
	
	public void clickToDynamicCheckBox(String checkboxID) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_CHECKBOX, checkboxID);
		clickToElement(AbstractPageUI.DYNAMIC_CHECKBOX, checkboxID);
	}
	
	public void clickToDynamicRadioButton(String radioButtonID) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
		clickToElement(AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
	}
	
	public void selectToDynamicDropdown(String dropdownName, String itemValue) throws InterruptedException {
		waitToElementVisible(AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownName);
		selectItemInDropdown(AbstractPageUI.DYNAMIC_DROPDOWN_LIST,itemValue,dropdownName);
	}
	
	public String getDynamicRequiredFieldErrorMessage(String fieldID ) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_REQUIRED_FIELDS_ERROR_MSG, fieldID);
		return getTextElement(AbstractPageUI.DYNAMIC_REQUIRED_FIELDS_ERROR_MSG, fieldID);
		
		
	}
}
