package pages;

import driver.DriverFactory;
import java.util.List;
import cucumber.api.DataTable;

public class SearchMediaBuyPIPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	public void enterMediaTypeCreative(DataTable enterValues) {
		List<List<String>> val = enterValues.raw();
		// Enter Media Type
		utility.enterDropDownID("mediaType", val.get(1).get(1));
		// Enter Creative
		utility.enterTextBoxIDEsc("pscvrls", val.get(2).get(1));
	}

	public void verifyMediaTypeCreative(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();

		int limit = utility.getRowCountSearchMediaBuy();
		if(SeleniumUtility.Internal) {
		// Verify Product
		utility.verifyColumnSearchMediaBuy(val.get(2).get(1), 5, "Creative",
				limit,"Search MediaBuy PI Page");
		// Verify Show
		utility.verifyColumnSearchMediaBuy(val.get(3).get(1), 6, "Creative",
				limit,"Search MediaBuy PI Page");
		}
		else {

			// Verify Product
			utility.verifyColumnSearchMediaBuy(val.get(2).get(1), 4, "Creative",
					limit,"Search MediaBuy PI Page");
			// Verify Show
			utility.verifyColumnSearchMediaBuy(val.get(3).get(1), 5, "Creative",
					limit,"Search MediaBuy PI Page");
		}
	}
}