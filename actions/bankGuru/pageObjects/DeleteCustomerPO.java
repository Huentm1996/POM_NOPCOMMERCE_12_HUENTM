package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class DeleteCustomerPO extends AbstractPageObject {
	WebDriver driver;
	public DeleteCustomerPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
