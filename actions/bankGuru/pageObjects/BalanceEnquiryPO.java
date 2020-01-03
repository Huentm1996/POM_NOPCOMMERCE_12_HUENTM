package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class BalanceEnquiryPO extends AbstractPageObject {
	WebDriver driver;
	public BalanceEnquiryPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
