package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;

public class ManageConfirmationAndRevisionsPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void selectAllExternalBilled() {
		utility.clickElement(locatorTypeObj.id, "externalMediaBuy");
	}

	public void verifySearchResultManageConfirmation() {
		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		String Actualtext = utility.getText(locatorTypeObj.xpath, "//*[@id=\"searchResultList\"]/div[5]/div[1]/div/a");
		assertEquals(Actualtext, "Export To Excel");
		

	}
}
