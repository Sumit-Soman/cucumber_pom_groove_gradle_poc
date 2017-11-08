package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPayoutPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	ExplicitConditionType explicitobj = new ExplicitConditionType();
	LocatorType locObj = new LocatorType();

	public void verifySearchPayoutPage() {

		int limit = getRowCountSearchPayout();

		assertTrue("No Results Found on Search Payment Page", limit != 0);

		for (int i = 1; i <= limit; i++) {

			String result = driver
					.findElement(
							By.xpath("//*[@id=\"searchResultList\"]/div[3]/div[2]/table/tbody/tr["
									+ i + "]/td[" + 1 + "]")).getText();

			assertTrue("Results do not Match According to Agency",
					result.contains("PI"));

		}
	}

	public int getRowCountSearchPayout() {

		utility.explicitWait(explicitobj.elementisinvisible, locObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"searchResultList\"]/div[3]/div[2]/table/tbody/tr"));

		return rows.size();
	}
}
