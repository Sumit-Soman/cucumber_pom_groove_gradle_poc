package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;

public class SearchResponseDataPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void selectProduct(DataTable enterType) {
		List<List<String>> eT = enterType.raw();
		enterDropDownCheckBoxSearchResponseData(eT.get(1).get(1));
	}

	public void verifySearchResultProduct(DataTable verifyProductType) {
		List<List<String>> vT = verifyProductType.raw();
		int limit = getRowCountSearchResponseData();
		verifyColumnSearchResponseData(vT.get(1).get(1), 3, "product", limit);
	}
	
    public void enterDropDownCheckBoxSearchResponseData(String product) {
        utility.clickElement(locatorTypeObj.xpath,SeleniumUtility.SearchResponseDataSelectProduct);
        utility.clickElement(locatorTypeObj.xpath,"//span[contains(text(), '"+ product +"')]");
        utility.sendKeys(locatorTypeObj.xpath, SeleniumUtility.SearchResponseDataSelectProduct, "Keys.ESCAPE");
    }

  
	public void clearStarDate() {
		driver.findElement(By.id("startDate")).clear();
	}

	public int getRowCountSearchResponseData() {

		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver
				.findElements(By
						.xpath(SeleniumUtility.searchResponseResultXPath));
		return rows.size();

	}

	public void verifyColumnSearchResponseData(String value, int column,
			String message, int limit) {

		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(
							By.xpath(SeleniumUtility.searchResponseResultXPath +"["
									+ i + "]/td[" + column + "]")).getText();

			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}

}
