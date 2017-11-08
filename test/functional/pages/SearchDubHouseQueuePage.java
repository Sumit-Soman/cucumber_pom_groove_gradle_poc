package pages;

import driver.DriverFactory;
import java.util.List;


import cucumber.api.DataTable;

public class SearchDubHouseQueuePage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();

	
	public void enterDubHouseStatus(DataTable enterValues) {

		List<List<String>> ev = enterValues.raw();
		// DubHouse
		utility.enterDropDownID("dubHouseId", ev.get(1).get(1));
		//Status
		utility.enterDropDownID("status", ev.get(2).get(1));

	}
	public void verifyDubHouseStatus(DataTable resultValues) {
		
		int limit = utility.getRowCount();

		List<List<String>> rv = resultValues.raw();
		// DubHouse
		utility.verifyColumn(rv.get(1).get(1), 1, "Dub House", limit,"Dub House Queue");

	}

}