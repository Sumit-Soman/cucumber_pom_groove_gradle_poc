package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.DataTable;

public class SearchVendorPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();

	public void enterVendorType(DataTable enterType) {
		List<List<String>> eT = enterType.raw();
		utility.enterDropDownID("vendorType", eT.get(1).get(1));
	}

	public void verifySearchResultVendorType(DataTable verifyVendorType) {
		List<List<String>> vT = verifyVendorType.raw();
		int limit = utility.getRowCount();
		utility.verifyColumn(vT.get(1).get(1), 4, "Vendor Type", limit,"Search Vendor");
	}
	
	
	/**
	  * The method allows the user to search for an existing agency vendor
	  * on the Search Vendor page.
	  * @param vendorToSearch
	  * @return
	  */
	 public void searchExistingAgencyVendor(DataTable vendorDetails) {
		 driver.manage().timeouts()
			.pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		 List<List<String>> vd = vendorDetails.raw();
		 String vendorName = vd.get(1).get(1);
		 String vendorShortName=vd.get(2).get(1);
		 String vendorAbbre=vd.get(3).get(1);
		 String vendorType=vd.get(4).get(1);
		 String vendorActive=vd.get(5).get(1);
		 if(vendorName!=""){
			 utility.enterText(locatorTypeObj.id, "name", vendorName);
		 }
		 
		 if(!vendorShortName.equals("")){
			 utility.enterText(locatorTypeObj.id, "shortName", vendorName);
		 }
		 
		 if(vendorActive.equalsIgnoreCase("yes")){
			 utility.clickElement(locatorTypeObj.id, "active");
		 }
		 
		 if(!vendorAbbre.equals("")){
			 utility.enterTextAuto(locatorTypeObj.id, "abbreviation", vendorAbbre);
		 }
		 
		 if(vendorType!=""){
			 utility.selectValueFromDD(locatorTypeObj.id, "vendorType", "Agency");
		 }
		 
		 utility.clickElement(locatorTypeObj.xpath, "//input[@value='Search']");
	 }
	 
	 public void verifyVendorSearch(DataTable name){
		 List<List<String>> vd = name.raw();
		 utility.sleep(3000);
		 String vendorName =utility.getText(locatorTypeObj.cssSelector, "tr.odd.edit > td");
		 assertTrue("Vendor not found",vendorName.equalsIgnoreCase(vd.get(1).get(1).toString()));
	 }
	
}
