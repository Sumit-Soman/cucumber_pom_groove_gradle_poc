package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;

public class SearchTapesPage extends DriverFactory {
	
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();


	public void enterMediaTypeCreativeAgency(DataTable enterSearchTapesValues) {
		utility.pageLoadTimeout();
		
		List<List<String>> estv = enterSearchTapesValues.raw();
		// Media Type
		utility.enterDropDownID("mediaType", estv.get(1).get(1));
		// Creative
		utility.enterTextBoxID("multiCreativePscvrls", estv.get(2).get(1));
		// Agency
		if (SeleniumUtility.Internal) {
			utility.enterTextBoxID("mediaCompanyName", estv.get(3).get(1));
		}
	}

	public void verifyMediaType(DataTable searchTapesResultValues) {


		int limit = getRowCountTapes();
		List<List<String>> strv = searchTapesResultValues.raw();
		// product
		verifyColumnTapes(strv.get(1).get(1), 5, "Product", limit);

	}
	
	public void verifyColumnTapes(String value, int column, String message,
			int limit) {

		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {

			String result = driver
					.findElement(
							By.xpath("//*[@id='searchResultList']/div[@class='list']/*/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();

			assertTrue("Results do not Match According to " + message,
					result.contains(value));

		}
	}
	
	public int getRowCountTapes() {

		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id='searchResultList']/div[@class='list']/*/table/tbody/tr"));
		return rows.size();
	}
	
}