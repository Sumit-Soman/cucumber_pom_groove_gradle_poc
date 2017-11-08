package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import cucumber.api.DataTable;

public class SearchOfferConfiguration extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	public void selectProduct(DataTable enterType) {

		utility.pageLoadTimeout();
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[1]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='10-Minute Trainer'][@value='1']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[2]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='TWUK002'][@value='2007']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[3]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='10-Minute Trainer (134)'][@value='10-Minute Trainer (134)']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[4]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='MDTBBTMUK1'][@value='MDTBBTMUK1']");
		utility.enterDropDownCheckBox(
				"//*[contains(@class,'form form-horizontal')]/div[5]/div/button",
				"//*[contains(@class,'ui-multiselect-checkboxes ui-helper-reset')]/li/label/input[@title='TBB CLUB'][@value='3']");

	}

	public void verifySearchResultProduct(DataTable verifyProductType) {

		List<List<String>> val = verifyProductType.raw();

		int limit = utility
				.getRowCount("//*[contains(@class,'performanceTable searchResults form unbordered-input black-txt')]/tbody/tr/td[1]");

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
