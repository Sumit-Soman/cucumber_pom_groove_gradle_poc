package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;

import cucumber.api.DataTable;

public class TollFreeNumberRequestPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();
	
	public void enterStartDate(DataTable enterDate) {
		List<List<String>> eT = enterDate.raw();
		utility.enterTextBoxID("startDate", eT.get(1).get(1));
		
	}

	public void verifySearchResultTollFreeNumberStartDate(
			DataTable verifyStartDate) {

		List<List<String>> vSD = verifyStartDate.raw();
		int limit = utility.getRowCount();
		verifyDateColumn(vSD.get(1).get(1), 5, "Start Date", limit,"Toll Free Number Request");

	}
	
	public void verifyDateColumn(String sDate, int column, String message,
			int limit, String pageName) {

		// This object can interpret strings representing dates in the format
		// MM/dd/yyyy

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		assertTrue("No Results Found ", limit != 0);
		try {
			Date startDate = df.parse(sDate);

			for (int i = 1; i <= limit; i++) {
				String resultDate = driver
						.findElement(
								By.xpath("//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr["
										+ i + "]/td[" + column + "]"))
						.getText();

				// Convert from String to Date
				Date resultStartDate = df.parse(resultDate);
				Boolean isCorrectDate = ((1 == (resultStartDate
						.compareTo(startDate))) || (0 == (resultStartDate
						.compareTo(startDate))));
				assertTrue("Results do not Match According to " + message,
						isCorrectDate);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}