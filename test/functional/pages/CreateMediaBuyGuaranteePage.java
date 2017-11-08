package pages;

import driver.DriverFactory;

public class CreateMediaBuyGuaranteePage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	
	public void verifyCreateMediaBuyGuarantee(){
		utility.pageLoadTimeout();
		
		utility.verifyPageID("amount","Verify Create Mediabuy Guarantee","Create Mediabuy Guarantee");
	}
}