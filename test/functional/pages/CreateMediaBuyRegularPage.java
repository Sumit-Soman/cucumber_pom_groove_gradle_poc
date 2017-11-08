package pages;

import driver.DriverFactory;

public class CreateMediaBuyRegularPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyCreateMediaBuyRegular(){
		utility.pageLoadTimeout();
		utility.verifyPageID("station","Verify Create Mediabuy Regular","Create Mediabuy Regular");
	}
}