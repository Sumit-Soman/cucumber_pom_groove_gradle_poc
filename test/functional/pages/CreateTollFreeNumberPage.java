package pages;

import driver.DriverFactory;

public class CreateTollFreeNumberPage extends DriverFactory {

	SeleniumUtility utility = new SeleniumUtility();

	public void verifyCreateTollFreeNumberPage() {

		utility.pageLoadTimeout();
		
		utility.verifyPageID("contractType", "Create Toll Free Number ", "Create Toll Free Number");

	}

}