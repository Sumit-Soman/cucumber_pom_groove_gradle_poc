package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;

public class MassUpdateMediaBuyRegularPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void enterCreative(DataTable enterValues) {
		List<List<String>> val = enterValues.raw();
		// Enter Creative
		utility.sleep(3000);
		utility.enterTextBoxIDEsc("creative",val.get(1).get(1));
	}

	public void verifyCreative(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();
		utility.sleep(3000);
		int limit = getRowCountMassUpdateMediaBuyRegular();
		
		// Verify Creative
		verifyColumnMassUpdateMediaBuyRegular(val.get(1).get(1), 4, "Creative",
				limit);
	}
	
	public void verifyColumnMassUpdateMediaBuyRegular(String value, int column,
			String message, int limit) {

		assertTrue("No Results Found ", limit != 0);
	
		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(
							By.xpath("//*[@id=\"pageBody\"]/div/div/div/div[1]/div[2]/div[3]/div[2]/form/table/tbody[2]/tr["
									+ i + "]/td[" + column + "]")).getText();

			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}
	

	public int getRowCountMassUpdateMediaBuyRegular() {

		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"pageBody\"]/div/div/div/div[1]/div[2]/div[3]/div[2]/form/table/tbody[2]/tr"));
		return rows.size();
	}
	
}