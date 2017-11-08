package pages;

import driver.DriverFactory;

public class CreateDubHouseJobRequestPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyCreateDubHouseJobRequestPage(){
		
		utility.pageLoadTimeout();
		utility.verifyPageID("DHWRjobType","Create Dub House Job Request","Create Dub House Job Request");
	}
}