package pages;

import driver.DriverFactory;
import java.util.List;
import cucumber.api.DataTable;

public class SearchMediaBuyRegularPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	public void enterStatusCreative(DataTable enterValues) {

		List<List<String>> val = enterValues.raw();

		// Enter Status
		utility.enterDropDownCheckBox(
				"//*[@id=\"searchForm\"]/div[1]/div[1]/button",
				"//*[@id=\"ui-multiselect-statusList-option-0\"]");
		// Enter Creative
		utility.enterTextBoxIDEsc("pscvrls", val.get(2).get(1));
	}

	public void verifyStatusCreative(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();

		int limit = utility.getRowCountSearchMediaBuy();
		if (utility.Internal) {
			// Verify Product
			utility.verifyColumnSearchMediaBuy(val.get(2).get(1), 7,
					"Creative", limit,"Search MediaBuy Regular Page");
			// Verify Show
			utility.verifyColumnSearchMediaBuy(val.get(3).get(1), 8,
					"Creative", limit,"Search MediaBuy Regular Page");
		} else {
			// Verify Product
			utility.verifyColumnSearchMediaBuy(val.get(2).get(1), 6,
					"Creative", limit,"Search MediaBuy Regular Page");
			// Verify Show
			utility.verifyColumnSearchMediaBuy(val.get(3).get(1), 7,
					"Creative", limit,"Search MediaBuy Regular Page");
		}
    }
}