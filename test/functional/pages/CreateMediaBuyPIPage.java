package pages;

import driver.DriverFactory;

public class CreateMediaBuyPIPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyCreateMediaBuyPI(){
		utility.pageLoadTimeout();
		
		utility.verifyPageID("agency","Verify Create Mediabuy PI","Create Mediabuy PI");
	}
}