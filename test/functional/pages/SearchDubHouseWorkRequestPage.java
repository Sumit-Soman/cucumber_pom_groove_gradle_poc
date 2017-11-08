package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;

import cucumber.api.DataTable;

public class SearchDubHouseWorkRequestPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	public void enterDubHouseCreative(DataTable enterValues) {
		List<List<String>> val = enterValues.raw();
		// Enter Dub House
		utility.enterDropDownID("dubHouseId", val.get(1).get(1));
		// Enter Creative
		utility.enterTextBoxIDEsc("creativePscvrl", val.get(2).get(1));
	}

	public void verifyDubHouseCreative(DataTable verifyValues) {

		List<List<String>> val = verifyValues.raw();
		int limit = utility.getRowCount();

		// Verify Dubhouse
		utility.verifyColumn(val.get(1).get(1), 1, "Dub House", limit,"Search Dub House Work Request");
		// Verify Creative
		verifyColumnCreative(val.get(2).get(1), 5, "Creative", limit, "Search Dub House Work Request");

	}
	
	public void verifyColumnCreative(String value, int column, String message,
			int limit, String pageName) {

		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(
							By.xpath("//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();
			assertTrue("Results do not Match According to " + message,
			result.contains(value));
		}
	}
}
