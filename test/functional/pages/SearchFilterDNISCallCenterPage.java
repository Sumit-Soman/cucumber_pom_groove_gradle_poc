package pages;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.Map;
import cucumber.api.DataTable;
import util.ExcelReader;
import util.Property;

public class SearchFilterDNISCallCenterPage {

	SeleniumUtility utility = new SeleniumUtility();
	ExplicitConditionType explicitObj = new ExplicitConditionType();
	LocatorType locatorTypeObj = new LocatorType();
	File file;
	
	
	public void verifyExcelCount(){
		file = new File(Property.exportExcelPath + "DNIS-Offers.xls");
		
		if(file.exists()){
			ExcelReader eRObj = new ExcelReader();
			int rowCount = eRObj.getRowCount(Property.exportExcelPath + "DNISCallCenter.xls");
			
			// Get Count from Search Station Page
			String status = utility.getText(locatorTypeObj.classtype, "listCount");
			String count= status.substring(0, status.indexOf(" "));
			System.out.println("Excel Count: "+ rowCount + " ...stationCount: " + count);
			assertTrue("Record count mismatch between Excel and Search DNIS Call Center Page",rowCount==Integer.parseInt(count));
		}
	}
	
	public void fillSearchForm(DataTable values){
		Map<String,String> dnisCallCenterMap =values.asMap(String.class, String.class);
		
		String dnisGroup = dnisCallCenterMap.get("DNIS Group");
		String callCenter = dnisCallCenterMap.get("Call Center");
		String mediaType = dnisCallCenterMap.get("Media Type");
		boolean active  = Boolean.valueOf(dnisCallCenterMap.get("Active"));
		
		if(dnisGroup!=null){
			utility.enterText(locatorTypeObj.id, "code", dnisGroup);
		}
		// callCenter
		if(callCenter!=null){
			utility.enterText(locatorTypeObj.id, "callCenterShortName", callCenter);
		}
		// mediaType
		if(mediaType!=null){
			utility.selectValueFromDD(locatorTypeObj.id, "mediaBuyType", mediaType);
		}
		//active
		if(active){
			utility.clickElement(locatorTypeObj.id, "active");
		}
	}
	
	public void verifyRecords(DataTable values){
		Map<String,String> dnisCallCenterMap =values.asMap(String.class, String.class);
		String dnisGroup=dnisCallCenterMap.get("DNIS Group");
		String callCenter=dnisCallCenterMap.get("Call Center");
		String mediaType=dnisCallCenterMap.get("Media Type");
		
		int rowCount = utility.getRowCount(locatorTypeObj.cssSelector, "div[id='searchResultList'] >div.list>table>tbody>tr>td:nth-of-type(1)");
		
		for (int i = 1 ;i<=rowCount;i++) {
			String dGroup = utility.getText(locatorTypeObj.cssSelector,"div[id='searchResultList'] >div.list>table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(2)");
			assertTrue(dnisGroup + " dGroupnot found instead found " + dnisGroup,dGroup.contains(dnisGroup));
			
			String cCenter = utility.getText(locatorTypeObj.cssSelector, "div[id='searchResultList'] >div.list>table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(1)");
			assertTrue(callCenter + " not found instead found " + cCenter,cCenter.contains(callCenter));
			
			String mType = utility.getText(locatorTypeObj.cssSelector, "div[id='searchResultList'] >div.list>table>tbody>tr:nth-of-type("+i+")>td:nth-of-type(8)");
			assertTrue(mediaType + " not found instead found " + mType , mType.contains(mediaType));
		}
	}
		
}
