package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class NewCustomerPO extends AbstractPageObject {
	WebDriver driver;
	public NewCustomerPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
