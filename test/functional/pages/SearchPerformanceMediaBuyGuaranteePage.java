package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;

public class SearchPerformanceMediaBuyGuaranteePage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void enterMediaTypeStationTypeCreativeRegion(DataTable enterValues) {
		List<List<String>> val=enterValues.raw();
		if(SeleniumUtility.Internal) {
		// Enter MediaType
		utility.enterDropDownCheckBox(
				"//*[@id=\"searchParent\"]/div[1]/div[2]/button",
				"//*[@id=\"ui-multiselect-mediaTypes-option-0\"]");
		// Enter Station Type
		utility.enterDropDownCheckBox(
				"//*[@id=\"searchParent\"]/div[5]/div[2]/button",
				"//*[@id=\"ui-multiselect-stationTypes-option-1\"]");
		// Enter Creative
		utility.enterTextBoxIDEsc("pscvrlmts",val.get(3).get(1));
		// Enter Region
		utility.enterDropDownCheckBox(
				"//*[@id=\"searchParent\"]/div[13]/div[2]/button",
				"//*[@id=\"ui-multiselect-countryIds-option-9\"]");
		}
		else {
			// Enter MediaType
			utility.enterDropDownCheckBox(
					"//*[@id=\"searchParent\"]/div[5]/div[2]/button",
					"//*[@id=\"ui-multiselect-mediaTypes-option-0\"]");
			// Enter Station Type
			utility.enterDropDownCheckBox(
					"//*[@id=\"searchParent\"]/div[9]/div[2]/button",
					"//*[@id=\"ui-multiselect-stationTypes-option-1\"]");
			// Enter Creative
			utility.enterTextBoxIDEsc("pscvrlmts",val.get(3).get(1));
			// Enter Region
			utility.enterDropDownCheckBox(
					"//*[@id=\"searchParent\"]/div[6]/div[2]/button",
					"//*[@id=\"ui-multiselect-countryIds-option-9\"]");
		}
	}

	public void verifyMediaTypeStationTypeCreativeRegion(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();
		
		int limit = getRowCountPerformanceGurantee();
		// Verify Agency
		verifyColumnPerformanceGurantee(val.get(3).get(1), 7, "Product",
				limit);
		verifyColumnPerformanceGurantee(val.get(4).get(1), 8, "Product",
				limit);
	}
	
	public void verifyColumnPerformanceGurantee(String value, int column,
			String message, int limit) {
		
		for (int i = 1; i <= limit; i++) {
			String result = driver.findElement(
					By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[" + i
							+ "]/td[" + column + "]")).getText();
			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}
	
	public int getRowCountPerformanceGurantee() {

		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']']",null );
		
		List<WebElement> rows = driver.findElements(By
				.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr"));

		return rows.size();
	}
}