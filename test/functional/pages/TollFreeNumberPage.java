package pages;

import driver.DriverFactory;
import java.util.List;
import cucumber.api.DataTable;

public class TollFreeNumberPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();


	public void enterCreative(DataTable enterTollFreeValue) {
		utility.pageLoadTimeout();
		List<List<String>> etfnv = enterTollFreeValue.raw();

		// Creative
		utility.enterTextBoxID("multiPscvrls", etfnv.get(1).get(1));

	}

	public void verifyCreative(DataTable tollFreeResultValue) {

		int limit = utility.getRowCount();
		List<List<String>> tfrv = tollFreeResultValue.raw();

		// Product
		utility.verifyColumn(tfrv.get(1).get(1), 2, "Product", limit,"Toll Free Number");
	}
	

}