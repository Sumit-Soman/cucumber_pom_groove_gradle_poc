package pages;

import driver.DriverFactory;

public class CreatePayoutPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyCreatePayoutPage(){
		
		utility.pageLoadTimeout();
		
		utility.verifyPageID("contractType","Create Payout","Create Payout Page");
	}
}