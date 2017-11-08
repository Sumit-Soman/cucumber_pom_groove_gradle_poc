package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import driver.DriverFactory;
import util.Property;
import static org.junit.Assert.assertTrue;

public class CreativePage extends DriverFactory {
	
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();
	
	public void createCreative(DataTable enterValues){
		utility.pageLoadTimeout();
		Map<String,String> creativeMap =enterValues.asMap(String.class, String.class);
		
		String mediaType =creativeMap.get("Media Type");
		String product= creativeMap.get("Product");
		String show=creativeMap.get("Show");
		String region= creativeMap.get("Region");
		String allowable = creativeMap.get("Allowable");
		String productaddr = creativeMap.get("productAbbre");
		String showaddr= creativeMap.get("showAbbre");
		String lang = creativeMap.get("Language");
		String version = creativeMap.get("Version");
		// 
		String tfn = creativeMap.get("TFN");
		
		// Media Type
		if(mediaType!=null){
			utility.enterDropDownID("mediaType", mediaType);
		}
		// Product
		if(product!=null){
			enterTextException(locatorTypeObj.id,"product", product);
			utility.enterText(locatorTypeObj.id, "productAbbreviation", productaddr);
		}
		if(show!=null){
			utility.enterText(locatorTypeObj.id,"show", show);
			utility.enterText(locatorTypeObj.id, "showAbbreviation", showaddr);
		}
		
		//Language
		if(lang!=null){
			utility.selectValueFromDD(locatorTypeObj.id, "language",lang);
		}
		// Region
		if(region!=null){
			utility.enterDropDownID("region", region);
		}
		
		// TFN
		if(tfn!=null && tfn.equalsIgnoreCase("Check")){
			utility.clickElement(locatorTypeObj.id, "details.bypassTfn");
		}
		
		// Version
		if(version!=null){
			utility.enterTextBoxID("creativeVersion",version);
		}else{
			utility.enterTextBoxID("creativeVersion",String.valueOf(Property.creativeVersion));
		}
		
		// Station Type
		utility.clickElement(locatorTypeObj.xpath, "//div[@id='stationTypeAllowableDiv']/button");
		
		// Station Type:  Check All
		utility.clickElement(locatorTypeObj.xpath, "//a/span[2]");
		
		// Allowable
		if(allowable!=null){
			utility.enterTextBoxID("allowable", allowable);
		}
		// Click Add button
		utility.clickElement(locatorTypeObj.id, "add");
		int stationCount = utility.getRowCount("//span[@class='items']/span");
		int tablecount = utility.getRowCount("//table[@id='allowableTable']/tbody/tr");
		
		assertTrue("Failed to add all the Allowables",stationCount==tablecount);
		assertTrue("Failed to populate productAbbreviation properly", utility.getAttribute(locatorTypeObj.id, "productAbbreviation","value").equalsIgnoreCase("TMT"));
		assertTrue("Failed to populate ShowAbbrevaition properly", utility.getAttribute(locatorTypeObj.id, "showAbbreviation","value").equalsIgnoreCase("FRS"));
		// click Save button
		utility.clickElement(locatorTypeObj.xpath, "//input[@class='cta_button']");
	}
	
	public void verifySuccessMessage(){
		utility.sleep(2000);
		String message=utility.getText(locatorTypeObj.classtype, "success");
		assertTrue("Failed to Save Creative",message!=null && message.contains("successfully"));
	}
	
	/*Description: Fetch psvr from the status Message
	 * 
	 * */
	public void getPSVR(){
		utility.sleep(1000);
		String message=utility.getText(locatorTypeObj.classtype, "success");
		Property.psvrCreative=message.substring(message.indexOf("\"")+1,message.lastIndexOf("\""));
	}

	public void addDubMasterAndSub(DataTable enterDetails){
		
		utility.pageLoadTimeout();
		
		List<List<String>> dD=enterDetails.raw();
		String dubHouse = dD.get(1).get(1);
		String tapeType = dD.get(2).get(1);
		
		utility.clickElement(locatorTypeObj.id, "createMaster");
		utility.enterText(locatorTypeObj.id, "master", "DubMaster_"+Property.creativeVersion);
//		utility.selectValueFromDD(locatorTypeObj.id, "dubHouse.id", dubHouse);
		utility.explicitWait(explicitCondTypeobj.elementisvisible, locatorTypeObj.id, "dubHouse.id", null);
		WebElement testElement = driver.findElement(utility.byLocator(locatorTypeObj.id, "dubHouse.id"));
		Select dropDown = new Select(testElement);
		dropDown.selectByValue("95");
		
		System.out.println("Master Added succesfully.....................");
		utility.clickElement(locatorTypeObj.id, "saveMaster");
		// Verify the Dub Master created successfully
		utility.sleep(1000);
		String msg =utility.getText(locatorTypeObj.xpath, "//div[@id='dubMaster-list']/div/div[@class='success']");
		assertTrue("Dub Master Creation failed",msg!=null && msg.equalsIgnoreCase("Master successfully created"));
		
		utility.clickElement(locatorTypeObj.id ,"createSubMaster");
		//utility.selectValueFromDD(locatorTypeObj.id, "dubHouse", dubHouse);
		// For JEnkins
		utility.explicitWait(explicitCondTypeobj.elementisvisible, locatorTypeObj.id, "dubHouse", null);
		testElement = driver.findElement(utility.byLocator(locatorTypeObj.id, "dubHouse"));
		dropDown = new Select(testElement);
		dropDown.selectByValue("95");
		
		utility.selectValueFromDD(locatorTypeObj.id, "master", "DubMaster_"+Property.creativeVersion);
		utility.enterText(locatorTypeObj.id, "subMaster", "SubDubMaster_"+Property.creativeVersion);
		// Add Tap type
		utility.selectValueFromDD(locatorTypeObj.id, "tapeType", tapeType);
		utility.clickElement(locatorTypeObj.id, "saveDubMaster");
		
		System.out.println("Sub Master Added succesfully.....................");
		
		// Verify the Dub Master created successfully
		utility.sleep(1000);
		msg =utility.getText(locatorTypeObj.xpath, "//div[@id='dubMaster-list']/div/div[@class='success']");
		assertTrue("Sub Master Creation Failed",msg!=null && msg.equalsIgnoreCase("SubMaster successfully created"));
		
		System.out.println("Both Sub and Master Added succesfully.....................");
	}
	
	public void addDNSGroup(DataTable data){
		
		List<List<String>> dnsD=data.raw();
		String agency=dnsD.get(1).get(1);
		String callCenterName=dnsD.get(2).get(1);
		
		utility.clickElement(locatorTypeObj.link, "Add DNIS Group");
		// Add Name TO DNS Group
		utility.enterText(locatorTypeObj.id, "code", "DDNSGroup_"+ Property.creativeVersion);
		utility.clickElement(locatorTypeObj.id, "createOfferScript");
		WebElement element = driver.findElement(By.id("dnisOfferScriptsOfferName"));
		element.click();
		utility.sleep(3000);
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);
		utility.clickElement(locatorTypeObj.id, "validateOfferScript");
		assertTrue("Offer not added successfully",utility.getText(locatorTypeObj.xpath, "//table[@id='dnisOfferScriptTable']/tbody/tr/td/label").equalsIgnoreCase("control"));
		
		// Create Agency
		utility.clickElement(locatorTypeObj.id, "createDNISMediaCompany");
		utility.selectValueFromDD(locatorTypeObj.id, "dnisMediaCompanys",agency);
		utility.clickElement(locatorTypeObj.xpath, "//input[@id='button']");
		utility.clickElement(locatorTypeObj.id, "validateMediaCompanys");
		assertTrue("Agency not added successfully",utility.getText(locatorTypeObj.xpath, "//table[@id='mediaCompanyTable']/tbody/tr/td").equalsIgnoreCase(agency));
		//Add Call Center
		utility.clickElement(locatorTypeObj.id, "createRoutedCallCenters");
		utility.selectValueFromDD(locatorTypeObj.id, "routedCallCenters", callCenterName);
		utility.clickElement(locatorTypeObj.xpath, "//div[@id='routedCallCenters-form']//input[@id='button']");
		utility.clickElement(locatorTypeObj.id, "validateRoutedCallCenters");
		assertTrue("Agency not added successfully",utility.getText(locatorTypeObj.xpath, "//table[@id='callCenterTable']/tbody/tr/td").equalsIgnoreCase(callCenterName));
		// Save DNS Group Details
		utility.clickElement(locatorTypeObj.cssSelector, "#saveBtnsBottom > input.cta_button");
		utility.sleep(1000);
		
		System.out.println("DNIS Added succesfully.....................");
		
	}
	
	public void verifyDNSGroup() {
		assertTrue("Failed to add DNS Group", utility.getText(locatorTypeObj.id, "dnisCodeSuccess").equalsIgnoreCase("DNIS Group successfully created"));
		Property.dnsGroup=utility.getText(locatorTypeObj.xpath, "//*[@id='dnisCodeForm']/div/div[1]/span[1]");
	}
	
	public void enterTextException(int locatorType,String locator ,String value) {
		utility.explicitWait(explicitCondTypeobj.elementisvisible,locatorType,locator,null);
		WebElement testElement = driver.findElement(utility.byLocator(locatorType, locator));

		testElement.sendKeys(value);
		utility.sleep(2000);
		testElement.clear();
		utility.sleep(2000);
		testElement.sendKeys(value);
		utility.sleep(2000);

		testElement.sendKeys(Keys.ARROW_DOWN);
		testElement.sendKeys(Keys.ENTER);
	}
	
	/*
	 * Description: Edit Creative
	 * 
	 * */
	public void editCreative(DataTable input){
		utility.pageLoadTimeout();
		Map<String,String> creativeMap =input.asMap(String.class, String.class);
		
		String desc = creativeMap.get("Description");
		String tfn = creativeMap.get("TFN");
		String endDate = creativeMap.get("EndDate");
		// Desc
		if(desc!=null){
			utility.enterText(locatorTypeObj.id, "details.description", desc);
		}
		// TFN
		if(tfn!=null){
			utility.clickElement(locatorTypeObj.id, "bypassTfn");
		}
		// End date
		if(endDate!=null){
			utility.enterText(locatorTypeObj.id, "endDate", endDate);
		}
		
		// Click on Save
		utility.clickElement(locatorTypeObj.id, "updateCreative");
	}
	
	public void verifyErrorValidation(){
		String msg = utility.getText(locatorTypeObj.id, "stationTypeAllowErrors");
		assertTrue("Validation Failed on Create Creative page",msg.equalsIgnoreCase("Please set up an Allowable for this Creative."));
	}
	
	
}
