package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;

public class SearchUnsourcedResponseDataPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void selectProductUniredTab(DataTable enterType) {
		List<List<String>> ev = enterType.raw();
		utility.enterTextAuto(locatorTypeObj.id, "productName", ev.get(1).get(1));
	}

	public void verifySearchResultProduct(DataTable verifyProductType) {
		List<List<String>> vT = verifyProductType.raw();
		int limit = getRowCountSearchUnsourcedResponseData();
		verifyColumnSearchUnsourcedResponseData(vT.get(1).get(1), 4,
				"product", limit);
	}

	public void openUnairedTab() {
		utility.clickElement(locatorTypeObj.id, "unairedTab");
	}

	public void verifyColumnSearchUnsourcedResponseData(String value,
			int column, String message, int limit) {

		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(
							By.xpath("//*[@id=\"unairedSearchResultList\"]/div[5]/div[2]/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();
			assertTrue("Results do not Match According to " + message,
			result.equals(value));
		}
	}

	public int getRowCountSearchUnsourcedResponseData() {
		// Wait added as Spinner is not used here
//		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		utility.sleep(2000);
		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"unairedSearchResultList\"]/div[5]/div[2]/table/tbody/tr"));

		return rows.size();
	}

}
