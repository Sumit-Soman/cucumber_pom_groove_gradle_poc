package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import cucumber.api.DataTable;

public class SearchLTVContinuityPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorObj = new LocatorType();

	public void selectProduct(DataTable enterType) {

		List<List<String>> val = enterType.raw();
		utility.pageLoadTimeout();
		
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[1]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='10-Minute Trainer'][@value='1']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[2]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='TV-Longform'][@value='TV-Longform']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[3]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='Beachbody Call Center'][@value='122']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[4]/div/button",
				"//input[@title='"+val.get(4).get(1)+"']");

		utility.clearText(locatorObj.cssSelector, "div[pui-model='ltvSearch.startDate'] input");
		utility.clearText(locatorObj.cssSelector, "div[pui-model='ltvSearch.endDate'] input");
	}

	public void verifySearchResultProduct(DataTable verifyProductType) {

		List<List<String>> val = verifyProductType.raw();

		int limit = utility
				.getRowCount("//*[contains(@class,'performanceTable searchResults form unbordered-input black-txt list')]/tbody/tr/td[1]");

		int column = 1;

		for (int i = 1; i <= limit; i++) {

			String result = driver
					.findElement(
							By.xpath("//*[contains(@class,'performanceTable searchResults form unbordered-input black-txt')]/tbody/tr/td["
									+ column + "]")).getText();

			assertTrue("Results do not Match According to File Type",
					(result.equalsIgnoreCase(val.get(1).get(1))));
		}

	}
}
