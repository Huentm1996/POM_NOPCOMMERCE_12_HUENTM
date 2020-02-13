package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class SearchPO extends AbstractPageObject {
	WebDriver driver;

	public SearchPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
