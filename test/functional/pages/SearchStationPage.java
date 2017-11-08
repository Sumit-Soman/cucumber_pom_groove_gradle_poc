package pages;

import driver.DriverFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

import util.ExcelReader;
import util.Property;
import static org.junit.Assert.assertTrue;
import cucumber.api.DataTable;

public class SearchStationPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	ExplicitConditionType explicitObj = new ExplicitConditionType();
	LocatorType locatorObj = new LocatorType();
	public static String FullName;
	public static String ShortName;
	File stationFile=null;

	public void enterValuesStation(DataTable enterValues) {
		// Enter Status
		utility.enterDropDownCheckBox(
				"//*[@id=\"stationSearchForm\"]/div[1]/div/div[1]/div[1]/button",
				"//*[@id=\"ui-multiselect-status-option-0\"]");
		// Enter Station Type
		if (SeleniumUtility.Internal) {
			utility.enterDropDownCheckBox(
					"//*[@id=\"stationSearchForm\"]/div[1]/div/div[1]/div[9]/button",
					"//*[@id=\"ui-multiselect-stationTypes-option-1\"]");
		} else {
			utility.enterDropDownCheckBox(
					"//*[@id=\"stationSearchForm\"]/div[1]/div/div[1]/div[7]/button",
					"//*[@id=\"ui-multiselect-stationTypes-option-1\"]");
		}
	}

	public void verfiyStationsPage(DataTable resultValues) {
		int limit = utility.getRowCount();
		List<List<String>> rV = resultValues.raw();
		// Verify Status
		utility.verifyStatus(limit);
		// Verify Station Type
		if (SeleniumUtility.Internal) {
			utility.verifyColumn(rV.get(2).get(1), 8, "Station Type", limit,"Search Tapes");
		}
		else
		{
			utility.verifyColumn(rV.get(2).get(1), 7, "Station Type", limit,"Search Tapes");
		}
	}
	
	public void openCreateStationPage() {
		utility.pageLoadTimeout();
		utility.clickElement(locatorObj.xpath, "//*[@id=\"pageBody\"]/div[2]/div/div/span/a");
	}

	public void enterCreateStationPageData(DataTable enterCreateValues) {

		List<List<String>> eCV = enterCreateValues.raw();

		// Enter Full Name
		utility.enterTextBoxIDPerformance("//*[@id=\"name\"]", FullName);
		// Enter Short Name
		utility.enterTextBoxIDPerformance("//*[@id=\"shortName\"]", ShortName);
		// Select Station Type
		utility.enterDropDownXpath("//*[@id=\"stationType\"]", eCV.get(3)
				.get(1));
		// Select Region
		utility.enterDropDownXpath("//*[@id=\"region.id\"]", eCV.get(4).get(1));
		// Select TimeZone
		utility.enterDropDownXpath("//*[@id=\"timeZone\"]", eCV.get(5).get(1));

	}

	public void stationCreationWarning() {
		utility.sleep(2000);
		String status = utility.getText(locatorObj.xpath, "//*[@id=\"stationTextFields\"]/table/tbody/tr/td[1]/div/div[1]/div[2]/div");
		assertTrue("Results do not Match According to ",status.equalsIgnoreCase("field is mandatory"));
	}
	
	public void verifyStationCreation() {
		assertTrue("Dubbing and TeleMarketing is not Displayed",utility.isDisplayed(locatorObj.xpath, "//*[@id=\"dubbingAndTelemarketingTab\"]"));
	}
	
	public void enterDebuggingDetailsData(DataTable enterDebuggingValues){
		
		utility.clickElement(locatorObj.id, "dubbingAndTelemarketingTab");
		utility.clickElement(locatorObj.xpath, "//*[@id=\"dubbingAndTelemarketingDetails\"]/div/form/div/div/input[2]");
		List<List<String>> eDV = enterDebuggingValues.raw();

		// Enter 
		utility.enterDropDownXpath("//*[@id=\"airContentFormatSDLongform\"]", eDV.get(1).get(1));
		// Enter 
		utility.enterDropDownXpath("//*[@id=\"tapeQuantity\"]", eDV.get(2).get(1));
		// Select
		utility.enterDropDownXpath("//*[@id=\"airContentFormatSDShortform\"]", eDV.get(3).get(1));
		// Select
		utility.enterDropDownXpath("//*[@id=\"longformLengthHours\"]", eDV.get(4).get(1));
		utility.clickElement(locatorObj.xpath, "//*[@id=\"editstationInstance?.dubbingAndTelemarketingTemplate\"]/div/form/div/div/div[4]/div/input[3]");
		
		
	}
	
	public void openContactDetailstab() {
		utility.clickElement(locatorObj.xpath, "//*[@id=\"contactsTab\"]");
	}
	
	public void enterContactDetailsData(DataTable enterContactValues){
		
		utility.clickElement(locatorObj.xpath, "//*[@id=\"createContact\"]");
		List<List<String>> eCDV = enterContactValues.raw();
		
		// Select 
		utility.enterDropDownXpath("//*[@id=\"contactType\"]", eCDV.get(2).get(1));
		utility.sleep(5000);
		
		// Enter Address
		utility.enterTextBoxIDPerformance("//*[@id=\"address.line1\"]", eCDV.get(3).get(1));
		utility.handleWindowAlert();
		utility.sleep(1000);
		
		// Enter Name
		utility.enterTextBoxIDPerformance("//*[@id=\"name\"]", eCDV.get(1).get(1));
		utility.handleWindowAlert();
				
		utility.clickElement(locatorObj.xpath, "//*[@id=\"createContactContainer\"]/form/div[2]/input[1]");
	}
	
	public void openAgencyPermissionstab(){
		utility.clickElement(locatorObj.xpath, "//*[@id=\"agencyPermissionsTab\"]");
	}
	
	public void exportToExcel() {
		utility.pageLoadTimeout();
		utility.clickElement(locatorObj.classtype, "exportToExcel_Btn");
	}
	
	public void verifyStationFile(){
		stationFile = new File(Property.exportExcelPath + "station.xls");
		assertTrue("Failed to Download Excel", stationFile.exists());
	}
	
	public void verifyExcelCount(){
		if(stationFile.exists()){
			ExcelReader eRObj = new ExcelReader();
			int rowCount = eRObj.getRowCount(Property.exportExcelPath + "station.xls");
			
			// Get Count from Search Station Page
			String status = utility.getText(locatorObj.classtype, "listCount");
			String count= status.substring(0, status.indexOf(" "));
			System.out.println("Excel Count: "+ rowCount + " ...stationCount: " + count);
			assertTrue("Record count mismatch between Excel and Search Station Page",rowCount==Integer.parseInt(count));
		}
	}
	
	public void moveAllAndSave(){
		utility.clickElement(locatorObj.xpath, "//*[@id=\"button2\"]");
		utility.clickElement(locatorObj.xpath, "//*[@id=\"agencyPermissions\"]/form/div/div[3]/div/div/input");
	}
	
	public void verfiyRegressStationsPage() {
		int randomVersion=0;
		utility.explicitWait(explicitObj.elementisinvisible, locatorObj.cssSelector, "img[id='spinner']",null );
		String searchResult = utility.getText(locatorObj.xpath, "//*[@id=\"searchResultList\"]/div");
		Random random = new Random();
		
		while(!searchResult.equalsIgnoreCase("No Station Record(s) found")){
			randomVersion = random.nextInt(999);
			FullName = FullName + "_" + randomVersion;
			ShortName = ShortName + "_" + randomVersion;
			// Fill form
			utility.enterTextBoxIDEsc("name", FullName);
			utility.enterTextBoxIDEsc("shortName", ShortName);
			
			//click Search
			utility.clickElement(locatorObj.id,"search");
			
			utility.explicitWait(explicitObj.elementisinvisible, locatorObj.cssSelector, "img[id='spinner']",null );
			searchResult = utility.getText(locatorObj.xpath, "//*[@id=\"searchResultList\"]/div");
		}
	}
	
	
	public void enterRegressValuesStation(DataTable enterValues) {
		List<List<String>> ev = enterValues.raw();
		FullName = ev.get(1).get(1);
		ShortName = ev.get(2).get(1);
		// Enter Full Name
		utility.enterTextBoxIDEsc("name", FullName);

		// Enter Short Name
		utility.enterTextBoxIDEsc("shortName", ShortName);

	}
	
}
