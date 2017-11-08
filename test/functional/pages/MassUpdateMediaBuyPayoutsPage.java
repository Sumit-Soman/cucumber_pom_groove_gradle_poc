package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;

public class MassUpdateMediaBuyPayoutsPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void enterCreative(DataTable enterValues) {
		List<List<String>> val = enterValues.raw();
		// Enter Creative
		utility.enterTextBoxIDEsc("pscvrl", val.get(1).get(1));
	}

	public void verifyCreative(DataTable verifyValues) {

		List<List<String>> val = verifyValues.raw();

		int limit = getRowCountMassUpdatePayout();

		// Verify Product
		verifyColumnMassUpdatePayout(val.get(1).get(1), 7, "Creative", limit);
		// Verify Show
		verifyColumnMassUpdatePayout(val.get(2).get(1), 8, "Creative", limit);
	}

	public void verifyColumnMassUpdatePayout(String value, int column,
			String message, int limit) {
		for (int i = 1; i < limit; i++) {
			String result = driver.findElement(
					By.xpath("//*[@id=\"" + i + "\"]/td[" + column + "]"))
					.getText();

			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}

	public int getRowCountMassUpdatePayout() {
		
		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		int i = 0;
		try {
			for (;; i++) {
				WebElement w = driver.findElement(By.xpath("//*[@id=\"" + i
						+ "\"]/td[1]"));
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
		} finally {
			return i;
		}
	}
}