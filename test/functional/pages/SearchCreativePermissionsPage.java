package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.ExcelReader;
import util.Property;
import cucumber.api.DataTable;

public class SearchCreativePermissionsPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();
	long t1;
	File CreativePermissionFile;

	public void enterMediaTypeProductShowRegionAgency(DataTable enterValues) {
		List<List<String>> ev = enterValues.raw();
		// Enter Media Type
		utility.enterDropDownID("mediaType", ev.get(1).get(1));
		// Enter Product
		utility.enterTextBoxID("product", ev.get(2).get(1));
		// Enter Show
		utility.enterTextAuto(locatorTypeObj.id, "show", ev.get(3).get(1));
		// Enter Region
		utility.enterDropDownID("region", ev.get(4).get(1));
		// Enter Agency
		if(SeleniumUtility.Internal) {
			utility.enterTextBoxIDEsc("mediaCompany", ev.get(5).get(1));
		}
	}
	public int getRowCount() {

		utility.explicitWait(explicitCondTypeobj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );

		List<WebElement> rows = driver.findElements(By
				.xpath("//*[@id=\"searchResultList\"]/div[2]/div[4]/table/tbody/tr"));
		return rows.size();
	}
	
	public void verifyMediaTypeProductShowRegionAgency(DataTable resultValues) {
		List<List<String>> rv = resultValues.raw();

		int limit = getRowCount();
		// Verify Media Type
		verifyColumn(rv.get(1).get(1), 6, "Media Type", limit);
		// Verify Product
		verifyColumn(rv.get(2).get(1), 1, "Product", limit);
		// Verify Show
		verifyColumn(rv.get(3).get(1), 2, "Show", limit);
		// Verify Region
		verifyColumn(rv.get(4).get(1), 4, "Region", limit);
		// Verify Agency
		verifyColumn(rv.get(5).get(1), 7, "Agency", limit);
	}
	
public void verifyColumn(String value, int column, String message, int limit) {
		
		assertTrue("No Creative Permission Record(s) found\n ", limit != 0);
	
		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(     
							By.xpath("//*[@id=\"searchResultList\"]/div[2]/div[4]/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();

			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}
	
	public void exportToExcel() {
		utility.pageLoadTimeout();
		utility.clickElement(locatorTypeObj.classtype, "exportToExcel_Btn");
	}

	public void verifyCreativePermissionFile() {
		CreativePermissionFile = new File(Property.exportExcelPath + "creativePermission.xls");
		assertTrue("Failed to Download Excel", CreativePermissionFile.exists());
	}

	public void verifyExcelCount() {
		if (CreativePermissionFile.exists()) {
			ExcelReader eRObj = new ExcelReader();
			int rowCount = eRObj.getRowCount(Property.exportExcelPath + "creativePermission.xls");
			
			// Get Count from Search Station Page
			String status = utility.getText(locatorTypeObj.classtype, "listCount");
			String count= status.substring(0, status.indexOf(" "));
			System.out.println("Excel Count: "+ rowCount + " ...CreativePermissionCount: " + count);
			assertTrue("Record count mismatch between Excel and Search Creative Permissions Page",rowCount==Integer.parseInt(count));
		}
	}


}
