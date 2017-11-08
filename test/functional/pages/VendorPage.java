package pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.Property;
import cucumber.api.DataTable;
import driver.DriverFactory;

public class VendorPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();

	
	public void addPermission (DataTable permissionDetails) {
		utility.pageLoadTimeout();
		
		List<List<String>> vd = permissionDetails.raw();
		String mediaType = vd.get(1).get(1).toString();
		// navigate to Permission Tab
		utility.clickElement(locatorTypeObj.id, "permissionTab");
		utility.clickElement(locatorTypeObj.id, "createPermission");
		// Select Media type
		utility.selectValueFromDD(locatorTypeObj.id, "mediaType", mediaType);
		// Enter Creative Name
		enterTextException(locatorTypeObj.id, "pscvrl", Property.psvrCreative);
		// Enter end date

		utility.clickElement(locatorTypeObj.id, "endDate");
//		if(utility.getAttribute(locatorTypeObj.id, "endDate", "value").equalsIgnoreCase("")){
//			utility.enterText(locatorTypeObj.id, "endDate", "12/26/9999");
//		}

		//click Next
		utility.clickElement(locatorTypeObj.id, "createPermissionButton");
		// Add Agency Product code
		String productCode =utility.getText(locatorTypeObj.xpath, "//div[@id='permission-form']//div[@class='div-table-col3']").replace("*", "");
		utility.enterText(locatorTypeObj.id, "mcpc_"+productCode, productCode);
		utility.clickElement(locatorTypeObj.id, "button"+productCode);
		//close Tab
		utility.clickElement(locatorTypeObj.id, "cancelTranslation");
	}

	
	public void enterTextException(int locatorType, String locator, String input) {
		utility.explicitWait(explicitCondTypeobj.elementispresent, locatorType, locator, null);
		
		WebElement testElement = driver.findElement(utility.byLocator(locatorType, locator));
		testElement.sendKeys(input);
		utility.sleep(2000);
		testElement.clear();
		testElement.sendKeys(input);
		utility.sleep(2000);

		testElement.sendKeys(Keys.ARROW_DOWN);
		testElement.sendKeys(Keys.ENTER);
		
	}

}
