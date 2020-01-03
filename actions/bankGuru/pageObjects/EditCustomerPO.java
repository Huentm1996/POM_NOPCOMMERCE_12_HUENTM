package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class EditCustomerPO extends AbstractPageObject {
	WebDriver driver;
	public EditCustomerPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
