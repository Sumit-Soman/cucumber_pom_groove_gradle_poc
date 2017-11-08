package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;


public class GeneratePaymentRequestRegularPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();


	public void verifySearchResultGeneratePaymentRequestRegular() {
		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.id, "processing", null);
		String status =utility.getText(locatorTypeObj.classtype, "listCount");
		assertTrue("No Records Found",status.contains("No Media Buy Records found."));
		
	}
	
    public void enterDropDownCheckBox(String location) {
        utility.selectValueFromDD(locatorTypeObj.cssSelector, location, "External Billed");
    }
}
