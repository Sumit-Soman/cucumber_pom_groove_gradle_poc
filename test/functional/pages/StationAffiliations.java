package pages;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Random;

import util.Property;
import driver.DriverFactory;
import cucumber.api.DataTable;

public class StationAffiliations extends DriverFactory {

	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	
	public void enterStationAffiliation(DataTable enterValues) throws InterruptedException{
		utility.pageLoadTimeout();		
		Map<String,String> affiliationMap = enterValues.asMap(String.class, String.class);
		String affliation = affiliationMap.get("Affiliation");
		Random random  = new Random();
		
		while(true){
			affliation = affliation + "_" + random.nextInt(999);
			if(affliation != null){
				utility.enterText(locatorTypeObj.id, "name", affliation);
			}
			utility.clickElement(locatorTypeObj.name, "_action_updateParentStationGrid");
			System.out.println("Cli=cked on Add affliation......");
			if(utility.isDisplayed(locatorTypeObj.classtype, "success"))
				break;
		}
	}
	
	
	public void verifyAffiliation() {

		int limit = utility.getRowCount(locatorTypeObj.cssSelector, "div.parentStationGrid table tbody tr");
		boolean success= false;
		System.out.println("Limit " + limit);
		for (int i = 1; i <= limit;) {
			String affiliation =utility.getText(locatorTypeObj.cssSelector, "div.parentStationGrid table tbody tr:nth-child("+ i +") td");
			System.out.println(affiliation + " scanned");
			if(affiliation.equalsIgnoreCase(Property.affliationName))
				success = true;
				System.out.println("success");
				break;
		}
		
		assertTrue("Failed to add affiliation..", !success);
	}


}
