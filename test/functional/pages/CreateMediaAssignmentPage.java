package pages;

import driver.DriverFactory;

public class CreateMediaAssignmentPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyCreateMediaAssignmentPage(){
		utility.pageLoadTimeout();
		utility.verifyPageID("CMAmediaAgency","Create Media Assignment","Create Media Assignment");
	}
}