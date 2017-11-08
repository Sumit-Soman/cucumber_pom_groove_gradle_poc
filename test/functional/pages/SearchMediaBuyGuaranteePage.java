package pages;

import driver.DriverFactory;
import java.util.List;
import cucumber.api.DataTable;

public class SearchMediaBuyGuaranteePage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	public void enterStation(DataTable enterValues) {
		List<List<String>> val = enterValues.raw();
		
		// Enter Station
		utility.enterTextBoxIDEsc("station", val.get(1).get(1));
	}

	public void verifyStation(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();

		int limit = utility.getRowCountSearchMediaBuy();
		// Verify Station
		utility.verifyColumnSearchMediaBuy(val.get(1).get(1), 1, "Station",
				limit,"Search MediaBuy Guarantee");
	}
}