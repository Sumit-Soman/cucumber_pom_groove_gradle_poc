package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;

public class SearchMediaAssignmentsPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void enterCreativeAgencyMediaType(DataTable enterValues) {
		List<List<String>> val = enterValues.raw();
		// Enter Creative
		utility.enterTextBoxIDEsc("multiCreativePscvrls", val.get(1).get(1));
		// Enter Agency
		utility.enterTextBoxID("agencyName", val.get(2).get(1));
		// Enter Media Type
		utility.enterDropDownID("mediaType", val.get(3).get(1));
	}

	public void verifyCreativeAgencyMediaType(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();
		int limit = getRowCountMediaAssignment();
		// Verify Product
		verifyColumnMediaAssignment(val.get(1).get(1), 3, "Product", limit);
		// Verify Agency
		verifyColumnMediaAssignment(val.get(2).get(1), 9, "Agency", limit);
		// Verify Media Type
		verifyColumnMediaAssignment(val.get(3).get(1), 8, "Media Type", limit);
	}
	
	public void verifyColumnMediaAssignment(String value, int column,
			String message, int limit) {

		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(
							By.xpath("//*[@id=\"searchResultList\"]/div[3]/div[2]/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();
			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}
	public int getRowCountMediaAssignment() {

		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );

		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"searchResultList\"]/div[3]/div[2]/table/tbody/tr"));

		return rows.size();
	}
}