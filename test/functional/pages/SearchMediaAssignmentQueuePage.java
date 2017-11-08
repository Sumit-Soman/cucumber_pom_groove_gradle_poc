package pages;

import driver.DriverFactory;
import java.util.List;

import cucumber.api.DataTable;

public class SearchMediaAssignmentQueuePage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	
	public void enterStatus(DataTable enterValues) {

		List<List<String>> ev = enterValues.raw();
		// Status
		utility.enterDropDownID("status", ev.get(1).get(1));

	}
	public void verifyMediaAssignmentQueue(DataTable resultValues) {
		
		int limit = utility.getRowCount();

		List<List<String>> rv = resultValues.raw();
		// Status
		utility.verifyColumn(rv.get(1).get(1), 2, "Status", limit,"Search Media Assignment Queue");

	}

}