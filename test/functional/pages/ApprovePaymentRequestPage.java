package pages;

import driver.DriverFactory;

public class ApprovePaymentRequestPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyApprovePaymentRequestPage(){
		utility.pageLoadTimeout();
		utility.verifyPageID("collapseAll","Approve Payment Request","Approve Payment Request Page");
	}
}