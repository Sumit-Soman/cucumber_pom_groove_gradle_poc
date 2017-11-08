package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneratePaymentRequestGuaranteePage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locObj = new LocatorType();
	ExplicitConditionType explicitobj = new ExplicitConditionType();

	public void verifySearchResultGeneratePaymentRequestGuarantee() {

		int limit = getRowCountGeneratePaymentRequestGuarantee();
		boolean resultCompare;
		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {
			
			String result = utility.getText(locObj.xpath, 
					"//*[@id=\"DataTables_Table_0_wrapper\"]/table/tbody/tr["+ i + "]/td[" + 3 + "]");


			resultCompare = result.contains("Station Direct");

			if (resultCompare == false) {
				String resultVendorName=utility.getText(locObj.xpath,
						"//*[@id=\"DataTables_Table_0_wrapper\"]/table/tbody/tr["+ i + "]/td[" + 2 + "]");

				assertFalse(resultVendorName.equals(""));

			} else {

				assertTrue("Results do not Match According to Agency",
						result.contains("Station Direct"));
			}
		}
	}

	public int getRowCountGeneratePaymentRequestGuarantee() {

		utility.explicitWait(explicitobj.elementisinvisible, locObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"DataTables_Table_0_wrapper\"]/table/tbody/tr"));

		return rows.size();
	}
}
