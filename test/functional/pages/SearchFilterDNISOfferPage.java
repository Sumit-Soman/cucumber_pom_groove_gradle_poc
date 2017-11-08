package pages;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import cucumber.api.DataTable;
import util.ExcelReader;
import util.Property;

public class SearchFilterDNISOfferPage {

	SeleniumUtility utility = new SeleniumUtility();
	ExplicitConditionType explicitObj = new ExplicitConditionType();
	LocatorType locatorTypeObj = new LocatorType();
	File file;
	
	
	public void exportToExcel() {
		utility.pageLoadTimeout();
		utility.clickElement(locatorTypeObj.classtype, "exportToExcel_Btn");
	}
	
	public void verifyCreativeFile(){
		file = new File(Property.exportExcelPath + "DNIS-Offers.xls");
		System.out.println(file.getPath());
		assertTrue("Failed to Download Excel", file.exists());
	}
	
	public void verifyExcelCount(){
		if(file.exists()){
			ExcelReader eRObj = new ExcelReader();
			int rowCount = eRObj.getRowCount(Property.exportExcelPath + "DNIS-Offers.xls");
			
			// Get Count from Search Station Page
			String status = utility.getText(locatorTypeObj.classtype, "listCount");
			String count= status.substring(0, status.indexOf(" "));
			System.out.println("Excel Count: "+ rowCount + " ...stationCount: " + count);
			assertTrue("Record count mismatch between Excel and Search DNIS/Offer Page",rowCount==Integer.parseInt(count));
		}
	}
	
	public void fillSearchForm(DataTable values){
		Map<String,String> dnisOfferMap =values.asMap(String.class, String.class);
		
		String dnisGroup=dnisOfferMap.get("DNIS Group");
		String offerType=dnisOfferMap.get("Offer Type");
		String script = dnisOfferMap.get("Script");
		String offerCode = dnisOfferMap.get("Offer Code");	
		boolean dActive  = Boolean.valueOf(dnisOfferMap.get("DNIS Active"));
		boolean oActive = Boolean.valueOf(dnisOfferMap.get("Offer Active"));
		
		if(dnisGroup!=null){
			utility.enterText(locatorTypeObj.id, "dnisCode", dnisGroup);
		}
		// offerType
		if(offerType!=null){
			utility.selectValueFromDD(locatorTypeObj.id, "dnisOffer", offerType);
		}
		// offerCode
		if(offerCode!=null){
			utility.enterText(locatorTypeObj.id, "offerCode", offerCode);
		}
		// script
		if(script!=null){
			utility.enterText(locatorTypeObj.id, "script", script);
		}
		
		if(dActive){
			utility.clickElement(locatorTypeObj.id, "activeDnisOnly");
		}
		
		if(oActive){
			utility.clickElement(locatorTypeObj.id, "activeOfferOnly");
		}
	}
	
	public void verifyRecords(DataTable values){
		Map<String,String> dnisOfferMap =values.asMap(String.class, String.class);
		String dnisGroup=dnisOfferMap.get("DNIS Group");
		String offerType=dnisOfferMap.get("Offer Type");
		
		int rowCount = utility.getRowCount(locatorTypeObj.cssSelector, "div[id='searchResultList'] >div.list>table>tbody>tr>td:nth-of-type(1)");
		
		for (int i = 1 ;i<=rowCount;i++) {
			String dGroup = utility.getText(locatorTypeObj.cssSelector,"div[id='searchResultList'] >div.list>table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(2)");
			assertTrue(dnisGroup+" dGroupnot found instead found " +dnisGroup,dGroup.contains(dnisGroup));
			
			String oType = utility.getText(locatorTypeObj.cssSelector, "div[id='searchResultList'] >div.list>table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(8)");
			assertTrue(offerType+" not found instead found " +oType,oType.contains(offerType));
		}
	}
	
}
