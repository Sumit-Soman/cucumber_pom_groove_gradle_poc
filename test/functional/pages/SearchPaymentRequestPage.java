package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPaymentRequestPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	ExplicitConditionType explicitobj = new ExplicitConditionType();
	LocatorType locObj = new LocatorType();

	public void verifySearchPaymentRequestPage() {
		utility.explicitWait(explicitobj.elementisinvisible, locObj.cssSelector, "img[id='spinner']",null );
		assertTrue("No Records found ", !utility.getText(locObj.classtype, "listCount").equalsIgnoreCase("No airings found."));
		
		int limit = getRowCountSearchPaymentRequest();

		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {

			String result = driver
					.findElement(
							By.xpath("//*[@id=\"searchResultList\"]/div[1]/div[2]/table/tbody/tr["
									+ i + "]/td[" + 3 + "]")).getText();

			assertTrue("Results do not Match According to Agency",
					result.contains("Regular"));

		}
	}

	public int getRowCountSearchPaymentRequest() {

		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"searchResultList\"]/div[1]/div[2]/table/tbody/tr"));

		return rows.size();
	}
}
