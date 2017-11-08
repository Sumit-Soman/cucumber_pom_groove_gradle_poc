package pages;

import driver.DriverFactory;



public class CreateTapeFileRequestPage extends DriverFactory {
    SeleniumUtility utility = new SeleniumUtility();

    public void verifyCreateTapeFileRequestPage() {
		utility.pageLoadTimeout();
		
        utility.verifyPageID("videoDefinitionType", "Create Tape File Request", "Create Tape File Request");
    }
}