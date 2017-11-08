package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import util.*;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import java.io.File;

import cucumber.api.DataTable;

public class SearchCreativePage extends DriverFactory {

	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	
	File creativeFile=null;

	public void verifySearchPage() {
		 assertTrue(driver.findElement(By.id("searchResultList")).isDisplayed());
	}

	public void enterSearchCreativeDetails(DataTable enterValues) throws InterruptedException{
		String message=null;
		utility.pageLoadTimeout();
		do{
			Random random = new Random();
			int randomVersion = random.nextInt(999);
			
			List<List<String>> ev = enterValues.raw();
			
			// Media Type
			utility.enterDropDownID("mediaType", ev.get(1).get(1));
			// Product
			utility.enterTextBoxID("product", ev.get(2).get(1));
			// Show
			utility.enterTextBoxID("show", ev.get(3).get(1));
			// Region
			utility.enterDropDownID("region", ev.get(4).get(1));
			utility.enterTextBoxID("creativeVersion",String.valueOf(randomVersion));
			utility.clickElement(locatorTypeObj.id,"active");
			utility.clickElement(locatorTypeObj.id, "searchAction");
			//Get Status
			// 2 second of wait
			utility.sleep(2000);
			message = utility.getText(locatorTypeObj.classtype,"listCount");
			if(message.contains("No")){
				utility.clickElement(locatorTypeObj.id,"active");
				utility.clickElement(locatorTypeObj.id, "searchAction");
				Thread.sleep(2000);
				message = utility.getText(locatorTypeObj.classtype,"listCount");
			}
			Property.creativeVersion = randomVersion;
		}while(!message.contains("No"));
	}
	
	/*
	 * Description: Fill Search Creative form
	 * 
	 * */
	
	public void fillSearchCreativeForm(DataTable creativeDetails){
		Map<String,String> creativeMap =creativeDetails.asMap(String.class, String.class);
		String mediaType=creativeMap.get("Media Type");
		String product=creativeMap.get("Product");
		String show = creativeMap.get("Show");
		String region = creativeMap.get("Region");
		boolean active = Boolean.valueOf(creativeMap.get("Active"));
		String version = creativeMap.get("Version");
		Random random = new Random();
		int randomVersion = random.nextInt(999);
		// Media Type
		if(mediaType!=null){
			utility.enterDropDownID("mediaType", mediaType);
		}
		// Product
		if(product!=null){
			utility.enterTextBoxID("product", product);
		}
		// Show
		if(show!=null){
			utility.enterTextBoxID("show", show);
		}
		// Region
		if(region!=null){
			utility.enterDropDownID("region", region);
		}
		if(active){
			utility.clickElement(locatorTypeObj.id, "active");
		}
		if(version!=null){
			if(version.equalsIgnoreCase("Random")){
				utility.enterTextBoxID("creativeVersion",String.valueOf(randomVersion));
				Property.creativeVersion = randomVersion;
			}else if(version.equalsIgnoreCase("Property")){
				utility.enterTextBoxID("creativeVersion",String.valueOf(Property.creativeVersion));
			}else {
				utility.enterTextBoxID("creativeVersion",version);
				Property.creativeVersion = Integer.parseInt(version);
			}
		}
	}
	/*Description: click on Search button on Search creative Page.
	 */
	public void clickSearch(){
		utility.clickElement(locatorTypeObj.id, "searchAction");
	}
	
	/*Description: Get the Status on Search creative Page.
	 * 
	 * */
	public String getStatus(){
		utility.sleep(1000);
		return utility.getText(locatorTypeObj.classtype,"listCount");
	}
	
	
	public void enterMediaTypeProductShowRegion(DataTable enterValues) {
		utility.pageLoadTimeout();
		List<List<String>> ev = enterValues.raw();
		// Media Type
		utility.enterDropDownID("mediaType", ev.get(1).get(1));
		// Product
		utility.enterTextBoxID("product", ev.get(2).get(1));
		// Show
		utility.enterTextBoxID("show", ev.get(3).get(1));
		// Region
		utility.enterDropDownID("region", ev.get(4).get(1));
	}

	public void verifyMediaTypeProductShowRegion(DataTable resultValues) {

		int limit = utility.getRowCount();

		List<List<String>> rv = resultValues.raw();
		// Media Type
		utility.verifyColumn(rv.get(1).get(1), 6, "Media Type", limit,"Search Creative");
		// Product
		utility.verifyColumn(rv.get(2).get(1), 1, "Product", limit,"Search Creative");
		// Show
		utility.verifyColumn(rv.get(3).get(1), 2, "Show", limit,"Search Creative");
		// Region
		utility.verifyColumn(rv.get(4).get(1), 4, "Region", limit,"Search Creative");
	}

	public void clickCreative()// To click first creative of result
	{
		utility.clickElement(locatorTypeObj.xpath, "//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr[1]/td[1]");
	}

	public void clickTabHead(String value) {
		utility.pageLoadTimeout();
		String id = "";
		if (value.equals("Allowable"))
			id = "tab4";
		else if (value.equals("Dub Master"))
			id = "tab5";
		else if (value.equals("DNIS Group"))
			id = "tab6";
		else if (value.equals("Permissions & Translations"))
			id = "tab7";

		utility.clickElement(locatorTypeObj.id,id);
	}

	public void verifyTabIsDisplayed(String value) {
		utility.pageLoadTimeout();
		String id = "";
		if (value.equals("Creative Details"))
			id = "tabs-1";
		else if (value.equals("Allowable"))
			id = "tabs-4";
		else if (value.equals("Dub Master"))
			id = "tabs-5";
		else if (value.equals("DNIS Group"))
			id = "tabs-6";
		else if (value.equals("Permissions & Translations"))
			id = "tabs-7";

		assertTrue("Tab is not Verified",utility.isDisplayed(locatorTypeObj.id, id));
	}

	public void verifyCreative(){
		utility.sleep(2000);
		String version =utility.getText(locatorTypeObj.xpath, "//td[3]");
		assertTrue("Search Creative not found", version.equalsIgnoreCase(String.valueOf(Property.creativeVersion)));
	}
	
	public void exportToExcel() {
		utility.pageLoadTimeout();
		utility.clickElement(locatorTypeObj.classtype, "exportToExcel_Btn");
	}
	
	public void verifyCreativeFile(){
		creativeFile = new File(Property.exportExcelPath + "products.xls");
		assertTrue("Failed to Download Excel", creativeFile.exists());
	}
	
	public void verifyExcelCount(){
		if(creativeFile.exists()){
			ExcelReader eRObj = new ExcelReader();
			int rowCount = eRObj.getRowCount(Property.exportExcelPath + "products.xls");
			
			// Get Count from Search Creative Page
			String creativeCount = utility.getText(locatorTypeObj.classtype, "listCount").substring(0,3);
			assertTrue("Record count mismatch between Excel and Search Creative Page",rowCount==Integer.parseInt(creativeCount));
		}
	}
}
