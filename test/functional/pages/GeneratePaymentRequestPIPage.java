package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneratePaymentRequestPIPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();
	

	public void verifySearchResultGeneratePaymentRequestPI() {

		int limit = getRowCountGeneratePaymentRequestPI();
		String vendorType="";
		assertTrue("No Results Found ", limit != 0);
		
		for (int i = 1; i <= limit; i++) {
			vendorType = utility.getText(locatorTypeObj.xpath, "//*[@id=\"DataTables_Table_0_wrapper\"]/table/tbody/tr["
					+ i + "]/td[" + 3 + "]");
			if(!vendorType.isEmpty()){
				assertTrue("Results do not Match According to Agency",vendorType.contains("Agency"));
			}
		}
	}

	public int getRowCountGeneratePaymentRequestPI() {
		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"DataTables_Table_0_wrapper\"]/table/tbody/tr"));

		return rows.size();
	}
}
