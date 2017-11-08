package pages;

import java.util.Map;
import java.util.Random;

import util.*;
import cucumber.api.DataTable;

public class CreateEditVendorPage {
	
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();
	Property property;
	/*
	 * Description: Search for existing Vendor.
	 * */
	public void searchExistingAgencyVendor(DataTable vendorDetails) {
		utility.pageLoadTimeout();
		Map<String,String> vendorMap =vendorDetails.asMap(String.class, String.class);
		 String vendorFullName = vendorMap.get("Full Name");
		 String vendorShortName=vendorMap.get("Short Name");
		 String vendorAbbre=vendorMap.get("Abbreviation");
		 String vendorType=vendorMap.get("Vendor Type");
		 String vendorActive=vendorMap.get("Active");
		 
		 Random rand = new Random();
		 int vendorRandom = rand.nextInt(999);
		 
		 if(vendorFullName!="" && vendorFullName.equalsIgnoreCase("Random")){
			 vendorFullName = "Vendor_" + vendorRandom;
			 utility.enterText(locatorTypeObj.id, "name", vendorFullName);
			 Property.vendorName = vendorFullName;
			 Property.vendorAbbr = vendorAbbre + vendorRandom;
		 }
		 
		 if(!vendorShortName.equals("")){
			 utility.enterText(locatorTypeObj.id, "shortName", vendorShortName);
		 }
		 
		 if(vendorActive!=null){
			 utility.clickElement(locatorTypeObj.id, "active");
		 }
		 
		 if(!vendorAbbre.equals("")){
			 utility.enterTextAuto(locatorTypeObj.id, "abbreviation", Property.vendorAbbr);
		 }
		 
		 if(vendorType!=""){
			 utility.selectValueFromDD(locatorTypeObj.id, "vendorType", "Agency");
		 }
		 
		 utility.clickElement(locatorTypeObj.xpath, "//input[@value='Search']");
	 }
	
	
	public void fillCreateVendorForm(DataTable values){
		
		utility.pageLoadTimeout();
		Map<String,String> vendorMap =values.asMap(String.class, String.class);
		
		String vendorType  =vendorMap.get("Vendor Type");
		String fullName= vendorMap.get("Full Name");
		String abbreviation=vendorMap.get("Abbreviation");
		String mediaType= vendorMap.get("Media Buy Type");
		String subMaster = vendorMap.get("Sub Master");
		String currency = vendorMap.get("Currency");
		String maxCommission= vendorMap.get("Max Commission");
		
		if(vendorType!=null){
			utility.selectValueFromDD(locatorTypeObj.id, "vendorType",vendorType);
		}
		// fullName
		if(fullName!=null){
			if(fullName.equalsIgnoreCase("Random")){
				Random random =  new Random();
				fullName = "Vendor_" + random.nextInt(999);
				utility.enterText(locatorTypeObj.id, "name", fullName);
				Property.vendorName = fullName;
			}
			else if(fullName.equalsIgnoreCase("Property")){
				utility.enterText(locatorTypeObj.id, "name", Property.vendorName);
			}
		}
		
		if(abbreviation!=null){
			utility.enterText(locatorTypeObj.id, "abbreviation", Property.vendorAbbr);
		}
		
		if(mediaType!=null){
			// Regular
			if(mediaType.contains("1")){
				utility.clickElement(locatorTypeObj.cssSelector, "input[value='REGULAR']");
			}
			// PI
			if(mediaType.contains("2")){
				utility.clickElement(locatorTypeObj.cssSelector, "input[value='PI']");
			}
			// Guarantee
			if(mediaType.contains("3")){
				utility.clickElement(locatorTypeObj.cssSelector, "input[value='GURANTEE']");
			}
		}
		
		//subMaster
		if(subMaster!=null){
			utility.selectValueFromDD(locatorTypeObj.id, "tapeType",subMaster);
		}
		// currency
		if(currency!=null){
			utility.selectValueFromDD(locatorTypeObj.id, "currencyId",currency);
		}
		//maxCommission
		if(maxCommission!=null){
			utility.enterText(locatorTypeObj.id, "maxCommission", maxCommission);
		}
	}
	
	public void clickSave(){
		utility.clickElement(locatorTypeObj.cssSelector, "input[value='Save']");
	}
	
	public void addPermission (DataTable values) {
		utility.pageLoadTimeout();
		Map<String,String> vendorMap =values.asMap(String.class, String.class);
		
		String creative  =vendorMap.get("Creative");
		String endDate= vendorMap.get("End Date");
		String mediaType= vendorMap.get("Media Type");
		
		if(creative!=null){
			utility.enterTextAuto(locatorTypeObj.id, "pscvrl", creative);
		}
		if(mediaType!=null){
			utility.enterText(locatorTypeObj.id, "mediaType", mediaType);
		}
		if(endDate!=null){
			utility.enterText(locatorTypeObj.id, "endDate", endDate);
		}
		
		//click Next
		utility.clickElement(locatorTypeObj.id, "createPermissionButton");
		// Add Agency Product code
		String productCode =utility.getText(locatorTypeObj.xpath, "//div[@id='permission-form']//div[@class='div-table-col3']").replace("*", "");
		utility.enterText(locatorTypeObj.id, "mcpc_"+productCode, productCode);
		utility.clickElement(locatorTypeObj.id, "button"+productCode);
		//close Tab
		utility.clickElement(locatorTypeObj.id, "cancelTranslation");
	}
	
	public void addContact (DataTable values) {
		utility.pageLoadTimeout();
		Map<String,String> contactMap =values.asMap(String.class, String.class);
		
		String name  =contactMap.get("Name");
		
		if(name!=null){
			if(name.equalsIgnoreCase("Property"))
			utility.enterText(locatorTypeObj.id, "name", Property.vendorName );
		}
		
		//click Next
		utility.clickElement(locatorTypeObj.name, "create");
	}
	
	

}
